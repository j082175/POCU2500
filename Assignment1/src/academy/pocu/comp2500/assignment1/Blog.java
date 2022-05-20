package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Blog {
    private ArrayList<Article> articles;
    private String tagFilter;
    private String userFilter;
    private Order sortingType;

    
    private String userName;
    private String owner;
    //sibal
    private int articleCounts;

    public Blog(String user) {

        this.tagFilter = null;
        this.userFilter = null;
        this.sortingType = Order.DESCENDING_BY_WRITE_TIME;
        articles = new ArrayList<>(100);
        articleCounts = 0;

        this.owner = user;
    }

    // dangerous code
    public ArrayList<Article> getArticles(String user) {
        this.userName = user;
        return this.articles;
    }

    // protected void setArticles(String title, String content, String name) {
    //     this.articleCounts++;
    //     this.articles.add(new Article(title, content, name));
    // }

    public int getArticlesCount() {
        return this.articleCounts;
    }

    public void setTagFilter(String tag) {
        this.tagFilter = tag;

        ArrayList<Article> newArticles = new ArrayList<>(100);
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getTag().equals(tag)) {
                newArticles.add(articles.get(i));
            }
        }

        articles = newArticles;
    }

    public void setUserFilter(String user) {
        this.userFilter = user;

        ArrayList<Article> newArticles = new ArrayList<>(100);
        for (int i = 0; i < articles.size(); i++) {
            if (userFilter.equals(user)) {
                newArticles.add(articles.get(i));
            }
        }

        articles = newArticles;
    }

    public void setSortingType(Order sortingType) {
        this.sortingType = sortingType;

        switch (this.sortingType) {
            case DESCENDING_BY_WRITE_TIME:
                for (int i = 0; i < articles.size(); i++) {
                    for (int j = 0; j < articles.size() - 1 - i; j++) {
                        // if (articles.get(j).getOrderNumber() < articles.get(j + 1).getOrderNumber()) {
                        //     Article backup = articles.get(j);
                        //     articles.set(j, articles.get(j + 1));
                        //     articles.set(j + 1, backup);
                        // }
                    }
                }
                break;

            case ASCENDING_BY_WRITE_TIME:
                for (int i = 0; i < articles.size(); i++) {
                    for (int j = 0; j < articles.size() - 1 - i; j++) {
                        // if (articles.get(j).getOrderNumber() > articles.get(j + 1).getOrderNumber()) {
                        //     Article backup = articles.get(j);
                        //     articles.set(j, articles.get(j + 1));
                        //     articles.set(j + 1, backup);
                        // }
                    }
                }
                break;

            case DESCENDING_BY_REVISE_TIME:
                for (int i = 0; i < articles.size(); i++) {
                    for (int j = 0; j < articles.size() - 1 - i; j++) {
                        // if (articles.get(j).getReviseTime() < articles.get(j + 1).getReviseTime()) {
                        //     Article backup = articles.get(j);
                        //     articles.set(j, articles.get(j + 1));
                        //     articles.set(j + 1, backup);
                        // }
                    }
                }
                break;

            case ASCENDING_BY_REVISE_TIME:
                for (int i = 0; i < articles.size(); i++) {
                    for (int j = 0; j < articles.size() - 1 - i; j++) {
                        // if (articles.get(j).getReviseTime() > articles.get(j + 1).getReviseTime()) {
                        //     Article backup = articles.get(j);
                        //     articles.set(j, articles.get(j + 1));
                        //     articles.set(j + 1, backup);
                        // }
                    }
                }
                break;
            case ASCENDING_BY_ARTICLE:

                break;
                
            default:
                break;
        }
    }

    public Order getSortingType() {
        return this.sortingType;
    }



    //User defined methods

    public void addArticle(Article article) {
        articles.add(article);
    }

    public void changeArticleTitle(Article article, String title) {
        
    }

    public void changeArticleContent(Article article, String content) {

    }

    public void addArticleTag(Article article, String tag) {

    }

    public void addComment(Article article, String content) {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getName().equals(article.getName())) {
                articles.get(i).getComments().add(new Comment(content, article.getComments().size()));
            }
        }
    }

    public void addSubComment(Article article, Comment comment, SubComment subcomment) {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getName().equals(article.getName())) {
                if (articles.get(i).getComments().get(i).getId() == comment.getId()) {
                    
                }
            }
        }
    }

    public void changeComment(Article article, Comment comment, String text) {

    }

    public void changeSubComment(Article article, Comment comment, SubComment subcomment, String text) {

    }

    public void addReaction(Article article, Reaction reactionType) {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getName().equals(article.getName())) {
                articles.get(i).increaseReactionCount(reactionType);
            }
        }
    }

    public void removeReaction(Article article, Reaction reactionType) {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getName().equals(article.getName())) {
                articles.get(i).decreaseReactionCount(reactionType);
            }
        }
    }

    public void recommendTheComment(Article article, Comment comment) {

    }

    public void notRecommendTheComment(Article article, Comment comment) {

    }

    public ArrayList<Comment> getComments(Article article) {
        ArrayList<Comment> a = new ArrayList<>();
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getName().equals(article.getName())) {
                a = articles.get(i).getComments();
                break;
            }
        }

        return a;
    }

    public void getSubComments(Article article, Comment comment) {

    }

    public void recommendTheSubComment(Article article, Comment comment, SubComment subcomment) {

    }

    public void notRecommendTheSubComment(Article article, Comment comment, SubComment subcomment) {

    }
}
