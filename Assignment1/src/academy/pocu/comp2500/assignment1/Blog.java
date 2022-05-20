package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Blog {
    private ArrayList<Article> articles;
    private String tagFilter;
    private String userFilter;
    private Order sortingType;
    private String blogName;
    
    private String userName;
    private String owner;
    //sibal
    private int articleCounts;

    public Blog(String name, String user) {
        this.blogName = name;
        this.tagFilter = null;
        this.userFilter = null;
        this.sortingType = Order.DESCENDING_BY_WRITE_TIME;
        articles = new ArrayList<>(100);
        articleCounts = 0;

        this.owner = user;
    }

    // dangerous code
    protected ArrayList<Article> getArticles() {
        if (articles == null) {

        }
        return this.articles;
    }

    protected void setArticles(String title, String content, String name) {
        this.articleCounts++;
        this.articles.add(new Article(title, content, name, this.articles.size(), System.currentTimeMillis()));
    }

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
                for (int i = 0; i < getArticles().size(); i++) {
                    for (int j = 0; j < getArticles().size() - 1 - i; j++) {
                        if (getArticles().get(j).getOrderNumber() < getArticles().get(j + 1).getOrderNumber()) {
                            Article backup = getArticles().get(j);
                            getArticles().set(j, getArticles().get(j + 1));
                            getArticles().set(j + 1, backup);
                        }
                    }
                }
                break;

            case ASCENDING_BY_WRITE_TIME:
                for (int i = 0; i < getArticles().size(); i++) {
                    for (int j = 0; j < getArticles().size() - 1 - i; j++) {
                        if (getArticles().get(j).getOrderNumber() > getArticles().get(j + 1).getOrderNumber()) {
                            Article backup = getArticles().get(j);
                            getArticles().set(j, getArticles().get(j + 1));
                            getArticles().set(j + 1, backup);
                        }
                    }
                }
                break;

            case DESCENDING_BY_REVISE_TIME:
                for (int i = 0; i < getArticles().size(); i++) {
                    for (int j = 0; j < getArticles().size() - 1 - i; j++) {
                        if (getArticles().get(j).getReviseTime() < getArticles().get(j + 1).getReviseTime()) {
                            Article backup = getArticles().get(j);
                            getArticles().set(j, getArticles().get(j + 1));
                            getArticles().set(j + 1, backup);
                        }
                    }
                }
                break;

            case ASCENDING_BY_REVISE_TIME:
                for (int i = 0; i < getArticles().size(); i++) {
                    for (int j = 0; j < getArticles().size() - 1 - i; j++) {
                        if (getArticles().get(j).getReviseTime() > getArticles().get(j + 1).getReviseTime()) {
                            Article backup = getArticles().get(j);
                            getArticles().set(j, getArticles().get(j + 1));
                            getArticles().set(j + 1, backup);
                        }
                    }
                }
                break;
            case ASCENDING_BY_ARTICLE:

                break;
                
            default:
                break;
        }
    }

    public String getBlogName() {
        return this.blogName;
    }

    public Order getSortingType() {
        return this.sortingType;
    }



    //User defined methods

    public void addArticle(String title, String content) {
        articles.add(new Article(title, content, this.owner));
    }

    public void changeArticleTitle(Blog blog, Article article, String title) {
        
    }

    public void changeArticleContent(Blog blog, Article article, String content) {

    }

    public void addArticleTag(Blog blog, Article article, String tag) {

    }

    public String getName() {
        return this.blogName;
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
