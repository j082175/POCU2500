package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Article {
    private static int createTotalCount;
    private ArrayList<Comment> comments;
    private Reaction reactionCount[];
    private String content;
    private String tag;
    private String articleName;
    public int orderNumber;
    public int reviseTime;
    //private OffsetDateTime

    public Article(String name, String content, int writeTime, int reviseTime) {
        this.articleName = name;
        this.content = content;
        comments = new ArrayList<>(100);
        reactionCount = new Reaction[5];
        Article.createTotalCount++;

        this.orderNumber = writeTime;
        this.orderNumber = reviseTime;
    }

    public int getTotalCount() {
        return Article.createTotalCount;
    }

    public Article(String name, String content, String tag) {
        this.articleName = name;
        this.content = content;
        this.tag = tag;
        comments = new ArrayList<>(100);
        reactionCount = new Reaction[5];
        Article.createTotalCount++;
    }

    public String getContent() {
        return this.content;
    }

    public String getTag() {
        return this.tag;
    }

    public String getName() {
        return this.articleName;
    }

    public Reaction[] getReactionCount() {
        return this.reactionCount;
    }

    //dangerous code
    public ArrayList<Comment> getComments() {
        return this.comments;
    }
}
