package com.legyver.wordvariation.api;

public class Tuple implements Comparable<Tuple> {
    private final String key;
    private final String value;

    public Tuple(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tuple tuple = (Tuple) o;

        return key.equals(tuple.key);
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public int compareTo(Tuple o) {
        return key.compareTo(o.key);
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
