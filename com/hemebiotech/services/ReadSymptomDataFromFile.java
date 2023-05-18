package com.hemebiotech.services;

import Interface.ISymptomReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * fileEpath varying is instanced as a string.
 * We call the ReadSymptomDataFromFile class and applied this on the varying
 * ReadSymptomDataFromFile class which are looking for ISymptomReader class.
 */


public class ReadSymptomDataFromFile implements ISymptomReader {
    /**
     * method getSymptom from the ReadsymptomDataFrom File class
     *
     */
    //
    @Override
    public List<String> getSymptoms() {
        ArrayList<String> result = new ArrayList<String>();
/**
 * Exception.
 * Is the filepath is NOT empty, 3 cases
 *      1- We do a loop and put the result of a readline in a varying line.
 *      2- We fail to interpretate => IO exception
 *      3- or else method return result

 */
        if (filepath != null) {
            try {
                BufferedReader reader = new BufferedReader (new FileReader(filepath)); //reading symptom.txt
                String line = reader.readLine();

                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
//

    private String filepath;

    /**
     * @param filepath created above
     * ReadSymptomDataFromFile class
     * @return access to the Symptom file
     */
    public ReadSymptomDataFromFile(String filepath) {
        this.filepath = filepath;
    }

}
