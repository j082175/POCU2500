package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Comment {
    private ArrayList<Comment> subComments;
    private Recommend recommendCount[];
    private String content;

    private String user;

    public Comment(String content, String user) {
        this.content = content;
        this.user = user;

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

    public String getUser() {
        return this.user;
    }



    //구동부

    public void addSubComment(Comment subcomment) {
        this.subComments.add(subcomment);
    }

    public void changeSubComment(Comment subcomment, String text) {
        
    }

    public void recommendTheComment(Comment comment) {

    }

    public void notRecommendTheComment(Comment comment) {

    }

    public void getSubComments(Comment comment) {

    }

    public void recommendTheSubComment(Comment comment, Comment subcomment) {

    }

    public void notRecommendTheSubComment(Comment comment, Comment subcomment) {

    }

    public void changeComment(Comment comment, String text) {

    }
}
