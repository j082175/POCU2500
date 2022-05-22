package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;


public class Comment {
    private ArrayList<Comment> subComments;
    //private int recommendCount[];

    private int upVoteCount;
    private int downVoteCount;
    
    private String content;
    private String user;

    private int rCount;

    public Comment(String user, String content) {
        this.content = content;
        this.user = user;
        this.rCount = 0;

        //recommendCount = new int[2];
        upVoteCount = 0;
        downVoteCount = 0;

        subComments = new ArrayList<>();
    }

    public int getUpVoteCount() {
        return this.upVoteCount;
    }

    public int getDownVoteCount() {
        return this.downVoteCount;
    }

    public String getContent() {
        return this.content;
    }

    public int getRCount() {
        return this.rCount;
    }

    public ArrayList<Comment> getSubComments() {
        for (int i = 0; i < subComments.size(); i++) {
            for (int j = 0; j < subComments.size() - 1 - i; j++) {
                if (subComments.get(j).getRCount() < subComments.get(j + 1).getRCount()) {
                    Comment backup = subComments.get(j);

                    subComments.set(j, subComments.get(j + 1));
                    subComments.set(j + 1, backup);
                }
            }
        }

        return this.subComments;
    }

    public String getUser() {
        return this.user;
    }



    //구동부

    public void addSubComment(Comment comment) {
        this.subComments.add(comment);
    }

    public void changeComment(String user, String content) {
        if (this.user.equals(user)) {
            this.content = content;
        }
    }

    // public void changeSubComment(String user, String content) {
    //     changeComment(user, content);
    // }

    public void recommendTheComment() {
        this.upVoteCount++;
        this.rCount++;
    }

    public void notRecommendTheComment() {
        this.downVoteCount++;
        this.rCount--;
    }

    // public void recommendTheSubComment() {
    //     //this.upVoteCount++;
    //     this.rCount++;
    // }

    // public void recommendTheSubComment(int count) {
    //     this.subComments.get(count).recommendTheComment();
    // }

    // public void notRecommendTheSubComment() {
    //     //this.downVoteCount++;
    //     this.rCount--;
    // }

    // public void notRecommendTheSubComment(int count) {
    //     this.subComments.get(count).notRecommendTheComment();
    // }


}
