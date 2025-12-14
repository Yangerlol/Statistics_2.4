package ru.netology.stats;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatsServiceTest {

    // Исходные данные для всех тестов
    long[] sales = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};
    StatsService service = new StatsService();

    // 1. Тест на сумму всех продаж
    @Test
    void shouldCalculateSum() {
        int expected = 180;
        int actual = service.calculateSum(sales);

        Assertions.assertEquals(expected, actual);
    }

    // 2. Тест на среднюю сумму продаж
    @Test
    void shouldCalculateAverage() {
        int expected = 15; // 180 / 12 = 15
        int actual = service.calculateAverage(sales);

        Assertions.assertEquals(expected, actual);
    }

    // 3. Тест на месяц максимальных продаж (Последний при равенстве: 20 было в 8-м месяце)
    @Test
    void shouldFindMaxSalesMonth() {
        int expected = 8; // Продажи 20 были в 5-м и 8-м месяце. Должен вернуться последний - 8.
        int actual = service.findMaxSalesMonth(sales);

        Assertions.assertEquals(expected, actual);
    }

    // 4. Тест на месяц минимальных продаж (Последний при равенстве: 7 было только в 9-м месяце)
    @Test
    void shouldFindMinSalesMonth() {
        int expected = 9; // Продажи 7 были в 9-м месяце.
        int actual = service.findMinSalesMonth(sales);

        Assertions.assertEquals(expected, actual);
    }

    // 5. Тест на месяцы с продажами НИЖЕ среднего (Среднее = 15. Продажи: 8, 13, 7, 14, 14)
    @Test
    void shouldCountMonthsBelowAverage() {
        int expected = 5;
        int actual = service.countMonthsBelowAverage(sales);

        Assertions.assertEquals(expected, actual);
    }

    // 6. Тест на месяцы с продажами ВЫШЕ среднего (Среднее = 15. Продажи: 17, 20, 19, 20, 18)
    @Test
    void shouldCountMonthsAboveAverage() {
        int expected = 5;
        int actual = service.countMonthsAboveAverage(sales);

        Assertions.assertEquals(expected, actual);
    }
}