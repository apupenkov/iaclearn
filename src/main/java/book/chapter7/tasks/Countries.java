package book.chapter7.tasks;

public enum Countries {
    RUSSIA ("Россия"),
    USA ("США"),
    UNITED_KINGDOM ("Великобритания");

    private String title;

    Countries(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
