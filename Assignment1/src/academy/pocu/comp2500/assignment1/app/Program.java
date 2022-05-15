package academy.pocu.comp2500.assignment1.app;

import java.util.ArrayList;

import academy.pocu.comp2500.assignment1.Blog;
import academy.pocu.comp2500.assignment1.Order;
import academy.pocu.comp2500.assignment1.Writer;
import academy.pocu.comp2500.assignment1.Reader;

public class Program {


    public static void main(String[] args) {
        //1. 

        Blog blog1 = new Blog("first blog");


        //2.

        Writer writer1 = new Writer("JunSooCho");
        writer1.addArticle(blog1,"first article","abc");
        Reader reader1 = new Reader("JohnWick");
        var articles = reader1.getArticles(blog1);
    }
}
