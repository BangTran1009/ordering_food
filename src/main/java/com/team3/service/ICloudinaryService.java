package com.team3.service;

import org.springframework.web.multipart.MultipartFile;

public interface ICloudinaryService {
    public String uploadFile(MultipartFile file, String folderName);
}
