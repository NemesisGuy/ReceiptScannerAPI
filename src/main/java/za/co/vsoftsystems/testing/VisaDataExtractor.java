package za.co.vsoftsystems.testing;

import java.util.regex.*;

import java.util.List;

public class VisaDataExtractor {
    public static void main(String[] args) {
        List<String> rawDataList = List.of(

        );

        for (String rawData : rawDataList) {
            extractName(rawData);
        }
    }

    private static void extractName(String rawData) {
        String pattern = "([A-Z]+( [A-Z]+)+)";

        Matcher matcher = Pattern.compile(pattern).matcher(rawData);

        while (matcher.find()) {
            String name = matcher.group(1);
            System.out.println("Name: " + name);
        }
    }
}