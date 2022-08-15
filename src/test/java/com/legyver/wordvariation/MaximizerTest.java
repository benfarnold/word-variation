package com.legyver.wordvariation;

import com.legyver.wordvariation.api.Maximizer;
import com.legyver.wordvariation.api.Tuple;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class MaximizerTest {

    @Test
    public void sanitization() throws Exception {
        Properties properties = new Properties();
        try (InputStream inputStream = Driver.class.getResourceAsStream("spellingdifferences_en_US_gb.properties")) {
            properties.load(inputStream);
        }

        assertThat(properties.containsKey("sanitize")).isTrue();//basis
        assertThat(properties.containsKey("sanitization")).isFalse();//to be generated

        Maximizer maximizer = new Maximizer();
        List<Tuple> result = maximizer.maximize(properties);
        assertThat(result).contains(new Tuple("sanitization", "sanitisation"));
    }
}
