package academy.pocu.comp2500.assignment1.app;

import java.util.ArrayList;

import academy.pocu.comp2500.assignment1.Article;
import academy.pocu.comp2500.assignment1.Blog;
import academy.pocu.comp2500.assignment1.Order;
import academy.pocu.comp2500.assignment1.Writer;
import academy.pocu.comp2500.assignment1.Reader;

public class Program {

    public static void main(String[] args) {
        // 1.

        Blog blog1 = new Blog("first blog");

        System.out.println("---------------------------------------");

        // 2.

        Blog blog2 = new Blog("second blog");
        Writer writer1 = new Writer("JunSooCho");
        writer1.addArticle(blog2, "first article", "abc");
        Reader reader1 = new Reader("JohnWick");

        var articles = reader1.getArticles(blog2);

        System.out.println("1.name : " + articles.get(0).getName() + " 2.content : " + articles.get(0).getContent());

        System.out.println("---------------------------------------");

        // 3.

        Blog blog3 = new Blog("third blog");
        Writer writer2 = new Writer("second writer");
        writer2.addArticle(blog3, "one", "fwefwefwewf");
        writer2.addArticle(blog3, "two", "eeeeeeeeeerere");
        writer2.addArticle(blog3, "three", "reeeeeeee");
        Reader reader2 = new Reader("second reader");

        articles = reader2.getArticles(blog3);

        System.out.println(articles.get(1).getOrderNumber());

        // for(int i = 0; i < articles.size();i++) {
        // System.out.println(articles.get(i).getOrderNumber());
        // }

    }
}
