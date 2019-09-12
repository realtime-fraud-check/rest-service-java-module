package com.sturdy.sturdymem.service;

import org.springframework.web.multipart.MultipartFile;

public interface SturdyMemService {

    void saveToDictionary(MultipartFile file);

    boolean findIfTargetWordExists(String targetWord);
}
