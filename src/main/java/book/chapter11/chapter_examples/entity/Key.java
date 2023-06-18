package book.chapter11.chapter_examples.entity;

public class Key {
    private int keyUnique;
    private boolean isProcessed;

    public Key(int keyUnique) {
        this.keyUnique = keyUnique;
    }


    public boolean isProcessed() {
        return isProcessed;
    }

    public void setProcessed(boolean processed) {
        isProcessed = processed;
    }
}
