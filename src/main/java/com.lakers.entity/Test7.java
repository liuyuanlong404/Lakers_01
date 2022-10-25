package com.lakers.entity;

import java.io.File;
import java.io.IOException;

/**
 * Created on 2022/10/8 15:10
 *
 * @author Lakers
 */
public class Test7 {

    public static void main(String[] args) throws IOException {
        File f = new File("..");
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());
        System.out.println(f.isDirectory());
        System.out.println(f.isFile());
        System.out.println(File.separator);
    }
}
