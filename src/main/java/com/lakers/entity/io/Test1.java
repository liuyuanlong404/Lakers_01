package com.lakers.entity.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created on 2022/10/8 16:38
 *
 * @author Lakers
 */
public class Test1 {

    public static void main(String[] args) throws IOException {
        byte[] bytes = "Hello,World!".getBytes(StandardCharsets.UTF_8);
        try(CountInputStream input = new CountInputStream(new ByteArrayInputStream(bytes))){
            int n;
            while ((n = input.read()) != -1) {
                System.out.println((char)n);
            }
            System.out.println("Total read " + input.getBytesRead() + " bytes");
        }
    }
}
