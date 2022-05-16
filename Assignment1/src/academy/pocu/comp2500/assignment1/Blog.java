package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Blog {
    private ArrayList<Article> articles;
    private String tagFilter;
    private String writerFilter;
    private Order sortingType;
    private String blogName;

    //sibal
    private int articleCounts;

    public Blog(String name) {
        this.blogName = name;
        this.tagFilter = null;
        this.writerFilter = null;
        this.sortingType = Order.DESCENDING_BY_WRITE_TIME;
        articles = new ArrayList<>(100);
        articleCounts = 0;
    }

    // dangerous code
    public final ArrayList<Article> getArticles() {
        if (articles == null) {
            
        }
        return this.articles;
    }

    public ArrayList<Article> setArticles() {
        this.articleCounts++;
        return this.articles;
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

    public void setWriterFilter(Writer user) {
        this.writerFilter = user.getName();

        ArrayList<Article> newArticles = new ArrayList<>(100);
        for (int i = 0; i < articles.size(); i++) {
            if (writerFilter.equals(user.getName())) {
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

    public String getWriterFilter() {
        return this.writerFilter;
    }

    public String getTagFilter() {
        return this.tagFilter;
    }
}
