package org.example;

import lombok.Getter;
import lombok.Setter;


/**
 * Реализация базовой структуры односвязного списка
 * При необходимости, можно доработать реализацию
 *
 * @param <T>
 */
@Getter
@Setter
public class Node<T> {

    private T value;
    private Node<T> next;
    // Добавляем размер
    private int size = 0;

    public Node(T value) {
        this.value = value;
        // Увеличиваем размер на 1
        size++;
    }

    public Node<T> add(T value) {
        Node<T> emptyNode = this;
        while (emptyNode.getNext() != null) {
            emptyNode = emptyNode.getNext();
        }
        Node<T> newNode = new Node<>(value);
        emptyNode.setNext(newNode);
        // Увеличиваем размер на 1
        size++;
        return newNode;
    }

    // Добавляем метод получения элемента по индексу для тестов
    public T get(int index){
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("invalid index");
        }
        Node<T> curr = this;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.value;
    }

    // Добавляем получение размера
    public int size() {
        return size;
    }
}

