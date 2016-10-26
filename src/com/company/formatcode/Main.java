package com.company.formatcode;

import java.io.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
        char buf = 0;
        Formatter.Format(buf, "1.txt");
        //       System.out.println("Char: " +buf);
    }
}
