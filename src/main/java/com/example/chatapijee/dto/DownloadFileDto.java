package com.example.chatapijee.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class DownloadFileDto {
    String name;
    byte[] bytes;
}
