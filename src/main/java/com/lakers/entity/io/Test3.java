package com.lakers.entity.io;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

/**
 * Created on 2022/10/9 10:28
 *
 * @author Lakers
 */
public class Test3 {

    public static void main(String[] args) throws Exception {
//        try (Writer writer = new FileWriter("src/readme.txt", StandardCharsets.UTF_8)) {
//            writer.write('H'); // 写入单个字符
//            writer.write("Hello\n".toCharArray()); // 写入char[]
//            writer.write("Hello\n"); // 写入String
//        }

        try (Writer writer = new OutputStreamWriter(new FileOutputStream("src/readme.txt"), StandardCharsets.UTF_8)) {
            // TODO:
            writer.write('A'); // 写入单个字符
            writer.write("Hello\n".toCharArray()); // 写入char[]
            writer.write("Hello\n"); // 写入String
        }
    }
}
