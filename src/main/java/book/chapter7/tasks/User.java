package book.chapter7.tasks;

import java.util.*;

public class User implements Comparable<User> {
    private int id;
    private String name;
    private int age;
    private Countries country;

    User(int id, String name, int age, Countries country) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public void setIid(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }

    public Countries getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return id + ":" + name + ":" + age + ":" + country.toString();
    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(this.age, o.age);
    }

    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User(1, "John", 15, Countries.RUSSIA),
                new User(2, "Doe", 18, Countries.USA),
                new User(3, "Jane", 16, Countries.UNITED_KINGDOM),
                new User(4, "Lavanda", 33, Countries.RUSSIA),
                new User(5, "Mike", 18, Countries.USA)
        );

        int minAge = 10;
        char startLetter = 'J';

        Comparator<User> countryComparator = Comparator.comparing(User::getCountry);
        Comparator<User> ageComparator = Comparator.comparing(User::getAge);
        Collections.sort(users, countryComparator.thenComparing(ageComparator));

        List<User> filteredUsers = new ArrayList<>();
        for (User user : users) {
            if (user.getAge() > minAge && user.getName().charAt(0) == startLetter) {
                filteredUsers.add(user);
            }
        }

        User maxUser = Collections.max(filteredUsers);
        User minUser = Collections.min(filteredUsers);

        System.out.println("Filtered Users:");
        for (User user : filteredUsers) {
            System.out.println(user.toString());
        }

        System.out.println("Max User: " + maxUser.toString());
        System.out.println("Min User: " + minUser.toString());

    }
}
