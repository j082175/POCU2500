package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Blog {
    private ArrayList<Article> articles;
    private String tagFilter;
    private Writer writerFilter;
    private Order sortingType;
    private String blogName;

    public Blog(String name) {
        this.blogName = name;
        this.tagFilter = null;
        this.writerFilter = null;
        this.sortingType = Order.DESCENDING_BY_WRITE_TIME;
    }

    public void setTagFilter(String tag) {

    }

    public void setWriterFilter(Writer writer) {

    }

    public void setSortingType(Order sortingType) {
        
    }
}
