import interface.ISymptomReader;
import interface.ISymptomWriter;
import services.ReadSymptomDataFromFile;
import services.AnalyticsCounter;
import Services.WriteSymptomDataToFile;

import java.util.Map;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        /**
         * object reader from IsymptomReader named  and
         * put inside the result from ReadSymptomDataFromFile method
         */
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        /**
         * object writer from ISymptomWriter class
         * and put inside the result from WriteSymptomDataToFile() method
         */
        ISymptomWriter writer = new WriteSymptomDataToFile(); //

        /**
         * object analyticsCounter from analyticsCounter Class
         * @param reader in order to count symptoms
         * @param writer in order to inject the number of symptoms occuration
         */
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
        /**
         * @return GetSymptoms => list of symptoms in order to have acces to Symptoms list
         */
        List<String> symptoms = analyticsCounter.getSymptoms();
        /**
         * @return Map of symptoms + number occuration
         */
        Map<String, Integer> countedSymptoms = analyticsCounter.countSymptoms(symptoms);
        /**
         * @param CountedSymptoms from method above
         * @return a map sort by number occuration
          */
        Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(countedSymptoms);
        /**
         * @param sortedSymptoms for countedSymptoms
         * @return a sorted map where injection of symptoms
         */
        analyticsCounter.writeSymptoms(sortedSymptoms);

    }
}

