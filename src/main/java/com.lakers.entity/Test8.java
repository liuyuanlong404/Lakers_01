package com.lakers.entity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created on 2022/10/8 16:06
 *
 * @author Lakers
 */
public class Test8 {

    public static void main(String[] args) throws IOException {
        try (InputStream input = new FileInputStream("src/readme.txt")) {
            System.out.println(readAsString(input));
        }catch (IOException ignored){

        }

        try (OutputStream output = new FileOutputStream("src/readme.txt")) {
            output.write("java从入门到放弃!!!".getBytes(StandardCharsets.UTF_8));
        }catch (IOException ignored){

        }
    }

    public static String readAsString(InputStream input) throws IOException {
        int n;
        StringBuilder sb = new StringBuilder();
        while ((n = input.read()) != -1) {
            sb.append((char) n);
        }
        return sb.toString();
    }
}
