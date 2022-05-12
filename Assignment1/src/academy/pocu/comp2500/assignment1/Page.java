package academy.pocu.comp2500.assignment1;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Page {

    private int orderByWritten = 0;
    private String article;
    private String content;
    private ArrayList<Comment> comments;
    private String tag;
    private User user;

    private LocalDateTime writeTime;
    private long writeMilTime;

    private LocalDateTime reviseTime;
    private long reviseMilTime;

    public Page(String article, String content, User user) {
        this.article = article;
        this.content = content;
        this.user = user;

        writeTime = LocalDateTime.now();
        writeMilTime = System.currentTimeMillis();

        comments = new ArrayList<>(100);
    }

    public Page(String article, String content, User user, String tag) {
        this.article = article;
        this.content = content;
        this.user = user;
        this.tag = tag;

        writeTime = LocalDateTime.now();
        writeMilTime = System.currentTimeMillis();

        comments = new ArrayList<>(100);
    }

    public ArrayList<Comment> GetAllComments() {

        return new ArrayList<>();
    }

    public String getArticle() {
        return this.article;
    }

    public String getContent() {
        return this.content;
    }

    public String getTag() {
        return this.tag;
    }

    public int getUserId() {
        return this.user.getUserId();
    }

    public String getLocalTimeNow() {

        return this.writeTime.format(DateTimeFormatter.ofPattern("작성일시 : yyyy년 MM월 dd일 HH시 mm분 ss초"));
    }

    public long getMillisNow() {
        return this.writeMilTime;
    }

    public String setContent(String content){
        this.content = content;
        return this.content;
    }

    public String setArticle(String article){
        this.article = article;
        return this.article;
    }

    public void InitializeTheReviseTime(){
        this.reviseTime = LocalDateTime.now();
        this.reviseMilTime = System.currentTimeMillis();
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(String comment) {
        this.comments.add(new Comment(comment));
    }
}
