package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Comment {
    private ArrayList<SubComment> subComments;
    private Recommend recommendCount[];
    private String content;
    private int commentId;

    public Comment(String content, int count) {
        recommendCount = new Recommend[2];
        this.content = content;
        subComments = new ArrayList<>(100);
        this.commentId = count;
    }

    public String getContent() {
        return this.content;
    }

    public ArrayList<SubComment> getSubComment() {
        return this.subComments;
    }

    public Recommend[] getRecommentCount() {
        return this.recommendCount;
    }

    public int getId() {
        return this.commentId;
    }

    public ArrayList<SubComment> getSubComments() {
        return this.subComments;
    }

    public ArrayList<SubComment> setSubComments() {
        return this.subComments;
    }
}
