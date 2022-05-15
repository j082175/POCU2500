package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Comment {
    private ArrayList<SubComment> subComments;
    private Recommend recommendCount[];
    private String content;

    public Comment(String content) {
        recommendCount = new Recommend[2];
        this.content = content;
        subComments = new ArrayList<>(100);
    }

    public String getContent() {
        return this.content;
    }

    public ArrayList<SubComment> getSubcomment() {
        return this.subComments;
    }

    public Recommend[] getRecommentCount() {
        return this.recommendCount;
    }
}
