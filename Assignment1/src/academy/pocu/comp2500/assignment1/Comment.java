package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

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

    // public int[] getRecommentCount() {
    //     return this.recommendCount;
    // }

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

    public void changeSubComment(String user, String content) {
        changeComment(user, content);
        // if (this.subComments != null) {
        //     for (int i = 0; i < this.subComments.size(); i++) {
        //         if (subComments.get(i).getUser().equals(user)) {
                    
        //             this.subComments.get(i).changeComment(user, content);
        //         }
        //     }
        // }
    }



    public void recommendTheComment() {
        //this.recommendCount[0]++;
        this.upVoteCount++;
        this.rCount++;
    }

    public void notRecommendTheComment() {
        //this.recommendCount[1]++;
        this.downVoteCount++;
        this.rCount--;
    }

    public void recommendTheSubComment(int commentId) {

        if (this.subComments != null) {
            this.subComments.get(commentId).recommendTheComment();
        }

        // if (this.subComments != null) {
        //     for (int i = 0; i < this.subComments.size(); i++) {
        //         if (this.user.equals(subComments.get(i).getUser())) {
        //             this.subComments.get(i).recommendCount[1]++;
        //             this.subComments.get(i).rCount++;
        //             //this.subComments.get(i).recommendTheComment();
        //         }
        //     }
        // }
    }

    public void notRecommendTheSubComment(int commentId) {

        if (this.subComments != null) {
            this.subComments.get(commentId).notRecommendTheComment();
        }

        // if (this.subComments != null) {
        //     for (int i = 0; i < this.subComments.size(); i++) {
        //         if (this.user.equals(subComments.get(i).getUser())) {
        //             this.subComments.get(i).recommendCount[1]++;
        //             this.subComments.get(i).rCount++;
        //             //this.subComments.get(i).notRecommendTheComment();
        //         }
        //     }
        // }
    }


}
