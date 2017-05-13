package edu.cpp.awh.easyabc.data;

import android.content.Context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import edu.cpp.awh.easyabc.model.User;

public abstract class FileManager {
    private static final String FILE_NAME = "easyabc.json";
    public static void saveData(User u, Context context) {
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(context.getFilesDir(), FILE_NAME), u);

            /*File temp = new File(context.getFilesDir(), FILE_NAME);
            Scanner file = new Scanner(temp);
            while(file.hasNext()) {
                System.out.println(file.nextLine());
            }*/
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static User loadData(User u, Context context) {
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(context.getFilesDir(), FILE_NAME);
            if(!file.exists()) {
                u = new User();
            }
            else {
                u = mapper.readValue(file, User.class);
            }

            /*File temp = new File(context.getFilesDir(), FILE_NAME);
            Scanner file2 = new Scanner(temp);
            while(file2.hasNext()) {
                System.out.println(file2.nextLine());
            }*/

            return u;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
