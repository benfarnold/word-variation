package com.legyver.wordvariation.api;

import com.legyver.wordvariation.api.rules.IzationRule;

import java.util.*;

/**
 * Take properties of existing US-GB words and generate missing variations for completeness
 */
public class Maximizer {
    public List<Tuple> maximize(Properties properties) {
        //need a set for uniqueness
        Set<Tuple> result = new HashSet<>();
        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            Tuple original = new Tuple(key, value);
            result.add(original);
            Rule rule = lookupRule(key);
            if (rule != null) {
                Set<Tuple> variations = rule.apply(original);
                for (Tuple variation: variations) {
                    //safer to check against original properties because we don't want generated properties usurping original
                    if (!properties.containsKey(variation.getKey())) {
                        result.add(variation);
                    }
                }
            }
        }
        //need a list for sorting
        return new ArrayList<>(result);
    }

    private Rule lookupRule(String word) {
        if (word.endsWith("ize")) {
            return new IzationRule();
        }
        return null;
    }
}
