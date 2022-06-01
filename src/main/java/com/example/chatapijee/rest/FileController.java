package com.example.chatapijee.rest;

import com.example.chatapijee.dto.DownloadFileDto;
import com.example.chatapijee.dto.UploadFileDto;
import com.example.chatapijee.service.FileService;
import com.sun.istack.NotNull;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

@Path("file")
public class FileController {


    @Inject
    FileService fileService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String uploadFile(UploadFileDto uploadFileDto,
                             @NotNull @HeaderParam("username") String userName) {
        uploadFileDto.setSender(userName);
        return fileService.uploadFile(uploadFileDto);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadFile(@PathParam("id") long fileId, @QueryParam("receiver") String receiver) {
        DownloadFileDto file = fileService.downloadFile(fileId, receiver);
        if (file == null) {
            return Response.status(Response.Status.NOT_FOUND.getStatusCode(), "File doesn't exist or you don't have access.").build();
        }
        StreamingOutput stream = output -> output.write(file.getBytes());
        return Response.ok(stream, MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "inline; filename=\"" + file.getName() + "\"")
                .encoding("utf-8")
                .build();
    }
}
