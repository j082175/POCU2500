package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Comment {
    private ArrayList<Subcomment> subComments;
    private Recommend recommendCount[];
    private String content;

    public Comment(String content) {
        recommendCount = new Recommend[2];
        this.content = content;
    }

}
