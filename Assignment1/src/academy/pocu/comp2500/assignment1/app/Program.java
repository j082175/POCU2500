package academy.pocu.comp2500.assignment1.app;

import java.util.ArrayList;

import academy.pocu.comp2500.assignment1.Blog;
import academy.pocu.comp2500.assignment1.Order;
import academy.pocu.comp2500.assignment1.Page;
import academy.pocu.comp2500.assignment1.User;

public class Program {

    public static void timetanos() {
        int sum = 0;
        for (int i = 0; i < 99999999; i++) {
            sum += i;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello");
        // 1.

        Blog blog1 = new Blog("First Blog");
        User userWriter1 = new User(10);
        User userWriter2 = new User(20);
        User userWriter3 = new User(30);

        blog1.AddNewPage("First Page", "hello!", userWriter1, "a");
        timetanos();
        blog1.AddNewPage("Second Page", "hello12!", userWriter3, "b");
        timetanos();
        blog1.AddNewPage("Third Page", "hello3232!", userWriter3, "c");
        timetanos();
        blog1.AddNewPage("Fourth Page", "hello424242!", userWriter2, "d");
        timetanos();
        blog1.AddNewPage("Fifth Page", "hello1111555!", userWriter2, "d");
        timetanos();
        blog1.AddNewPage("Sixth Page", "amare", userWriter1, "d");
        timetanos();
        blog1.AddNewPage("Seventh Page", "helfwe1111555!", userWriter3, "e");
        timetanos();
        blog1.AddNewPage("Eighth Page", "not", userWriter2, "e");
        timetanos();
        blog1.AddNewPage("Ninth Page", "9 words", userWriter1, "a");
        timetanos();
        blog1.AddNewPage("Tenth Page", "10 words", userWriter3, "e");

        // 2.
        User userVisitor = new User(20);
        ArrayList<Page> pages = blog1.GetAllPages();
        for (var p : pages) {
            System.out.println("article: " + p.getArticle() + "  content: " + p.getContent() + "  tag: " + p.getTag());
        }

        System.out.println("-------------------------------");

        // 3.
        pages = blog1.GetPagesByTag("d");
        for (var p : pages) {
            System.out.println("article: " + p.getArticle() + "  content: " + p.getContent() + "  tag: " + p.getTag());
        }

        System.out.println("-------------------------------");

        // 4.
        pages = blog1.GetPagesByUserId(30);
        for (var p : pages) {
            System.out.println("article: " + p.getArticle() + "  content: " + p.getContent() + "  tag: " + p.getTag());
        }

        System.out.println("-------------------------------");

        // 5.
        pages = blog1.GetAllPages();

        System.out.println(pages.get(0).getMillisNow());
        System.out.println(pages.get(1).getMillisNow());
        System.out.println(pages.get(2).getMillisNow());
        System.out.println(pages.get(3).getMillisNow());
        System.out.println(pages.get(4).getMillisNow());
        System.out.println(pages.get(5).getMillisNow());
        System.out.println(pages.get(6).getMillisNow());
        System.out.println(pages.get(7).getMillisNow());

        System.out.println("-------------------------------");
        // 6. 보류

        pages = blog1.GetPagesByOrder(Order.DESCENDING_BY_WRITE_TIME);
        for (var p : pages) {
            System.out.println("article: " + p.getArticle() + "  content: " + p.getContent() + "  tag: " + p.getTag());
        }

        System.out.println();

        pages = blog1.GetPagesByOrder(Order.ASCENDING_BY_WRITE_TIME);
        for (var p : pages) {
            System.out.println("article: " + p.getArticle() + "  content: " + p.getContent() + "  tag: " + p.getTag());
        }

        System.out.println("-------------------------------");

        // 7. ?

        // 8.

        blog1.ReviseTheContentOfPageRightBefore(userWriter3, "99999999999999999999999999");

        for (var p : pages) {
            System.out.println("article: " + p.getArticle() + "  content: " + p.getContent() + "  tag: " + p.getTag());
        }

        System.out.println("-------------------------------");


        // 9.

        blog1.ReviseTheTitleOfPageRightBefore(userWriter1, "JUNSOOCHO");

        for (var p : pages) {
            System.out.println("article: " + p.getArticle() + "  content: " + p.getContent() + "  tag: " + p.getTag());
        }

        System.out.println("-------------------------------");

        //10. 보류



        //11. 

        pages.get(0).getComments().get(0).getComment();


        //12.


        System.out.println("-------------------------------");

        //13.

        blog1.WriteTheComment(0, "Why are you so serious?");
        var get = pages.get(0).GetAllComments();
        get.get(0).getComment();
    }
}
