package com.epam.mjc.nio;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        System.out.println(fileReader.getDataFromFile(new File("/home/akbar/akbarDev/mjc/stage1/module7/stage1-module7-nio-task1/src/main/resources/Profile.txt")));
    }
}
