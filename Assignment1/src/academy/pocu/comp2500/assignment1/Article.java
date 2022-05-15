package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Article {
    private ArrayList<Comment> comments;
    private Reaction reactionCount;
    private String content;
    private String tag;
    private String articleName;
    //private OffsetDateTime

    public Article(String name, String content) {
        this.articleName = name;
        this.content = content;
    }

    public Article(String name, String content, String tag) {
        this.articleName = name;
        this.content = content;
        this.tag = tag;
    }
    
}
