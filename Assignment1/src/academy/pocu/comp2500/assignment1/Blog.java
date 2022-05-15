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
    }

    public void setWriterFilter(Writer user) {
        this.writerFilter = user.getName();
    }

    public void setSortingType(Order sortingType) {
        this.sortingType = sortingType;
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
