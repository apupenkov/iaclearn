package book.chapter15.chapter_examples.validation.entities;

public class Student {
    private String login;
    private String name;
    private String faculty;
    private int telephone;
    private Address address = new Address();
    public Student() {
    }
    public Student(String login, String name, String faculty, int telephone,Address address) {
        this.login = login;
        this.name = name;
        this.faculty = faculty;
        this.telephone = telephone;
        this.address = address;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFaculty() {
        return faculty;
    }
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    public int getTelephone() {
        return telephone;
    }
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nLogin: ");
        sb.append(login).append("\nName: ").append(name).append("\nTelephone: ").append(telephone);
        sb.append("\nFaculty: ").append(faculty).append(address);
        return sb.toString();
    }
    public class Address { // inner class
        private String country;
        private String city;
        private String street;
        public Address() {
        }
        public Address(String country, String city, String street) {
            this.country = country;
            this.city = city;
            this.street = street;
        }
        public String getCountry() {
            return country;
        }
        public void setCountry(String country) {
            this.country = country;
        }
        public String getCity() {
            return city;
        }
        public void setCity(String city) {
            this.city = city;
        }
        public String getStreet() {
            return street;
        }
        public void setStreet(String street) {
            this.street = street;
        }
        public String toString() {
            final StringBuilder sb = new StringBuilder("\nAddress:\n\tCountry:");
            sb.append(country).append("\n\tCity: ").append(city);
            sb.append("\n\tStreet: ").append(street).append('\n');
            return sb.toString();
        }
    }
}