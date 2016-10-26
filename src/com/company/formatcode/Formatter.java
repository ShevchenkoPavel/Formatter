package com.company.formatcode;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by pavel on 10/26/16.
 */
public class Formatter {
    static char Format(char count, String nameoffile)
    {
        try(FileReader reader = new FileReader(nameoffile))
        {
            // чтение посимвольно
            int c;
            while((c=reader.read())!=-1){
                count = (char)c;
                System.out.print((char)c);
                if ((count == (';') ) || (count == ('}')))
                {System.out.print("\n");}
                if (count == ('{'))
                {System.out.print("\n    ");}
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return count;
    }
}
