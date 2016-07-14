package forumweb;

/**
 * Created by jeff on 7/13/16.
 */
public class Message {
    private int id;
    private int replyId;
    private String author;
    private String text;
    public static final int TOP_LEVELID = -1;

    public Message(int id, int replyId, String author, String text) {
        this.id = id;
        this.replyId = replyId;
        this.author = author;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public int getReplyId() {
        return replyId;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }
}
