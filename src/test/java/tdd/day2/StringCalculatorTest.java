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

    @Test
    void shouldReturnOneNumberForOneNumber() {
        //given
        String number = "1.23";
        //when
        String result = new StringCalculator().add(number);
        //then
        Assertions.assertEquals(number, result);
    }

    @Test
    void shouldSum3Numbers() {
        //given
        String numbers = "1.23,2.34,3.45";
        String expected = "7.02";
        //when
        String sum = new StringCalculator().add(numbers);
        //then
        Assertions.assertEquals(expected, sum);
    }
}
