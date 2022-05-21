package academy.pocu.comp2500.assignment1.app;

import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import academy.pocu.comp2500.assignment1.App;
import academy.pocu.comp2500.assignment1.Article;
import academy.pocu.comp2500.assignment1.Blog;
import academy.pocu.comp2500.assignment1.Comment;
import academy.pocu.comp2500.assignment1.Order;
import academy.pocu.comp2500.assignment1.Reaction;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class Program {

    public static void main(String[] args) throws InterruptedException {
        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();

        // 1.
        {
            Blog blog1 = new Blog("BlogOwner1");
            Article article1 = new Article("Article1", "first_post", "BlogOwner1");
            blog1.addArticle(article1);
        }

        // 2.
        {
            Blog blog1 = new Blog("BlogOwner1");
            Article article1 = new Article("Article1", "first_post", "a");
            Article article2 = new Article("Article2", "secone_post", "b");
            Article article3 = new Article("Article3", "third_post", "c");

            blog1.addArticle(article1);
            blog1.addArticle(article2);
            blog1.addArticle(article3);

            ArrayList<Article> articles = blog1.getArticles();
            // for (var a : articles) {
            // System.out.println(a.getTitle() + a.getContent() + a.getUserName());
            // }
        }

        // 3. 태그 필터를 사용하여 지정된 태그 있는것만 가져옴.
        {
            Blog blog1 = new Blog("BlogOwner1");
            blog1.setTagFilter("TAG1");

            Article article1 = new Article("Article1", "first_post", "a");
            Article article2 = new Article("Article2", "secone_post", "b");
            Article article3 = new Article("Article3", "third_post", "c");

            blog1.addArticle(article1);
            blog1.addArticle(article2);
            blog1.addArticle(article3);

            article3.addArticleTag("TAG1");

            ArrayList<Article> articles = blog1.getArticles(); // 여기서 태그 달린것들만 가져와야함.

            for (var a : articles) {
                System.out.println(a.getTitle());
            }
        }

    }
}
