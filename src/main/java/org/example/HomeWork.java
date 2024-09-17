package org.example;

import java.util.function.Predicate;

/**
 * Сигнатуры методов в данном классе не менять
 */
public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Реализовать метод, который подсчитывает количество подходящих по условию узлов от 0 до N.
     * <br/>
     * Пример 1:
     * список 1, 2, 3, 4, 5
     * условие x < 4
     * ответ 3
     * <br/>
     * Пример 2:
     * список 1, 2, 3, 4, 5
     * условие x < 0
     * ответ 0
     *
     * @param list односвязный список
     * @param pred условие
     * @param <T>  - тип хранимых значений в списке
     * @return количество узлов от 0 до N, где N позиция на которой первый раз условие вернуло fals
     */
    public <T> int partitionBy(Node<T> list, Predicate<T> pred) {

        int size = 0;
        // Проверим, что условие введено, если нет сразу вернем 0
        if (pred != null) {
            while (list != null) {
                int y = (int) list.getValue();
                if (pred.test(list.getValue())) {
                    size++;
                } else {
                    // При первой неудаче выходим из цикла и возвращаем полученный размер
                    break;
                }
                list = list.getNext();
            }
        }

        return size;
    }

    /**
     * <h1>Задание 2.</h1>
     * Реализовать метод поиска элемента на позиции N в переданном односвязном списке.
     *
     * @param list односвязный список
     * @param n    позиция искомого элемента
     * @param <T>
     * @return сам элемент
     */

    // Мы реализовали метод get для списка, можно воспользоваться им
    public <T> T findNthElementNodeGet(Node<T> list, int n) {
        return list.get(n);
    }

    // Реализуем без get через цикл while
    public <T> T findNthElement(Node<T> list, int n) {

        int index = 0;
        while (list != null) {
            if (n == index) {
                return list.getValue();
            }
            index++;
            list = list.getNext();
        }
            throw new IllegalArgumentException("invalid index");
    }
}
