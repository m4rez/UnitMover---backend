package com.markuvweb.unitmover.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StringExtractor {
    public String[] extractSno(String input) {

        String regex = "CZJ\\w{7}";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input.toUpperCase());

        ArrayList<String> extractedStringsArrayList = new ArrayList<>();

        while (matcher.find()) {
            extractedStringsArrayList.add(matcher.group());
        }

        return extractedStringsArrayList.toArray(new String [extractedStringsArrayList.size()]);
    }
}
