package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Reader {
    private String readerName;

    public Reader(String name) {
        this.readerName = name;
    }

    public String getName() {
        return this.readerName;
    }

    public ArrayList<Article> getArticles(Blog blog) {
        return blog.getArticles();
    }

    public void addComment(Blog blog, Article article, Comment comment) {

    }

    public void addSubcomment(Blog blog, Article article,
Comment comment, Subcomment subcomment) {

    }

    public void changecomment(Blog blog, Article article, Comment comment, String text) {

    }

    public void changeSubcomment(Blog blog, Article article,
Comment comment, Subcomment subcomment, String text) {

    }

    public void addReaction(Blog blog, Article article, Reaction reactionType) {

    }

    public void removeReaction(Blog blog, Article article) {

    }

    public void recommendTheComment(Blog blog, Article article, Comment comment) {

    }

    public void notRecommendTheComment(Blog blog, Article article, Comment comment) {

    }

    public void getComments(Blog blog, Article article) {

    }

    public void getSubcomments(Blog blog, Article article, Comment comment) {

    }

    public void recommendTheSubcomment(Blog blog, Article article,
Comment comment, Subcomment subcomment) {

    }

    public void notRecommendTheSubcomment(Blog blog, Article article,
Comment comment, Subcomment subcomment) {

    }
}
