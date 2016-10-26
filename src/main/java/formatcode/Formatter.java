package main.java.formatcode;

import java.io.FileReader;
import java.io.IOException;

/**
 * Reading file and formatting on rules Java.
 * Output in the console.
 */
class Formatter {
    static char format(char count, String nameoffile) throws IOException {

        FileReader reader = new FileReader(nameoffile);
            int c;
            while((c=reader.read())!=-1){
                count = (char)c;
                System.out.print((char)c);
                if ((count == (';') ) || (count == ('}')))
                {System.out.print("\n");}
                if (count == ('{'))
                {System.out.print("\n    ");}
            }
        return count;
    }
}
