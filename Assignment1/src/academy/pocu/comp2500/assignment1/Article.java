package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;

import java.util.ArrayList;

public class Article {
    //private final int reactionCount[];
    private int reactionGreat;
    private int reactionSad;
    private int reactionAngry;
    private int reactionFun;
    private int reactionLove;


    
    private ArrayList<Comment> comments;
    private final ArrayList<String> tag;

    private String content;
    private String title;
    private String user;

    private OffsetDateTime createdTime;
    private OffsetDateTime revisedTime;

    public Article(String user, String title, String content) { // 파라미터 5개
        this.user = user;
        this.title = title;
        this.content = content;

        createdTime = OffsetDateTime.now();
        revisedTime = createdTime;

        this.tag = new ArrayList<>();
        comments = new ArrayList<>();

        //reactionCount = new int[5];

        this.reactionGreat = 0;
        this.reactionSad = 0;
        this.reactionAngry = 0;
        this.reactionFun = 0;
        this.reactionLove = 0;
    }
    ///////////reactions
    // public int[] getReactionCount() {
    //     return this.reactionCount;
    // }

    public int getReactionGreat() {
        //return this.reactionCount[0];
        return this.reactionGreat;
    }

    public int getReactionSad() {
        //return this.reactionCount[1];
        return this.reactionSad;
    }

    public int getReactionAngry() {
        //return this.reactionCount[2];
        return this.reactionAngry;
    }

    public int getReactionFun() {
        //return this.reactionCount[3];
        return this.reactionFun;
    }

    public int getReactionLove() {
        //return this.reactionCount[4];
        return this.reactionLove;
    }
    //////////////////////

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
    // this.content = content;
    // }

    public ArrayList<String> getTag() {
        return this.tag;
    }

    // public String setTag(String tag) {
    // return this.tag = tag;
    // }

    public String getTitle() {
        return this.title;
    }

    // public void setTitle(String title) {
    // this.title = title;
    // }



    // dangerous code
    public ArrayList<Comment> getComments() {

        for (int i = 0; i < comments.size(); i++) {
            for (int j = 0; j < comments.size() - 1 - i; j++) {
                if (comments.get(j).getRCount() < comments.get(j + 1).getRCount()) {
                    Comment backup = comments.get(j);

                    comments.set(j, comments.get(j + 1));
                    comments.set(j + 1, backup);
                }
            }
        }

        return this.comments;
    }

    public String getUserName() {
        return this.user;
    }

    // public void increaseReactionCount(Reaction reactionType) {
    // switch (reactionType) {
    // case GREAT:
    // this.reactionCount[0]++;
    // break;
    // case SAD:
    // this.reactionCount[1]++;
    // break;
    // case ANGRY:
    // this.reactionCount[2]++;
    // break;
    // case FUN:
    // this.reactionCount[3]++;
    // break;
    // case LOVE:
    // this.reactionCount[4]++;
    // break;
    // default:
    // break;
    // }
    // }

    // public void decreaseReactionCount(Reaction reactionType) {
    // switch (reactionType) {
    // case GREAT:
    // this.reactionCount[0]--;
    // break;
    // case SAD:
    // this.reactionCount[1]--;
    // break;
    // case ANGRY:
    // this.reactionCount[2]--;
    // break;
    // case FUN:
    // this.reactionCount[3]--;
    // break;
    // case LOVE:
    // this.reactionCount[4]--;
    // break;
    // default:
    // break;
    // }
    // }

    // 구동부

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    // public void addSubComment(Comment subcomment, String user) {
    // this.user = user;
    // this.comments.add(subcomment);
    // }

    // public void changeComment(Article article, Comment comment, String text) {

    // }

    // public void changeSubComment(Article article, Comment comment, Comment
    // subcomment, String text) {

    // }

    public void addReaction(Reaction reactionType) {
        switch (reactionType) {
            case GREAT:
                //this.reactionCount[0]++;
                this.reactionGreat++;
                break;
            case SAD:
                //this.reactionCount[1]++;
                this.reactionSad++;
                break;
            case ANGRY:
                //this.reactionCount[2]++;
                this.reactionAngry++;
                break;
            case FUN:
                //this.reactionCount[3]++;
                this.reactionFun++;
                break;
            case LOVE:
                //this.reactionCount[4]++;
                this.reactionLove++;
                break;
            default:
                break;
        }
    }

    public void removeReaction(Reaction reactionType) {
        switch (reactionType) {
            case GREAT:
                //this.reactionCount[0]--;
                this.reactionGreat++;
                break;
            case SAD:
                //this.reactionCount[1]--;
                this.reactionSad++;
                break;
            case ANGRY:
                //this.reactionCount[2]--;
                this.reactionAngry++;
                break;
            case FUN:
                //this.reactionCount[3]--;
                this.reactionFun++;
                break;
            case LOVE:
                //this.reactionCount[4]--;
                this.reactionLove++;
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

    // public void recommendTheSubComment(Article article, Comment comment, Comment
    // subcomment) {

    // }

    // public void notRecommendTheSubComment(Article article, Comment comment,
    // Comment subcomment) {

    // }

    public void changeArticleTitle(String user, String title) {
        if (this.user.equals(user)) {
            this.title = title;
            revisedTime = OffsetDateTime.now();
        }
    }

    public void changeArticleContent(String user, String content) {
        if (user.equals(this.user)) {
            this.content = content;
            revisedTime = OffsetDateTime.now();
        }
    }

    // public void addArticleTag(String title, String tag) {
    //     if (this.title.equals(title)) {
    //         this.tag.add(tag);
    //         revisedTime = OffsetDateTime.now();
    //     }
    // }

    public void addArticleTag(String user, String tag) {
        if (this.user.equals(user)) {
            this.tag.add(tag);
            revisedTime = OffsetDateTime.now();
        }
    }

}
