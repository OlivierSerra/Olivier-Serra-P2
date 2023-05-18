package com.hemebiotech.services;

import Interface.ISymptomReader;
import Interface.ISymptomWriter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

    /**
     *  object reader and writer
      */

    private final ISymptomReader reader;

    private final ISymptomWriter writer;

    /**
     *
     * @param reader and writer, instanced from IsymptomReader and ISymptomWriter interface
     * @return method to manipulate both list symptoms.txt and result.out
     * */
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer)
    {
        this.reader = reader;
        this.writer = writer;
    }
    /**
     *  @return extract from reader object the list of symptoms
     */
    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }
    /**
     * symptoms oraganised in a Map and sorted by symptoms
     * @param symptoms
     * @return Symptom as TreeMap
     */

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms)
    {
        return new TreeMap<>(symptoms);
    }

    /**
     * countsymptoms method on list of symptoms.
     * @return list is organized in a Map of string and Integer
      */

    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        /**
         * symptomCount =This map is injected in an object named symptomsCount
         */
        Map<String, Integer> symptomCount = new HashMap<>();
        /**
         * this loop take Symptom as key and for all the length
         * a counter is increasing one by one if it cross another time this kind of Symptom
         * Or else if this is the first time it cross the symptoms, it put 1
         * at the end loop is returning the map
         */
        for (String symptom : symptoms)
            {
            if (symptomCount.containsKey(symptom))
            {
                symptomCount.put(symptom, symptomCount.get(symptom) + 1);
            } else
            {
                symptomCount.put(symptom, 1);
            }

        }
        return symptomCount;
    }

    /**
     * writeSymptoms
     * @param Map of String and Integer
     * @return inject the object writer thanks to writeSymptoms method in the list
      */ 
    // object writer instanced from ISymptomWriter
    public void writeSymptoms(Map<String, Integer> symptoms) //
    {
        writer.writeSymptoms(symptoms);
    }
}

