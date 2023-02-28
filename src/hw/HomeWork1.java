package hw;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HomeWork1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        Stream<Integer> stream = list.stream();

        System.out.println("Задание 1. Метод findMinMax.");
        findMinMax(stream, Comparator.naturalOrder(), (x, y) -> System.out.println(x + " - min значение. " + y + " - max значение."));


        System.out.println("Задание 2. Выводит четные числа и их количество.");
        countNumbersStream(list);




    }

    /**
     * Метод находит в стриме минимальный и максимальный элементы
     *  в соответствии порядком, заданным Comparator'ом
     * Метод принимает 3 параметра
     * @param stream Stream
     * @param order Comparator
     * @param minMaxConsumer BiConsumer
     * Нужно найти минимальный и максимальный элементы передайте в minMaxConsumer
     */
    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.collect(Collectors.toList());

        if (!list.isEmpty()) {
            minMaxConsumer.accept(list.stream().min(order).get(), list.stream().max(order).get());
        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    /**
     * Метод принимает на вход список целых чисел выводит их в консоль
     * и определяет их количество.
     * @param list список чисел
     */
    public static void countNumbersStream(List<Integer> list) {
        int n = (int) list.stream().filter(e -> e % 2 == 0).peek(System.out::println).count();
        System.out.println(n);
    }

}
