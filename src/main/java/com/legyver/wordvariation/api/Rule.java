package com.legyver.wordvariation.api;

import java.util.Set;

public interface Rule {
    Set<Tuple> apply(Tuple tuple);
}
