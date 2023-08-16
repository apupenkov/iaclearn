package book.chapter12.entities.port;

public class Ship implements Runnable{
    private String name;
    private int capacity;
    private int loadedContainers;
    private Port port;

    public Ship(String name, int capacity, int loadedContainers, Port port) {
        this.name = name;
        this.capacity = capacity;
        this.loadedContainers = loadedContainers;
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getLoadedContainers() {
        return loadedContainers;
    }

    @Override
    public void run() {
        try {
            if (port.dockShip(this)) {
                // Разгрузка корабля
                Thread.sleep(1000);
                port.undockShip(this);
            } else {
                System.out.println(name + " не смог разместиться на причале");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
