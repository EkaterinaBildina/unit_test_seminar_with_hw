# unit_test_seminar_with_hw

1st hw:

public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        // purchaseAmount - сумма покупки
        // discountAmount - размер скидки
        double sumWithDiscount = purchaseAmount-discountAmount;
        if (sumWithDiscount <= 0){
            throw new ArithmeticException("Скидка применена с ошибкой");
        };
        return sumWithDiscount; // Метод должен возвращать сумму покупки со скидкой
    }
  // HW01 Bildina E: В классе Calculator создайте метод calculateDiscount,
  // который принимает сумму покупки и процент скидки и возвращает сумму
  // с учетом скидки.
  // Задача - проверить этот метод с использованием библиотеки AssertJ.
  // Если метод calculateDiscount получает недопустимые аргументы,
  // он должен выбрасывать исключение ArithmeticException
        assert 9 == Calculator.calculatingDiscount(10,1);
        assertThat(Calculator.calculatingDiscount(10,1)).isEqualTo(9);


