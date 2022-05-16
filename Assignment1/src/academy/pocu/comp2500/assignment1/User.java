package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    // dangerous
    public void addArticle(Blog blog, String title, String content) {
        blog.setArticles(title, content, this.name);
    }

    public void changeArticleTitle(Blog blog, Article article, String title) {
        
    }

    public void changeArticleContent(Blog blog, Article article, String content) {

    }

    public void addArticleTag(Blog blog, Article article, String tag) {

    }

    public String getName() {
        return this.name;
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
