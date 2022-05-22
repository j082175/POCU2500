package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;

import java.util.ArrayList;

public class Article {
    //private final int reactionCount[];
    private ArrayList<Reaction> reactions;

    private String reactionUser;

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
        this.reactions = new ArrayList<>();

        reactionUser = null;
    }
    ///////////reactions
    // public int[] getReactionCount() {
    //     return this.reactionCount;
    // }


    //////////////////////
    public int getReactions(Reaction reactionType) {
        int count = 0;
        for (int i = 0; i < this.reactions.size(); i++) {
            if (this.reactions.get(i) == reactionType) {
                count++;
            }
        }

        return count;
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

    public void addReaction(String user, Reaction reactionType) {
        this.reactionUser = user;
        
        switch (reactionType) {
            case GREAT:
                this.reactions.add(reactionType);
                break;
            case SAD:
                this.reactions.add(reactionType);
                break;
            case ANGRY:
                this.reactions.add(reactionType);
                break;
            case FUN:
                this.reactions.add(reactionType);
                break;
            case LOVE:
                this.reactions.add(reactionType);
                break;
            default:
                break;
        }
    }

    public void removeReaction(String user, Reaction reactionType) {
        if (this.reactionUser.equals(user)) {
            switch (reactionType) {
                case GREAT:
                    this.reactions.remove(reactionType);
                    break;
                case SAD:
                    this.reactions.remove(reactionType);
                    break;
                case ANGRY:
                    this.reactions.remove(reactionType);
                    break;
                case FUN:
                    this.reactions.remove(reactionType);
                    break;
                case LOVE:
                    this.reactions.remove(reactionType);
                    break;
                default:
                    break;
            }
        }
    }

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
        // if (this.user.equals(user)) {
        //     this.tag.add(tag);
        //     revisedTime = OffsetDateTime.now();
        // }

        for (int i = 0; i < this.tag.size(); i++) {
            if (!this.tag.get(i).equals(tag)) {
                this.tag.add(tag);
                revisedTime = OffsetDateTime.now();
            }
        }

        if (this.tag.size() == 0) {
            this.tag.add(tag);
            revisedTime = OffsetDateTime.now();
        }
    }

}
