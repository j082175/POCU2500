package academy.pocu.comp2500.assignment1.app;

import java.util.ArrayList;

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

            article3.addArticleTag("TAG1", "a");
            article3.addArticleTag("TAG2", "b");

            ArrayList<Article> articles = blog1.getArticles(); // 여기서 태그 달린것들만 가져와야함.

            // for (var a : articles) {
            // System.out.println(a.getTitle());
            // }
        }

        // 4. 작성자 필터
        {
            Blog blog1 = new Blog("BlogOwner1");
            blog1.setTagFilter("TAG1");
            // blog1.setUserFilter("a");

            Article article1 = new Article("Article1", "first_post", "a");
            Article article2 = new Article("Article2", "secone_post", "b");
            Article article3 = new Article("Article3", "third_post", "c");

            blog1.addArticle(article1);
            blog1.addArticle(article2);
            blog1.addArticle(article3);

            // article3.addArticleTag("TAG1");
            // article3.addArticleTag("TAG2");

            ArrayList<Article> articles = blog1.getArticles(); // 여기서 태그 달린것들만 가져와야함.

            // for (var a : articles) {
            // System.out.println(a.getTitle());
            // }
        }

        // 5. 작성 일시 기준
        {
            Blog blog1 = new Blog("BlogOwner1");
            blog1.setSortingType(Order.DESCENDING_BY_WRITE_TIME);

            Article article1 = new Article("Article1", "first_post", "a");
            // Thread.sleep(1000);
            Article article2 = new Article("Article2", "secone_post", "b");
            // Thread.sleep(1000);
            Article article3 = new Article("Article3", "third_post", "c");
            // Thread.sleep(1000);

            blog1.addArticle(article1);
            blog1.addArticle(article2);
            blog1.addArticle(article3);

            ArrayList<Article> articles = blog1.getArticles(); // 여기서 태그 달린것들만 가져와야함.

            // for (int i = 0; i < 3; i++) {
            // System.out.println(articles.get(i).getTitle());
            // }
        }

        // 6. 작성했던 블로그 글의 제목 수정
        {
            Blog blog1 = new Blog("BlogOwner1");
            blog1.setSortingType(Order.DESCENDING_BY_WRITE_TIME);

            Article article1 = new Article("Article1", "first_post", "a");
            // Thread.sleep(1000);
            Article article2 = new Article("Article2", "secone_post", "b");
            // Thread.sleep(1000);
            Article article3 = new Article("Article3", "third_post", "c");
            // Thread.sleep(1000);

            blog1.addArticle(article1);
            blog1.addArticle(article2);
            blog1.addArticle(article3);

            ArrayList<Article> articles = blog1.getArticles(); // 여기서 태그 달린것들만 가져와야함.

            articles.get(0).changeArticleTitle("title1", "a");

            // for (int i = 0; i < 3; i++) {
            // System.out.println(articles.get(i).getTitle());
            // }
        }

        // 7. 블로그글 본문수정

        {
            Blog blog1 = new Blog("BlogOwner1");
            blog1.setSortingType(Order.DESCENDING_BY_WRITE_TIME);

            Article article1 = new Article("Article1", "first_post", "a");
            Thread.sleep(100);
            Article article2 = new Article("Article2", "secone_post", "b");
            Thread.sleep(100);
            Article article3 = new Article("Article3", "third_post", "c");
            Thread.sleep(100);

            blog1.addArticle(article1);
            blog1.addArticle(article2);
            blog1.addArticle(article3);

            ArrayList<Article> articles = blog1.getArticles(); // 여기서 태그 달린것들만 가져와야함.

            Comment comment1 = new Comment("content1", "one");
            Comment comment2 = new Comment("content2", "two");

            Comment subcomment1 = new Comment("subcomment1", "one");
            Comment subcomment2 = new Comment("subcomment2", "two");

            article1.addComment(comment1);
            article1.addComment(comment2);

            comment1.addSubComment(subcomment1);
            comment1.addSubComment(subcomment2);

            var comments = article1.getComments();
            var subcomments = comment1.getSubComments();

            subcomment1.changeSubComment(user, content);

            for (var a : comments) {
                System.out.println(a.getContent());
            }

            for (var a : subcomments) {
                System.out.println(a.getContent());
            }

            
        }

        // 8.

    }
}
