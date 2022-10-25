package com.lakers.entity.io;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Created on 2022/10/9 10:45
 *
 * @author Lakers
 */
public class Test4 {

    public static void main(String[] args) throws Exception {
        byte[] data = Files.readAllBytes(Path.of("src/readme.txt"));
        // 默认使用UTF-8编码读取:
        String content1 = Files.readString(Path.of("src/readme.txt"));
        // 可指定编码:
        String content2 = Files.readString(Path.of("src",  "readme.txt"), StandardCharsets.ISO_8859_1);
        // 按行读取并返回每行内容:
        List<String> lines = Files.readAllLines(Path.of("src/readme.txt"));
    }
}
