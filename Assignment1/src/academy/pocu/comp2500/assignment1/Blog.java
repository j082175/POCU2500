package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Blog {
    private ArrayList<Article> articles;
    private String tagFilter;
    private String writerFilter;
    private Order sortingType;
    private String blogName;

    public Blog(String name) {
        this.blogName = name;
        this.tagFilter = null;
        this.writerFilter = null;
        this.sortingType = Order.DESCENDING_BY_WRITE_TIME;
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
