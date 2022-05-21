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

    public static void timeTanos() {
        int sum = 0;
        for (int i = 0; i < 9999; i++) {
            for (int j = 0; j < 9999; j++) {
                sum += 1;
            }
        }
    }

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

        // 3.
        {
            Blog blog1 = new Blog("BlogOwner1");
            

            Article article1 = new Article("Article1", "first_post", "a");
            Article article2 = new Article("Article2", "secone_post", "b");
            Article article3 = new Article("Article3", "third_post", "c");

            blog1.addArticle(article1);
            blog1.addArticle(article2);
            blog1.addArticle(article3);

            ArrayList<Article> articles = blog1.getArticles();
            articles.get(0).addArticleTag("TAG1");

            for (var a : articles) {
                System.out.println(a.getTitle());
            }
        }

    }
}
