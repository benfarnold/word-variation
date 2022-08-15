package com.legyver.wordvariation.api.rules;

import com.legyver.wordvariation.api.Rule;
import com.legyver.wordvariation.api.Tuple;

import java.util.HashSet;
import java.util.Set;

/**
 * Rule to generate an -ization/-isation version of every -ize/-ise pair
 */
public class IzationRule implements Rule {
    @Override
    public Set<Tuple> apply(Tuple tuple) {
        Set<Tuple> result = new HashSet<>();
        String baseL = tuple.getKey().substring(0, tuple.getKey().length() - 1);
        String baseR = tuple.getValue().substring(0, tuple.getValue().length() -1);
        result.add(new Tuple(baseL + "ation", baseR + "ation"));
        return result;
    }
}
