package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;

public class Article {
    private ArrayList<Comment> comments;
    private int reactionCount[];
    private String content;
    private String tag;
    private String articleName;
    private String user;

    //private int orderNumber;
    private long reviseTime;
    private OffsetDataTime time;

    public Article(String title, String content, String user) { //파라미터 5개
        this.articleName = title;
        this.content = content;
        this.user = user;

        time = new OffsetDataTime(System.currentTimeMillis());
        reviseTime = 0;

        comments = new ArrayList<>();
        reactionCount = new int[5];
    }

    public OffsetDataTime getTime() {
        return time;
    }

    public long getReviseTime() {
        return reviseTime;
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
