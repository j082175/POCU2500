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
        switch (blog.getSortingType()) {
            case DESCENDING_BY_WRITE_TIME :
                for (int i = 0; i < blog.getArticles().size() - 1; i++) {
                    for (int j = i; j < blog.getArticles().size() - 1; j++)
                    if (blog.getArticles().get(j).getOrderNumber() < blog.getArticles().get(j + 1).getOrderNumber()) {
                        Article backup = blog.getArticles().get(j);
                        blog.getArticles().set(j, blog.getArticles().get(j + 1));
                        blog.getArticles().set(j + 1, backup);
                    }
                }
            break;
            case ASCENDING_BY_WRITE_TIME :

            break;
            case DESCENDING_BY_REVISE_TIME :
            
            break;
            case ASCENDING_BY_REVISE_TIME :

            break;
            case ASCENDING_BY_ARTICLE :

            break;
        }
        return blog.getArticles();
    }

    public void addComment(Blog blog, Article article, Comment comment) {

    }

    public void addSubcomment(Blog blog, Article article,
Comment comment, SubComment subcomment) {

    }

    public void changecomment(Blog blog, Article article, Comment comment, String text) {

    }

    public void changeSubcomment(Blog blog, Article article,
Comment comment, SubComment subcomment, String text) {

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
Comment comment, SubComment subcomment) {

    }

    public void notRecommendTheSubcomment(Blog blog, Article article,
Comment comment, SubComment subcomment) {

    }
}
