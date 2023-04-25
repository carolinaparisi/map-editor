package org.academiadecodigo.bootcamp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextFile {

    private FileWriter fileWriter;

    public void createFile(){
        File file = new File("resources/saved.txt");
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write("This text is saved");
            fileWriter.close();

            System.out.println("Text saved");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void savePosition(String letter){
        try {
            fileWriter = new FileWriter(letter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
