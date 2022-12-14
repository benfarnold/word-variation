# word-variation
generate missing variations for text in us-uk dictionary

## Usage
1. Change the **Driver** application to point to the properties file you want to load
2. Run the **Driver** application
3. **result.properties** in the project root will contain the file with additional variations

## Examples
Look at the Maximizer test for an example
```java
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
```