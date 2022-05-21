package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Comment {
    private ArrayList<Comment> subComments;
    private int recommendCount[];
    private String content;

    private String user;

    public Comment(String content, String user) {
        this.content = content;
        this.user = user;

        recommendCount = new int[2];
        subComments = new ArrayList<>();
    }

    public String getContent() {
        return this.content;
    }

    public ArrayList<Comment> getSubComment() {
        return this.subComments;
    }

    public int[] getRecommentCount() {
        return this.recommendCount;
    }

    public String getUser() {
        return this.user;
    }



    //구동부

    public void addSubComment(Comment subcomment) {
        this.subComments.add(subcomment);
    }

    public void changeSubComment(Comment user, String text) {
        for (int i = 0; i < this.subComments.size(); i++) {
            if (user.equals(this.subComments.get(i).getUser())) {
                
            }
        }
    }

    public void recommendTheComment() {
        this.recommendCount[0]++;
    }

    public void notRecommendTheComment() {
        this.recommendCount[1]++;
    }

    public void getSubComments(Comment comment) {

    }

    public void recommendTheSubComment(Comment comment, Comment subcomment) {

    }

    public void notRecommendTheSubComment(Comment comment, Comment subcomment) {

    }

    public void changeComment(String content, String user) {
        if (user.equals(this.user)) {
            this.content = content;
        }
    }
}
