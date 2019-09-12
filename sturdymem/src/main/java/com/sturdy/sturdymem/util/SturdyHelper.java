package com.sturdy.sturdymem.util;

import com.sturdy.sturdymem.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class SturdyHelper {

    static Logger logger = LoggerFactory.getLogger(SturdyHelper.class);
    public static List<String> parseFile(MultipartFile file){

        long fileSize = file.getSize();
        logger.debug("about to parse file of size {}", fileSize);
        String[] listOfWords = null;
        //TODO - implement methods
        try {
            InputStream inputStream = file.getInputStream();
            StringBuilder sb = new StringBuilder();
            int data = inputStream.read();
            while (data != -1) {
                data = inputStream.read();
                sb.append((char) data);
            }
            //split strings by space
            listOfWords = sb.toString().split(" ");

        } catch (IOException e) {
            logger.error("File Parse Error", e);
            throw new ServiceException("File Parse Error", e);
        }

        //return list of words
        return null != listOfWords ? Arrays.asList(listOfWords) : null;

    }
}
