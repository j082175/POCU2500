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

    public void addComment(Blog blog, Article article, String content) {
        for (int i = 0; i < blog.getArticles().size(); i++) {
            if (blog.getArticles().get(i).getName().equals(article.getName())) {
                blog.getArticles().get(i).getComments().add(new Comment(content, article.getComments().size()));
            }
        }
    }

    public void addSubComment(Blog blog, Article article, Comment comment, SubComment subcomment) {
        for (int i = 0; i < blog.getArticles().size(); i++) {
            if (blog.getArticles().get(i).getName().equals(article.getName())) {
                if (blog.getArticles().get(i).getComments().get(i).getId() == comment.getId()) {
                    
                }
            }
        }
    }

    public void changeComment(Blog blog, Article article, Comment comment, String text) {

    }

    public void changeSubComment(Blog blog, Article article, Comment comment, SubComment subcomment, String text) {

    }

    public void addReaction(Blog blog, Article article, Reaction reactionType) {
        for (int i = 0; i < blog.getArticles().size(); i++) {
            if (blog.getArticles().get(i).getName().equals(article.getName())) {
                blog.getArticles().get(i).increaseReactionCount(reactionType);
            }
        }
    }

    public void removeReaction(Blog blog, Article article, Reaction reactionType) {
        for (int i = 0; i < blog.getArticles().size(); i++) {
            if (blog.getArticles().get(i).getName().equals(article.getName())) {
                blog.getArticles().get(i).decreaseReactionCount(reactionType);
            }
        }
    }

    public void recommendTheComment(Blog blog, Article article, Comment comment) {

    }

    public void notRecommendTheComment(Blog blog, Article article, Comment comment) {

    }

    public ArrayList<Comment> getComments(Blog blog, Article article) {
        for (int i = 0; i < blog.getArticles().size(); i++) {
            if (blog.getArticles().get(i).getName().equals(article.getName())) {
                return blog.getArticles().get(i).getComments();
            }
        }

        return null;
    }

    public void getSubComments(Blog blog, Article article, Comment comment) {

    }

    public void recommendTheSubComment(Blog blog, Article article, Comment comment, SubComment subcomment) {

    }

    public void notRecommendTheSubComment(Blog blog, Article article, Comment comment, SubComment subcomment) {

    }
}
