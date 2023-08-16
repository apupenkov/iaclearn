package book.chapter12.entities.port;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Port {
    private int capacity; // Вместимость порта
    private Semaphore docks; // Семафор для причалов
    private AtomicInteger containersInPort; // Количество контейнеров в порту

    public Port(int capacity, int dockCount) {
        this.capacity = capacity;
        this.docks = new Semaphore(dockCount, true);
        this.containersInPort = new AtomicInteger(0);
    }

    public boolean dockShip(Ship ship) throws InterruptedException {
        if (docks.tryAcquire()) {
            int unloadedContainers = Math.min(ship.getLoadedContainers(), capacity - containersInPort.get());
            containersInPort.addAndGet(unloadedContainers);
            System.out.println(ship.getName() + " разгрузил " + unloadedContainers + " контейнеров");
            docks.release();
            return true;
        }
        return false;
    }

    public void undockShip(Ship ship) {
        int loadedContainers = Math.min(ship.getCapacity() - ship.getLoadedContainers(), containersInPort.get());
        containersInPort.addAndGet(-loadedContainers);
        System.out.println(ship.getName() + " загрузил " + loadedContainers + " контейнеров");
        docks.release();
    }
}
