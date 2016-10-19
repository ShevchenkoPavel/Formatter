package com.company.Formatcode;

import java.io.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created by Admin on 13.05.2016.
 */
public class IReader {

    static char IRead(char count, String nameoffile)
    {

        try(BufferedReader br = new BufferedReader (new FileReader(nameoffile)))
        {
            // чтение посимвольно
            int c;
            while((c=br.read())!=-1){
                count = (char)c;
                System.out.print((char)c);
                if ((count == 59 ) || (count == 125))
                {System.out.print("\n");}
                if (count == 123)
                {System.out.print("\n    ");}

            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        return count;
    }

}

// Endclass

