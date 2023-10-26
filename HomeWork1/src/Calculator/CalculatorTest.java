package Calculator;

import static Calculator.Calculator.*;
import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    public static void main(String[] args) {
        // Проверка базового функционала с целыми числами:
        if (8 != Calculator.calculation(2, 6, '+')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (0 != Calculator.calculation(2, 2, '-')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (14 != Calculator.calculation(2, 7, '*')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (2 != Calculator.calculation(100, 50, '/')) {
            throw new AssertionError("Ошибка в методе");
        }

        // Случаи с неправильными аргументами
        // аргумент operator типа char, должен вызывать исключение, если он получает не базовые символы (+-*/)
        // try {
        //     seminars.first.Calculator.Calculator.calculation(8, 4, '_');
        // } catch (IllegalStateException e) {
        //     if (!e.getMessage().equals("Unexpected value operator: _")) {
        //         throw new AssertionError("Ошибка в методе");
        //     }
        // }

        // Проверка базового функционала с целыми числами, с использованием утверждений:
        assert 8 == Calculator.calculation(2, 6, '+');
        assert 0 == Calculator.calculation(2, 2, '-');
        assert 14 == Calculator.calculation(2, 7, '*');
        assert 2 == Calculator.calculation(100, 50, '/');

        // Проверка базового функционала с целыми числами, с использованием утверждений AssertJ:
//        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
//        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
//        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
//        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);

        // Проверка ожидаемого исключения, с использованием утверждений AssertJ:
//        assertThatThrownBy(() ->
//                Calculator.calculation(8, 4, '_')
//        ).isInstanceOf(IllegalStateException.class);

        System.out.println(Calculator.calculation(2_147_483_647, 1, '+')); // integer overflow
        System.out.println(squareRootExtraction(169));

        // Примерные решения домашних заданий из 1 лекции:

        // HW1.1: Придумайте и опишите (можно в псевдокоде) функцию извлечения корня и
        // необходимые проверки для него используя граничные случаи
        // assertThatThrownBy(() ->
        //         seminars.first.Calculator.Calculator.squareRootExtraction(0, 1, -1)
        // ).isInstanceOf(SomeStateException.class);

        // HW1.2: Как будет выглядеть проверка для случая деления на ноль? (с использованием AssertJ)
        // assertThatThrownBy(() ->
        //        seminars.first.Calculator.Calculator.calculation(5, 0, '/')
        // ).isInstanceOf(ArithmeticException.class);

        // HW1.3: Сравните одну и ту же проверку с использованием условий, ассертов, AssertJ
        // в каком случае стандартное сообщение об ошибке будет более информативным?
        // if (0 != seminars.first.Calculator.Calculator.calculation(2, 6, '+')) {
        //     throw new AssertionError("Ошибка в методе");
        // }
        //   assert 0 == seminars.first.Calculator.Calculator.calculation(2, 6, '+');
        //    assertThat(seminars.first.Calculator.Calculator.calculation(2, 6, '+')).isEqualTo(0);

        // Тесты для функции извлечения корня squareRootExtraction

        // Тест на извлечение корня из нуля, ождаемое значение = 0
        assertThat(squareRootExtraction(0)).isEqualTo(0);
        // Тест на извлечение корня из 10, результат - дробное значение, прверяем с точностью до тысячных, ождаемое значение = 3.1623
        assertThat(squareRootExtraction(10)).isEqualTo(3.162, offset(0.001));
        // Тест на извлечение корня из 25, результат - целое число, ождаемое значение = 5
        assertThat(squareRootExtraction(25)).isEqualTo(5);
        // Тест на извлечение корня из отрицательного числа, ожидаемый результат - выброс исключения IllegalArgumentException
        assertThatThrownBy(() ->
                squareRootExtraction(-7)
        ).isInstanceOf(IllegalArgumentException.class);

        // Тесты для функции вычисления суммы покупки со скидкой calculatingDiscount

        // Тест, цена товара - 150, скидка 50%, ожидаемая цена со скидкой - 75
        assertThat(calculatingDiscount(150, 50)).isEqualTo(75);
        // Тест, цена товара - 825, скидка 100%, ожидаемая цена со скидкой - 0
        assertThat(calculatingDiscount(825, 100)).isEqualTo(0);
        // Тест, цена товара - 200, скидка 0%, ожидаемая цена со скидкой - 200
        assertThat(calculatingDiscount(200, 0)).isEqualTo(200);
        // Тест, цена товара - 410, скидка 150%, ожидаем исключение ArithmeticException т.к. скидка более 100%
        assertThatThrownBy(() ->
                calculatingDiscount(410, 150)
        ).isInstanceOf(ArithmeticException.class);
        // Тест, цена товара - 50, скидка -5%, ожидаем исключение ArithmeticException т.к. скидка отрицательная
        assertThatThrownBy(() ->
                calculatingDiscount(50, -5)
        ).isInstanceOf(ArithmeticException.class);
    }
}