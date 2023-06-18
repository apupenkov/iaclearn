package book.chapter11.chapter_examples.learn_linked_list_queue;

import java.util.Arrays;
import java.util.LinkedList;

public class Car {
    String model;

    public Car(String model) {
        this.model = model;
    }

    public static void main(String[] args) {
        LinkedList<Car> cars = new LinkedList<>();
        Car ferrari = new Car("Ferrari 360 Spider");
        Car bugatti = new Car("Bugatti Veyron");
        Car lambo = new Car("Lamborghini Diablo");
        Car ford = new Car("Ford Mondeo");
        Car fiat = new Car("Fiat Ducato");

        cars.add(ferrari);
        cars.add(bugatti);
        cars.add(lambo);

        System.out.println(cars);

        cars.addFirst(ford);
        cars.addLast(fiat);
        System.out.println(cars);

        // Вывод первого и последнего элемента списка.
        System.out.println(cars.peekFirst());
        System.out.println(cars.peekLast());

        // Вывод и первого/последнего элемента списка и его удаление из списка.
        System.out.println(cars.pollFirst());
        System.out.println(cars.pollLast());

        System.out.println(cars);

        // Повторное добавление в список элементов.
        cars.addFirst(ford);
        cars.addLast(fiat);

        Car[] carsArray = cars.toArray(new Car[5]);
        System.out.println(Arrays.toString(carsArray));
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                '}';
    }
}
