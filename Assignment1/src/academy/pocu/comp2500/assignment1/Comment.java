package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Comment {
    private ArrayList<Comment> subComments;
    private int recommendCount[];
    private String content;

    private String user;

    private int rCount;

    public Comment(String content, String user) {
        this.content = content;
        this.user = user;
        this.rCount = 0;

        recommendCount = new int[2];
        subComments = new ArrayList<>();
    }

    public String getContent() {
        return this.content;
    }

    public int getRCount() {
        return this.rCount;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<Comment> getSubComments() {
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

    public void changeSubComment(String user, String content) {
        for (int i = 0; i < this.subComments.size(); i++) {
            if (this.user.equals(subComments.get(i).getUser())) {
                this.subComments.get(i).setContent(content);
            }
        }
    }

    public void recommendTheComment() {
        this.recommendCount[0]++;
        this.rCount++;
    }

    public void notRecommendTheComment() {
        this.recommendCount[1]++;
        this.rCount--;
    }

    public void recommendTheSubComment(String user) {
        for (int i = 0; i < this.subComments.size(); i++) {
            if (this.user.equals(subComments.get(i).getUser())) {
                this.subComments.get(i).recommendTheComment();
            }
        }
    }

    public void notRecommendTheSubComment(String user) {
        for (int i = 0; i < this.subComments.size(); i++) {
            if (this.user.equals(subComments.get(i).getUser())) {
                this.subComments.get(i).notRecommendTheComment();
            }
        }
    }

    public void changeComment(String content, String user) {
        if (user.equals(this.user)) {
            this.content = content;
        }
    }
}
