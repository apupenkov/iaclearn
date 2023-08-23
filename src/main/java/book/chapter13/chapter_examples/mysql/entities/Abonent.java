package book.chapter13.chapter_examples.mysql.entities;

public class Abonent extends Entity {
    private int id;
    private String name;
    private int phone;
    public Abonent() {
    }
    public Abonent(int id, String name, int phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public String toString() {
        final StringBuilder sb = new StringBuilder("Abonent{");
        sb.append("id=").append(id).append(", name='").append(name).append('\'');
        sb.append(", phone=").append(phone).append('}');
        return sb.toString();
    }
}
