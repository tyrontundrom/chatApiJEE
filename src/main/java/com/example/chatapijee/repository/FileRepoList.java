package com.example.chatapijee.repository;

import com.example.chatapijee.model.FileModel;
import com.example.chatapijee.model.Message;

import java.util.ArrayList;
import java.util.List;

public class FileRepoList {

    private List<FileModel> files = new ArrayList<>();

    public long save(FileModel file) {
        files.add(file);
        return file.getId();
    }
}
