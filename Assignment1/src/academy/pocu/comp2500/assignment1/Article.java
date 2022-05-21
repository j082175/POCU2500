package academy.pocu.comp2500.assignment1;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;

public class Article {
    private ArrayList<Comment> comments;
    private int reactionCount[];
    private String content;
    private String tag;
    private String title;
    private String user;

    //private int orderNumber;
    private OffsetDateTime createdTime;
    private OffsetDateTime revisedTime;

    public Article(String title, String content, String user) { //파라미터 5개
        this.title = title;
        this.content = content;
        this.user = user;
        this.tag = "";
        createdTime = OffsetDateTime.now();
        revisedTime = OffsetDateTime.now();

        comments = new ArrayList<>();
        reactionCount = new int[5];
    }

    public OffsetDateTime getTime() {
        // String formatedNow = createdTime.getData().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
        // return formatedNow;
        return this.createdTime;
    }

    public OffsetDateTime getReviseTime() {
        // String formatedNow = reviseTime.getData().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
        // return formatedNow;
        return this.revisedTime;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTag() {
        return this.tag;
    }

    public String setTag(String tag) {
        return this.tag = tag;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
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
