package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;

public class Article {
    private ArrayList<Comment> comments;
    private int reactionCount[];
    private String content;
    private ArrayList<String> tag;
    private String title;
    private String user;

    private OffsetDateTime createdTime;
    private OffsetDateTime revisedTime;

    public Article(String title, String content, String user) { //파라미터 5개
        this.title = title;
        this.content = content;
        this.user = user;

        createdTime = OffsetDateTime.now();
        revisedTime = OffsetDateTime.MIN;
        
        this.tag = new ArrayList<>();
        comments = new ArrayList<>();

        reactionCount = new int[5];
    }

    public OffsetDateTime getTime() {
        return this.createdTime;
    }

    public OffsetDateTime getReviseTime() {
        return this.revisedTime;
    }

    public int getTimeNano() {
        return this.createdTime.getNano();
    }

    public int getReviseTimeNano() {
        return this.revisedTime.getNano();
    }

    public String getContent() {
        return this.content;
    }

    // public void setContent(String content) {
    //     this.content = content;
    // }

    public ArrayList<String> getTag() {
        return this.tag;
    }

    // public String setTag(String tag) {
    //     return this.tag = tag;
    // }

    public String getTitle() {
        return this.title;
    }

    // public void setTitle(String title) {
    //     this.title = title;
    // }

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

    // public void increaseReactionCount(Reaction reactionType) {
    //     switch (reactionType) {
    //         case GREAT: 
    //             this.reactionCount[0]++;
    //             break;
    //         case SAD: 
    //             this.reactionCount[1]++;
    //             break;
    //         case ANGRY: 
    //             this.reactionCount[2]++;
    //             break;
    //         case FUN: 
    //             this.reactionCount[3]++;
    //             break;
    //         case LOVE:
    //             this.reactionCount[4]++;
    //             break;
    //         default: 
    //             break;
    //     }
    // }

    // public void decreaseReactionCount(Reaction reactionType) {
    //     switch (reactionType) {
    //         case GREAT: 
    //             this.reactionCount[0]--;
    //             break;
    //         case SAD: 
    //             this.reactionCount[1]--;
    //             break;
    //         case ANGRY: 
    //             this.reactionCount[2]--;
    //             break;
    //         case FUN: 
    //             this.reactionCount[3]--;
    //             break;
    //         case LOVE:
    //             this.reactionCount[4]--;
    //             break;
    //         default: 
    //             break;
    //     }
    // }




    // 구동부

    public void addComment(Comment comment, String user) {
        this.user = user;
        this.comments.add(comment);
    }

    // public void addSubComment(Comment subcomment, String user) {
    //     this.user = user;
    //     this.comments.add(subcomment);
    // }

    // public void changeComment(Article article, Comment comment, String text) {

    // }

    // public void changeSubComment(Article article, Comment comment, Comment subcomment, String text) {

    // }

    public void addReaction(Reaction reactionType) {
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

    public void removeReaction(Reaction reactionType) {
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

    // public void recommendTheComment(Article article, Comment comment) {

    // }

    // public void notRecommendTheComment(Article article, Comment comment) {

    // }


    // public void getSubComments(Article article, Comment comment) {

    // }

    // public void recommendTheSubComment(Article article, Comment comment, Comment subcomment) {

    // }

    // public void notRecommendTheSubComment(Article article, Comment comment, Comment subcomment) {

    // }

    public void changeArticleTitle(String title, String user) {
        if (user.equals(this.user)) {
            this.title = title;
        }
    }

    public void changeArticleContent(String content, String user) {
        if (user.equals(this.user)) {
            this.content = content;
        }
    }

    public void addArticleTag(String tag, String user) {
        if (user.equals(this.user)) {
            this.tag.add(tag);
        }
    }


    
}
