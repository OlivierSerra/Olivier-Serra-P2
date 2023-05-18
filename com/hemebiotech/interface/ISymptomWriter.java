
package com.hemebiotech.interface;

import java.util.Map;

public interface ISymptomWriter
{
    /**
     * No need to have a sorted map
     * @param symptoms
     * @return  new Map with symptoms name and number of occuration
     *
     */
    public void writeSymptoms(Map<String, Integer> symptoms);
}

