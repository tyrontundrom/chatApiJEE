package com.example.chatapijee.service;

import com.example.chatapijee.dto.DownloadFileDto;
import com.example.chatapijee.dto.JmsMessageDto;
import com.example.chatapijee.dto.MessageType;
import com.example.chatapijee.dto.UploadFileDto;
import com.example.chatapijee.repository.FileRepoList;

import javax.inject.Inject;
import javax.transaction.Transactional;

public class FileService {

    @Inject
    private JmsMessageService jmsMessageService;

    private static FileRepoList fileRepoList = new FileRepoList();


    @Transactional
    public String uploadFile(UploadFileDto fileDto) {
        jmsMessageService.sendJmsMessage(mapToJmsMessage(fileDto));
        return "pobieranie ukończone";
    }

    private JmsMessageDto mapToJmsMessage(UploadFileDto fileDto) {
        String link = String.format("http://localhost:8080/chatApiJEE_war_exploded/api/file/", fileDto.getReceiver());
        return JmsMessageDto.builder()
                .messageType(MessageType.PRIVATE)
                .text(String.format("download %s", link))
                .build();
    }

    public DownloadFileDto downloadFile(long fileId, String receiver) {
        return DownloadFileDto.builder()
                .build();
    }
}
