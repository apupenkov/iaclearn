package book.chapter12.entities.parkinglot;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ParkingLot {
    private final BlockingQueue<Car> parkingSpaces;

    public ParkingLot(int capacity) {
        parkingSpaces = new ArrayBlockingQueue<>(capacity);
    }

    public boolean parkCar(Car car) {
        return parkingSpaces.offer(car);
    }

    public void waitForParking(Car car, long timeout, TimeUnit unit) throws InterruptedException {
        parkingSpaces.offer(car, timeout, unit);
    }

    public Car takeCar() throws InterruptedException {
        return parkingSpaces.take();
    }

}
