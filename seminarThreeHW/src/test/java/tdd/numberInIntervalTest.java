package tdd;

import hw.MainHW;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class numberInIntervalTest {
    // HW 3.2. Нужно написать метод который проверяет,
    // попадает ли переданное число в интервал (25;100)
    // и возвращает true, если попадает и false - если нет,
    // покрыть тестами метод на 100%

    MainHW inputNum;
    @BeforeEach
    void setup() {
        inputNum = new MainHW();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 25, 50, 99, 100, 140})
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
