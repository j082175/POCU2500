package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Article {
    private static int createTotalCount;
    private ArrayList<Comment> comments;
    private int reactionCount[];
    private String content;
    private String tag;
    private String articleName;
    private String writerName;

    private int orderNumber;
    private long reviseTime;
    //private OffsetDateTime

    public Article(String title, String content, String name, int count, long id) {
        this.articleName = title;
        this.content = content;
        comments = new ArrayList<>(100);
        reactionCount = new int[5];
        Article.createTotalCount++;
        this.writerName = name;

        this.orderNumber = count;
        this.reviseTime = id;
    }

    public Article(String name, String content, String tag) {
        this.articleName = name;
        this.content = content;
        this.tag = tag;
        comments = new ArrayList<>(100);
        reactionCount = new int[5];
        Article.createTotalCount++;
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public long getReviseTime() {
        return this.reviseTime;
    }

    public int getTotalCount() {
        return Article.createTotalCount;
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

    public int[] getReactionCount() {
        return this.reactionCount;
    }

    //dangerous code
    public ArrayList<Comment> getComments() {
        return this.comments;
    }

    public String getWriterName() {
        return this.writerName;
    }

    public void setReactionCount(Reaction reactionType) {
        switch (reactionType) {
            case GREAT: 
                this.reactionCount[0]++;
                break;
            case SAD: 
                this.reactionCount[1]++;
                break;
            case ANGRY: 
                this.reactionCount[2]++;
                break;
            case FUN: 
                this.reactionCount[3]++;
                break;
            case LOVE:
                this.reactionCount[4]++;
                break;
            default: 
                break;
        }
    }
}
