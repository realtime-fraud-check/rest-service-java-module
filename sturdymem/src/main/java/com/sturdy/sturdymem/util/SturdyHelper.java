package com.sturdy.sturdymem.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class SturdyHelper {


    public static List<String> parseFile(MultipartFile file){

        int fileSize = (int) file.getSize();
        String[] s = null;
//        BufferedReader br = new BufferedReader();
//        file.
        //TODO - implement methods
        try {
            InputStream inputStream = file.getInputStream();
//            BufferedReader buffer = new BufferedReader();
            StringBuilder sb = new StringBuilder();

            byte[] buf = new byte[fileSize];


            int data = inputStream.read();
            while (data != -1) {
                System.out.print((char) data);

                data = inputStream.read();
                sb.append((char) data);


            }

            s = sb.toString().split(" ");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null != s ? Arrays.asList(s) : null;

    }
}
