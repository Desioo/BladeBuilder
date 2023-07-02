package com.example.bladebuilder.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RegexMapMatcher {

    private final Map<String, Map<String, Integer>> REGEX_ELEMENTS_INDEX_MAP = new HashMap<>();

    public RegexMapMatcher() {

        REGEX_ELEMENTS_INDEX_MAP.put("^\"(([\\d ]+\\\\t){2}\\d{4}-\\d{2}-\\d{2}\\\\t((.+)\\\\t){2}"
                + "(.+)\\\\t([\\d ,]+\\\\t){3}([A-Za-z\\d]{0,4})?\\n?)+\"$", Map.of("idSeq", 0, "seq", 1, "customer", 3,
                "description", 4, "invoiceNumber", 5, "thickness", 6,
                "width", 7, "location", 10, "ordersElementsLength", 11));

    }

    public Map<String, Map<String, Integer>> getRegexELementsIndexMap() {
        return REGEX_ELEMENTS_INDEX_MAP;
    }
}
