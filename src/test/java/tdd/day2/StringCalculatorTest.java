package tdd.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    void shouldReturnZeroForEmpty() {
        //given
        String empty = "";

        //when
        String result = new StringCalculator().add(empty);

        //then
        Assertions.assertEquals("0", result);
    }
}
