package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Comment {
    private String comment;
    private ArrayList<String> subComments;
    private int recommendedNumber;

    public Comment(String comment) {
        this.comment = comment;
    }

    public String getComment(){
        return this.comment;
    }
}
