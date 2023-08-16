package book.chapter12;

import book.chapter12.entities.library.Book;
import book.chapter12.entities.library.Library;
import book.chapter12.entities.library.Reader;
import book.chapter12.entities.parkinglot.Car;
import book.chapter12.entities.parkinglot.ParkingLot;
import book.chapter12.entities.port.Port;
import book.chapter12.entities.port.Ship;

import java.util.ArrayList;
import java.util.List;

public class ThreadSolver {

    public static void main(String[] args) {
//        testPort();
//        testLibrary();
        testParkingLot();
    }

    /*
    * TODO:
    * Разработать многопоточное приложение. Использовать возможности, предоставляемые пакетом java.util.concurrent. Неиспользовать слово synchronized.
    * Все сущности, желающие получить доступ к ресурсу, должны быть потоками
    * */

    /*
    * [1]
    * Порт. Корабли заходят в порт для разгрузки/загрузки контейнеров. Число
    * контейнеров, находящихся в текущий момент в порту и на корабле, должно
    * быть неотрицательным и превышающим заданную грузоподъемность судна и
    * вместимость порта. В порту работает несколько причалов. У одного
    * причала может стоять один корабль. Корабль может загружаться у причала,
    * разгружаться или выполнять оба действия.
    * */

    public static void testPort() {
        int portCapacity = 100;
        int dockCount = 3;
        Port port = new Port(portCapacity, dockCount);

        Thread[] ships = new Thread[5];
        for (int i = 0; i < ships.length; i++) {
            Ship ship = new Ship("Корабль " + (i + 1), 50, 20, port);
            ships[i] = new Thread(ship);
            ships[i].start();
        }

        for (Thread ship : ships) {
            try {
                ship.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /*
    * [2]
    * Маленькая библиотека. Доступны для чтения несколько книг. Одинаковых
    * книг в библиотеке нет. Некоторые выдаются на руки, некоторые только
    * в читальный зал. Читатель может брать на руки и в читальный зал несколько книг
    * */

    public static void testLibrary() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Book 1", true));
        books.add(new Book("Book 2", false));
        books.add(new Book("Book 3", true));
        books.add(new Book("Book 4", false));
        books.add(new Book("Book 5", true));
        books.add(new Book("Book 6", false));
        books.add(new Book("Book 7", true));
        books.add(new Book("Book 8", false));
        books.add(new Book("Book 9", true));


        Library library = new Library(books);

        Thread[] readers = new Thread[10];
        for (int i = 0; i < readers.length; i++) {
            List<Book> readerBooks = new ArrayList<>();
            readers[i] = new Thread(new Reader("Читатель " + (i + 1), readerBooks, library));
            readers[i].start();
        }

        for (Thread reader : readers) {
            try {
                reader.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /*
    * [3]
    * Автостоянка. Доступно несколько машиномест. На одном месте может находиться
    * только один автомобиль. Если все места заняты, то автомобиль не
    * станет ждать больше определенного времени и уедет на другую стоянку
    * */
    public static void testParkingLot() {
        int parkingCapacity = 5;
        ParkingLot parkingLot = new ParkingLot(parkingCapacity);

        for (int i = 1; i <= parkingCapacity + 1; i++) {
            Car car = new Car("Car " + i);
            new Thread(() -> {
                try {
                    if (parkingLot.parkCar(car)) {
                        System.out.println(car.getName() + " parked.");
                        Thread.sleep(2000); // Simulating car staying parked
                        parkingLot.takeCar();
                        System.out.println(car.getName() + " left.");
                    } else {
                        System.out.println(car.getName() + " couldn't find a parking space and left.");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    /*
    * [4]
    * CallCenter. В организации работает несколько операторов. Оператор может
    * обслуживать только одного клиента, остальные должны ждать своей
    * очереди. Клиент может положить трубку и перезвонить еще раз через некоторое время.
    * */

    /*
    * [5]
    * Автобусные остановки. На маршруте несколько остановок. На одной
    * остановке может останавливаться несколько автобусов одновременно, но
    * не более заданного числа.
    * */

    /*
    * [6]
    * Свободная касса. В ресторане быстрого обслуживания есть несколько
    * касс. Посетители стоят в очереди в конкретную кассу, но могут перейти
    * в другую очередь при уменьшении или исчезновении там очереди.
    * */

    /*
    * [7]
    * Тоннель. В горах существует два железнодорожных тоннеля, по которым
    * поезда могут двигаться в обоих направлениях. По обоим концам тоннеля
    * собралось много поездов. Обеспечить безопасное прохождение тоннелей
    * в обоих направлениях. Поезд можно перенаправить из одного тоннеля
    * в другой при превышении заданного времени ожидания на проезд
    * */

    /*
    * [8]
    * Банк. Имеется банк с кассирами, клиентами и их счетами. Клиент может
    * снимать/пополнять/переводить/оплачивать/обменивать денежные средства.
    * Кассир последовательно обслуживает клиентов. Поток-наблюдатель
    * следит, чтобы в кассах всегда были наличные, при скоплении денег более
    * определенной суммы, часть их переводится в хранилище, при истощении
    * запасов наличных происходит пополнение из хранилища.
    * */

    /*
    * [9]
    * Аукцион. На торги выставляется несколько лотов. Участники аукциона
    * делают заявки. Заявку можно корректировать в сторону увеличения
    * несколько раз за торги одного лота. Аукцион определяет победителя
    * и переходит к следующему лоту. Участник, не заплативший за лот в
    * заданный промежуток времени, отстраняется на несколько лотов от торгов.
    * */

    /*
    * [10]
    * Биржа. На торгах брокеры предлагают акции нескольких фирм. На бирже
    * совершаются действия по купле-продаже акций. В зависимости от количества
    * проданных-купленных акций их цена изменяется. Брокеры предлагают к
    * продаже некоторую часть акций. От активности и роста-падения
    * котировок акций изменяется индекс биржи. Биржа может приостановить
    * торги при резком падении индекса.
    * */

    /*
    * [11]
    * Аэропорт. Посадка/высадка пассажиров может осуществляться через конечное
    * число терминалов и наземным способом через конечное число трапов.
    * Самолеты бывают разной вместимости и дальности полета. Организовать
    * функционирование аэропорта, если пунктов назначения 4–6, и зон дальности 2–3.
    * */
}
