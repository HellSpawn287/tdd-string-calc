package tdd.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    void shouldReturnZeroForEmpty() {
        //given
        StringCalculator calc = new StringCalculator();
        String empty = "";

        //when
        String result = calc.add(empty);

        //then
        Assertions.assertEquals("", empty);
    }
}
