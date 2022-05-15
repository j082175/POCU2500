package academy.pocu.comp2500.assignment1;

public class Writer {
    private String writerName;

    public Writer(String name) {
        this.writerName = name;
    }

    // dangerous
    public void addArticle(Blog blog, String name, String content) {
        blog.getArticles().add(new Article(name, content));
    }

    public void changeArticleTitle(Blog blog, Article article, String title) {

    }

    public void changeArticleContent(Blog blog, Article article, String content) {

    }

    public void addArticleTag(Blog blog, Article article, String tag) {

    }

    public String getName() {
        return this.writerName;
    }
}
