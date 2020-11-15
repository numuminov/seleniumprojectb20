package com.cybertek.tests.day14_exel_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadTextFile {
    public static void main(String[] args) throws FileNotFoundException {
        String path ="soppingliist.txt";
        File file=new File(path);
        System.out.println(file.exists());

        Scanner scanner=new Scanner(file);
        while (scanner.hasNext())
        System.out.println(scanner.nextLine());
    }
}
