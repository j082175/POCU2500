package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Article {
    private ArrayList<Comment> comments;
    private int reactionCount[];
    private String content;
    private String tag;
    private String articleName;
    private String user;

    private int orderNumber;
    private long reviseTime;
    //private OffsetDateTime

    public Article(String title, String content, String user, int count, long id) {
        this.articleName = title;
        this.content = content;
        comments = new ArrayList<>(100);
        reactionCount = new int[5];

        this.user = user;

        this.orderNumber = count;
        this.reviseTime = id;
    }

    public Article(String name, String content, String user) {
        this.articleName = name;
        this.content = content;
        this.user = user;
        comments = new ArrayList<>(100);
        reactionCount = new int[5];

    }

    public Article(String user) {
        this.user = user;
        comments = new ArrayList<>(100);
        reactionCount = new int[5];
    }



    public int getOrderNumber() {
        return this.orderNumber;
    }

    public long getReviseTime() {
        return this.reviseTime;
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

    public String getUserName() {
        return this.user;
    }

    public void increaseReactionCount(Reaction reactionType) {
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

    public void decreaseReactionCount(Reaction reactionType) {
        switch (reactionType) {
            case GREAT: 
                this.reactionCount[0]--;
                break;
            case SAD: 
                this.reactionCount[1]--;
                break;
            case ANGRY: 
                this.reactionCount[2]--;
                break;
            case FUN: 
                this.reactionCount[3]--;
                break;
            case LOVE:
                this.reactionCount[4]--;
                break;
            default: 
                break;
        }
    }
}
