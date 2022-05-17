package com.example.chatapijee.rest;

import com.example.chatapijee.model.FileUpload;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Path("file")
public class FileController {


    @POST
    @Path("upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(MultipartFormDataInput file) throws IOException {

        InputPart inputPart = file.getFormDataMap().get("file").get(0);
        InputStream uploadedInputStream = inputPart.getBody(InputStream.class, null);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;

        while ((len = uploadedInputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, len);
        }

        FileUpload upload = new FileUpload();
        return Response.ok().build();
        }

        @GET
        @Path("/download")
        @Produces(MediaType.APPLICATION_OCTET_STREAM)
        public Response downloadFile(@QueryParam("file") String file) {
            System.out.println("Download file "+file);
            File fileDownload = new File(System.getProperty("user.home") + File.separator + file);
            Response.ResponseBuilder response = Response.ok((Object) fileDownload);
            response.header("Content-Disposition", "attachment;filename=" + file);
            return response.build();
        }
    }
