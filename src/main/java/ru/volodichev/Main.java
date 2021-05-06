package ru.volodichev;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args){

        FileHandler fileHandler = new FileHandler();
        File file = new File("C:\\testDir");
        try {
            fileHandler.getAllNamesToFile(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
