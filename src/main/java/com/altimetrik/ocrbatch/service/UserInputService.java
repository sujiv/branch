package com.altimetrik.ocrbatch.service;

import com.altimetrik.ocrbatch.entity.ApplicationDetails;
import com.altimetrik.ocrbatch.entity.FileStorage;
import com.altimetrik.ocrbatch.entity.UserInput;
import com.altimetrik.ocrbatch.repository.FileStorageRepository;
import com.altimetrik.ocrbatch.repository.UserInputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class UserInputService {

    @Autowired
    private UserInputRepository userInputRepository;

    public ApplicationDetails mapMissingDetails(ApplicationDetails appDetails, FileStorage fileStorage) {

        Optional<UserInput> userInputOptional = userInputRepository.findById(fileStorage.getUserInputId());
        UserInput userInput = userInputOptional.orElseGet(null);
        
        return appDetails;
    }
}