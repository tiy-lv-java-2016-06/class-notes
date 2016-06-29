package todo;

/**
 * Created by jeff on 6/29/16.
 */
public class ToDoItem {
    String text;
    boolean isDone;

    public ToDoItem(String text) {
        this.text = text;
        this.isDone = false;
    }

    @Override
    public String toString() {
        return text + (isDone ? " (done)" : "");
    }
}
