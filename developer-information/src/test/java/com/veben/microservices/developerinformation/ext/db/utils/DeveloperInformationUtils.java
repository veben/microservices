package com.veben.microservices.developerinformation.ext.db.utils;

import com.veben.microservices.developerinformation.domain.DeveloperInformation;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.stream.Collectors;

public class DeveloperInformationUtils {

    public static DeveloperInformation[] insertExampleJson(String filePath) {
        String jsonTxt = extractStringJsonFromFile(filePath);

        return extractObjectsFromStringJson(jsonTxt);
    }

    private static DeveloperInformation[] extractObjectsFromStringJson(String jsonTxt) {
        DeveloperInformation[] developerInformations = null;
        try {
            developerInformations = new ObjectMapper().readValue(jsonTxt, DeveloperInformation[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return developerInformations;
    }

    private static String extractStringJsonFromFile(String filePath) {
        String stringJson = "";
        try {
            stringJson = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))
                    .lines()
                    .collect(Collectors.joining("\n"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stringJson;
    }
}
