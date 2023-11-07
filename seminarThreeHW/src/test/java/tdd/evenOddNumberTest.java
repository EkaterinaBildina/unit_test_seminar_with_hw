package tdd;

import hw.MainHW;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class evenOddNumberTest {

    // TEST for - Метод проверяет, является ли целое число записанное
    // в переменную n,
    // чётным (true) либо нечётным (false).


    MainHW inputNum;
    @BeforeEach
    void setup() {
        inputNum = new MainHW();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8})
    void ifEvenNumberReturnTrue(int n) {
        assertThat(inputNum.evenOddNumber(n)).isTrue();
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7})
    void ifOddNumberReturnFalse(int n) {
        assertThat(inputNum.evenOddNumber(n)).isFalse();
    }
}
