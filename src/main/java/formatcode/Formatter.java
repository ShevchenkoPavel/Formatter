package main.java.formatcode;

import java.io.FileReader;
import java.io.IOException;

/**
 * Reading file and formatting on rules Java.
 * Output in the console.
 */
class Formatter {
    static void format(String nameOfFile) throws IOException {

        FileReader reader = new FileReader(nameOfFile);
        int c;
        while((c=reader.read())!=-1){
            System.out.print((char)c);
            if (((char)c == (';') ) || ((char)c == ('}')))
            {System.out.print("\n");}
            if ((char)c == ('{'))
            {System.out.print("\n    ");}
        }
    }
}
