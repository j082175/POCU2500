package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Blog {
    private ArrayList<Article> articles;
    private String tagFilter;
    private String userFilter;
    private Order sortingType;

    private String owner;
    // sibal

    public Blog(String user) {

        this.tagFilter = null;
        this.userFilter = null;
        this.sortingType = Order.DESCENDING_BY_WRITE_TIME;
        articles = new ArrayList<>(100);

        this.owner = user;
    }

    // dangerous code
    public ArrayList<Article> getArticles() {

        setSortingType(this.sortingType);

        ArrayList<Article> newArticles = new ArrayList<>();
        if (tagFilter != null) {
            for (int i = 0; i < articles.size(); i++) {
                for (int j = 0; j < this.articles.get(i).getTag().size(); j++) {
                    if (this.articles.get(i).getTag().get(j).equals(tagFilter)) {
                        newArticles.add(this.articles.get(i));
                        break;
                    }
                }
            }
        } else if (userFilter != null) {
            for (int i = 0; i < articles.size(); i++) {
                if (this.articles.get(i).getUserName().equals(userFilter)) {
                    newArticles.add(this.articles.get(i));
                }
            }
        } else {
            return this.articles;
        }


        articles = newArticles;
        return this.articles;
    }

    public String getUser() {
        return this.owner;
    }

    // protected void setArticles(String title, String content, String name) {
    // this.articleCounts++;
    // this.articles.add(new Article(title, content, name));
    // }

    public String getTagFilter() {
        if (tagFilter == null) {
            return "";
        } else {
            return this.tagFilter;
        }
    }

    public String getUserFilter() {
        if (userFilter == null) {
            return "";
        } else {
            return this.tagFilter;
        }
    }

    public void setTagFilter(String tag) {
        this.tagFilter = tag;

    }

    public void setUserFilter(String user) {
        this.userFilter = user;

        // ArrayList<Article> newArticles = new ArrayList<>(100);
        // for (int i = 0; i < articles.size(); i++) {
        //     if (userFilter.equals(user)) {
        //         newArticles.add(articles.get(i));
        //     }
        // }

        // articles = newArticles;
    }

    public void setSortingType(Order sortingType) {
        this.sortingType = sortingType;

        switch (this.sortingType) {
            case DESCENDING_BY_WRITE_TIME:
                for (int i = 0; i < articles.size(); i++) {
                    for (int j = 0; j < articles.size() - 1 - i; j++) {
                        if (articles.get(j).getTimeNano() < articles.get(j + 1).getTimeNano()) {
                            Article backup = articles.get(j);

                            articles.set(j, articles.get(j + 1));
                            articles.set(j + 1, backup);
                        }
                    }
                }
                break;

            case ASCENDING_BY_WRITE_TIME:
                for (int i = 0; i < articles.size(); i++) {
                    for (int j = 0; j < articles.size() - 1 - i; j++) {
                        if (articles.get(j).getTimeNano() > articles.get(j + 1).getTimeNano()) {
                            Article backup = articles.get(j);
                            articles.set(j, articles.get(j + 1));
                            articles.set(j + 1, backup);
                        }
                    }
                }
                break;

            case DESCENDING_BY_REVISE_TIME:
                for (int i = 0; i < articles.size(); i++) {
                    for (int j = 0; j < articles.size() - 1 - i; j++) {
                        if (articles.get(j).getReviseTimeNano() < articles.get(j + 1).getReviseTimeNano()) {
                            Article backup = articles.get(j);
                            articles.set(j, articles.get(j + 1));
                            articles.set(j + 1, backup);
                        }
                    }
                }
                break;

            case ASCENDING_BY_REVISE_TIME:
                for (int i = 0; i < articles.size(); i++) {
                    for (int j = 0; j < articles.size() - 1 - i; j++) {
                        if (articles.get(j).getReviseTimeNano() > articles.get(j + 1).getReviseTimeNano()) {
                            Article backup = articles.get(j);
                            articles.set(j, articles.get(j + 1));
                            articles.set(j + 1, backup);
                        }
                    }
                }
                break;
            case ASCENDING_BY_ARTICLE:
                // for (int i = 0; i < articles.size(); i++) {
                //     for (int j = 0; j < articles.size() - 1 - i; j++) {
                //         if (articles.get(j).getReviseTimeNano() > articles.get(j + 1).getReviseTimeNano()) {
                //             Article backup = articles.get(j);
                //             articles.set(j, articles.get(j + 1));
                //             articles.set(j + 1, backup);
                //         }
                //     }
                // }
                break;

            default:
                break;
        }
    }

    public Order getSortingType() {
        return this.sortingType;
    }

    // User defined methods

    public void addArticle(Article article) {
        articles.add(article);
    }

    // public void changeArticleTitle(Article article, String title) {
    // for (int i = 0; i < this.articles.size(); i++) {
    // if (this.articles.get(i).getTitle().equals(title)) {
    // this.articles.get(i).setTitle(title);
    // }
    // }
    // }

    // public void changeArticleContent(Article article, String content) {
    // for (int i = 0; i < this.articles.size(); i++) {
    // if (this.articles.get(i).getContent().equals(content)) {
    // this.articles.get(i).setTitle(content);
    // }
    // }
    // }

    // public void addArticleTag(Article article, String tag) {
    // for (int i = 0; i < this.articles.size(); i++) {
    // if (this.articles.get(i).getTag().equals(tag)) {
    // this.articles.get(i).setTag(tag);
    // }
    // }
    // }

    // public void addComment(Article article, String content) {
    // for (int i = 0; i < articles.size(); i++) {
    // if (articles.get(i).getTitle().equals(article.getTitle())) {
    // articles.get(i).getComments().add(new Comment(content,
    // article.getComments().size()));
    // }
    // }
    // }

    // public void addSubComment(Article article, Comment comment, Comment
    // subcomment) {
    // for (int i = 0; i < articles.size(); i++) {
    // if (articles.get(i).getTitle().equals(article.getTitle())) {
    // if (articles.get(i).getComments().get(i).getId() == comment.getId()) {

    // }
    // }
    // }
    // }

    // public void changeComment(Article article, Comment comment, String text) {

    // }

    // public void changeSubComment(Article article, Comment comment, Comment
    // subcomment, String text) {

    // }

    // public void addReaction(Article article, Reaction reactionType) {
    // for (int i = 0; i < articles.size(); i++) {
    // if (articles.get(i).getTitle().equals(article.getTitle())) {
    // articles.get(i).increaseReactionCount(reactionType);
    // }
    // }
    // }

    // public void removeReaction(Article article, Reaction reactionType) {
    // for (int i = 0; i < articles.size(); i++) {
    // if (articles.get(i).getTitle().equals(article.getTitle())) {
    // articles.get(i).decreaseReactionCount(reactionType);
    // }
    // }
    // }

    // public void recommendTheComment(Article article, Comment comment) {

    // }

    // public void notRecommendTheComment(Article article, Comment comment) {

    // }

    // public ArrayList<Comment> getComments(Article article) {
    // ArrayList<Comment> a = new ArrayList<>();
    // for (int i = 0; i < articles.size(); i++) {
    // if (articles.get(i).getTitle().equals(article.getTitle())) {
    // a = articles.get(i).getComments();
    // break;
    // }
    // }

    // return a;
    // }

    // public void getSubComments(Article article, Comment comment) {

    // }

    // public void recommendTheSubComment(Article article, Comment comment, Comment
    // subcomment) {

    // }

    // public void notRecommendTheSubComment(Article article, Comment comment,
    // Comment subcomment) {

    // }
}
