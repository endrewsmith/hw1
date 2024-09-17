package org.example;

import org.example.HomeWork;
import org.example.Node;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.function.Predicate;

public class HomeWorkTest {

    // Проверим все метода списка: add, get, size
    @Test
    public void testNodeMethods() {
        // С каким размером будем создавать список
        int sizeNode = 1000;

        Node<Integer> node = new Node<>(0);
        // Проверка get на отрицальный индекс
        Assert.assertThrows(IllegalArgumentException.class, ()-> node.get(-10));

        Assert.assertEquals(0, node.get(0));
        for(int i = 1; i < sizeNode; i++){
            node.add(i);
            Assert.assertEquals(i, node.get(i));
        }
        // Проверка size() на исключение
        Assert.assertEquals(sizeNode, node.size());
        // Проверка get() на исключение
        Assert.assertThrows(IllegalArgumentException.class, ()-> node.get(1001));

        // Проверка get на рандомное значение индекса
        Integer random = new Random().nextInt(sizeNode);
        Assert.assertEquals(random, node.get(random));
    }

    // Тест метода partitionBy(Node<T> list, Predicate<T> pred)
    @Test
    public void testPartitionBy() {

        HomeWork homeWork = new HomeWork();

        // Первое условие
        Predicate<Integer> pred_first = x -> x < 4;
        // Создаем список с последовтельностью: 1, 2, 3, 4, 5
        Node<Integer> node = new Node<>(1);
        Assert.assertEquals(1, node.get(0));
        for(int i = 2; i < 6; i++){
            node.add(i);
            Assert.assertEquals(i, node.get(i-1));
        }

        // Проверки на null, при наличие null в параметрах метод возвращает 0
        Assert.assertEquals(0, homeWork.partitionBy(node, null));
        Assert.assertEquals(0, homeWork.partitionBy(null, null));
        Assert.assertEquals(0, homeWork.partitionBy(null, pred_first));

        // Проверка на первое условие
        Assert.assertEquals(3, homeWork.partitionBy(node, pred_first));

        // Второе условие
        Predicate<Integer> pred_second = x -> x < 0;
        // Проверка на второе условие
        Assert.assertEquals(0, homeWork.partitionBy(node, pred_second));

        // В методе add(T value) нет ограничения на value
        node.add(null);
        Assert.assertEquals(null, node.get(5));
    }

    // Тест метода findNthElement(Node<T> list, int n)
    @Test
    public void findNthElement() {
        // С каким размером будем создавать список
        int sizeNode = 100;
        HomeWork homeWork = new HomeWork();
        // Создаем список для наглядности начнем с 0
        Node<Integer> node = new Node<>(0);
        for(int i = 1; i < sizeNode; i++){
            node.add(i);
            Assert.assertEquals(i, node.get(i));
        }

        // Тест на поиск по отрицательному значению
        Assert.assertThrows(IllegalArgumentException.class, ()-> homeWork.findNthElement(node,-1));

        // Тест на поиск по рандомному значению
        Integer random = new Random().nextInt(sizeNode);
        Assert.assertEquals(random, homeWork.findNthElement(node, random));
    }

    // Тесты к этому методу совпадают с тестами метода get
    @Test
    public void findNthElementNodeGet() {
        HomeWork homeWork = new HomeWork();
        // Создаем список для наглядности начнем с 0
        Node<Integer> node = new Node<>(0);
        for(int i = 1; i < 100; i++){
            node.add(i);
            Assert.assertEquals(i, node.get(i));
        }
        // Проверим, что два метода работают одинаково
        Integer random = new Random().nextInt(100);
        Assert.assertEquals(homeWork.findNthElementNodeGet(node, random), homeWork.findNthElement(node, random));
    }
}
