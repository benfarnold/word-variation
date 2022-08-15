package com.legyver.wordvariation;

import com.legyver.wordvariation.api.Maximizer;
import com.legyver.wordvariation.api.Tuple;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class Driver {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try (InputStream inputStream = Driver.class.getResourceAsStream("spellingdifferences_en_US_gb.properties")) {
            properties.load(inputStream);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        Maximizer maximizer = new Maximizer();
        List<Tuple> result = maximizer.maximize(properties);
        Collections.sort(result);
        File resultFile = new File("result.properties");
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(resultFile))) {
            for (Tuple tuple: result) {
                String line = tuple.getKey() + "=" + tuple.getValue() + "\n";
                byte[] input = line.getBytes(StandardCharsets.UTF_8);
                outputStream.write(input);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }
}
