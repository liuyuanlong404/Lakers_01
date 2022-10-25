package com.lakers.entity.io;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

/**
 * Created on 2022/10/9 10:09
 *
 * @author Lakers
 */
public class Test2 {

    public static void main(String[] args) throws Exception {
        try (Reader reader = new FileReader("src/readme.txt", StandardCharsets.UTF_8)) {
            char[] buffer = new char[1024];
            int n;
            while ((n = reader.read(buffer)) != -1) {
                System.out.println(n);
            }
        }

        try (Reader reader = new InputStreamReader(new FileInputStream("src/readme.txt"), StandardCharsets.UTF_8)) {
            // TODO:
            char[] buffer = new char[1024];
            int n;
            while ((n = reader.read()) != -1) {
                System.out.println((char) n);
            }
        }
    }
}
