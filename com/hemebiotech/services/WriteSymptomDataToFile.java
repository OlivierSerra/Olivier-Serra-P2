package com.hemebiotech.services;

import Interface.ISymptomWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
//import java.util.Map.Entry;
//import java.util.logging.Level;
//import java.util.logging.Logger;


public class WriteSymptomDataToFile implements ISymptomWriter {
    /**
     * 1- We create a new object named writer and we inject inside the result from Outputlist result.out.
     * @param symptoms
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
    /**
    *3 cases for Exception
     * This file organization AS a list of Symptom and number of Symptoms =symptoms.entrySet()
     * Object write shape with
     *           1- the key = symptom
     *           2- the value =nb od occuration
     * If manage integration=0, the system return an exception
     *  else: it return a failure error.
    */
        try (FileWriter writer = new FileWriter(("result.out")))
        {
            for (Map.Entry<String, Integer> symptom : symptoms.entrySet())
            {
                writer.write(symptom.getKey() + " : " + symptom.getValue() + "\n");
            }
        } catch (IOException e)
        {
            System.err.println("Erreur lors de l'écriture du fichier");
            e.printStackTrace();
        }
    }
}