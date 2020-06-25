package Utility;

import java.io.*;
import java.util.Scanner;

/**
 * The type Reader from file.
 */
public class ReaderFromFile {

    /**
     * Read from file string.
     *
     * @param filename the filename
     * @return the string
     * @throws FileNotFoundException the file not found exception
     */
    public String readFromFile(String filename) throws FileNotFoundException {
        try {
            String data = "";
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
                data += scanner.nextLine().trim() + "\n";
            scanner.close();
            WriterToFile.setFilename(filename);
            return data;
        } catch (FileNotFoundException | NullPointerException e) {
                System.out.println("Не удалось найти заданную переменную окружения.");
            return null;
        }
    }
}