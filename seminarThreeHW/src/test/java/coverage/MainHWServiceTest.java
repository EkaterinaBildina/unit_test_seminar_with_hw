package coverage;

import hw.MainHW;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MainHWServiceTest {

    // TEST for - Метод проверяет, является ли целое число записанное
    // в переменную n,
    // чётным (true) либо нечётным (false).


    MainHWService inputNum;
    @BeforeEach
    void setup() {
        inputNum = new MainHWService();
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


    // HW 3.2. Нужно написать метод который проверяет,
    // попадает ли переданное число в интервал (25;100)
    // и возвращает true, если попадает и false - если нет,
    // покрыть тестами метод на 100%


    @ParameterizedTest
    @ValueSource(ints = {25, 50, 99, 100})
    void ifInputNumInInterval(int n) {
        assertThat(inputNum.numberInInterval(n)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4,15, 20})
    void ifInputNumBefore25False(int n) {
        assertThat(inputNum.numberInInterval(n)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {101, 120, 500})
    void ifInputNumAfter100False(int n) {
        assertThat(inputNum.numberInInterval(n)).isFalse();
    }

}
