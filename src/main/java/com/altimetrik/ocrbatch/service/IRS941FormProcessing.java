package com.altimetrik.ocrbatch.service;

import com.altimetrik.ocrbatch.repository.FileStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IRS941FormProcessing {

    @Autowired
    private FileStorageRepository fileStorageRepository;

    public List<FileStorageRepository> getAllUnProcessedRecords(){



        return null;
    }

}
