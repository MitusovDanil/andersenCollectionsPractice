import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.util.*;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class CollectionsPracticeTest {
    private static CollectionsPractice<String> coll;
    private static HashSet<String> set;
    private static List<String> strings;
    private static Helper helper;
    private static Properties properties;

    @BeforeAll
    static void setup() {
        coll = new CollectionsPractice<>();
        helper = new Helper();

        try {
            properties = helper.loadProperties("words-frequency.properties");
            strings = readWordsFromProperties();
            set = new HashSet<>(strings);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    @DisplayName("Тест метода CollectionsPractice.getCollectionWithoutDoublets()")
    void testGetCollectionWithoutDoublets() {
        assertEquals(set,
                coll.getCollectionWithoutDoublets(strings));
    }

    @Test
    @DisplayName("Тест метода CollectionsPractice.countRepetitions(List<T> list)")
    void testCountRepetitions() {
        assertRepetitions(coll.countRepetitions(strings));
    }

    private void assertRepetitions(Map<String, Integer> result) {
        if (result.isEmpty()) {
            fail();
        }

        for (Map.Entry<String, Integer> e : result.entrySet()) {
            boolean wordMatchWithProperty = Integer.valueOf(properties.getProperty(e.getKey())).equals(e.getValue());

            if (!wordMatchWithProperty) {
                fail();
            }
        }
    }

    private static List<String> readWordsFromProperties() {
        List<String> result = new ArrayList<>();

        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            int wordRepetition = Integer.parseInt(entry.getValue().toString());
            String word = entry.getKey().toString();

            if (wordRepetition == 1) {
                result.add(word);
            } else {
                IntStream.rangeClosed(1, wordRepetition).forEach(a -> result.add(word));
            }
        }

        return result;
    }


}
