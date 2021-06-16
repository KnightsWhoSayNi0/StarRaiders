package src.engine.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtil {

    public static String loadAsString(String path) {
        StringBuilder result = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Class.class.getResourceAsStream(path)))) { // TODO this does not work and must be fixed
            String line = "";
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Couldn't find file specified at " + path);
            e.printStackTrace();
        }

        return result.toString();
    }

}
