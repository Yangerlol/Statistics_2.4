package ru.netology.stats;

public class StatsService {

    // 1. Сумма всех продаж
    public int calculateSum(long[] sales) {
        int sum = 0;
        for (long sale : sales) {
            sum += sale;
        }
        return sum;
    }

    // 2. Средняя сумма продаж в месяц
    public int calculateAverage(long[] sales) {
        // Используем метод 1 для получения общей суммы
        int sum = calculateSum(sales);
        // Деление на количество элементов
        return sum / sales.length;
    }

    // 3. Номер месяца, в котором был пик продаж (МАКСИМУМ, последний)
    // Требование: найти последний месяц, соответствующий условиям.
    public int findMaxSalesMonth(long[] sales) {
        int maxMonth = 0; // Индекс месяца с максимальными продажами
        int month = 0;    // Текущий индекс месяца

        for (long sale : sales) {
            // Если продажи в текущем месяце БОЛЬШЕ ИЛИ РАВНЫ максимальным,
            // то запоминаем текущий месяц (так мы находим последний месяц при равенстве)
            if (sale >= sales[maxMonth]) {
                maxMonth = month;
            }
            month = month + 1;
        }
        // Возвращаем номер месяца (индекс + 1)
        return maxMonth + 1;
    }

    // 4. Номер месяца, в котором был минимум продаж (МИНИМУМ, последний)
    // Требование: найти последний месяц, соответствующий условиям.
    public int findMinSalesMonth(long[] sales) {
        int minMonth = 0; // Индекс месяца с минимальными продажами
        int month = 0;    // Текущий индекс месяца

        for (long sale : sales) {
            // Если продажи в текущем месяце МЕНЬШЕ ИЛИ РАВНЫ минимальным,
            // то запоминаем текущий месяц (так мы находим последний месяц при равенстве)
            if (sale <= sales[minMonth]) {
                minMonth = month;
            }
            month = month + 1;
        }
        // Возвращаем номер месяца (индекс + 1)
        return minMonth + 1;
    }

    // 5. Кол-во месяцев, в которых продажи были ниже среднего
    public int countMonthsBelowAverage(long[] sales) {
        int average = calculateAverage(sales); // Среднее
        int count = 0;

        for (long sale : sales) {
            if (sale < average) {
                count++;
            }
        }
        return count;
    }

    // 6. Кол-во месяцев, в которых продажи были выше среднего
    public int countMonthsAboveAverage(long[] sales) {
        int average = calculateAverage(sales); // Среднее
        int count = 0;

        for (long sale : sales) {
            if (sale > average) {
                count++;
            }
        }
        return count;
    }
}