package com.sturdy.sturdymem.dao;

import org.springframework.web.multipart.MultipartFile;

public interface SturdyDao {

    public boolean save(MultipartFile multipartFile);

    public boolean update(MultipartFile multipartFile);

    public boolean delete(String fileName);

    public MultipartFile get(String fileName);



}
