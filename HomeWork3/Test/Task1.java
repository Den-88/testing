import hw.MainHW;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class Task1 {
    @ParameterizedTest
    @ValueSource(ints = {8, 60, 2, 14, 96})
    void evenNumber(int n) {
        assertTrue(MainHW.evenOddNumber(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 53, 9, 1, 77})
    void notEvenNumber(int n) {
        assertFalse(MainHW.evenOddNumber(n));
    }
}
