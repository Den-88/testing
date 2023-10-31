import hw.MainHW;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class Task2 {
    @ParameterizedTest
    @ValueSource(ints = {26, 50, 72, 80, 99})
    void inInterval(int n) {
        assertTrue(MainHW.numberInInterval(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 11, 25, 100, 163})
    void notInInterval(int n) {
        assertFalse(MainHW.numberInInterval(n));
    }
}
