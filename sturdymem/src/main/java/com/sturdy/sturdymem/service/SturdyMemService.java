package com.sturdy.sturdymem.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface SturdyMemService {

    public  void init();

    public  void saveToDictionary(MultipartFile file);

    public  Stream<Path> loadAll();

    public  Path load(String filename);

    public  Resource loadAsResource(String filename);

    public  void deleteAll();
}
