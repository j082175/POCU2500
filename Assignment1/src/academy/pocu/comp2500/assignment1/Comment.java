package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Comment {
    private ArrayList<Comment> subComments;
    private Recommend recommendCount[];
    private String content;
    private int commentId;

    public Comment(String content, int commentId) {
        this.content = content;
        this.commentId = commentId;

        recommendCount = new Recommend[2];
        subComments = new ArrayList<>();
    }

    public String getContent() {
        return this.content;
    }

    public ArrayList<Comment> getSubComment() {
        return this.subComments;
    }

    public Recommend[] getRecommentCount() {
        return this.recommendCount;
    }

    public int getId() {
        return this.commentId;
    }
}
