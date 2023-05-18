package com.hemebiotech.interface;

import java.util.List;

public interface ISymptomReader {
    /**
     * @return List of symptoms extract from symptoms.txt
     * no need to be sorted
     */
    List<String> getSymptoms();
    }



