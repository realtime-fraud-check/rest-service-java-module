package com.sturdy.sturdymem.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class SturdyDaoImpl implements  SturdyDao {

    @Override
    public boolean save(MultipartFile multipartFile) {
        return false;
    }

    @Override
    public boolean update(MultipartFile multipartFile) {
        return false;
    }

    @Override
    public boolean delete(String fileName) {
        return false;
    }

    @Override
    public MultipartFile get(String fileName) {
        return null;
    }
}
