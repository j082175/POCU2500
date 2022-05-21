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

    public static void timeTanos() {
        int sum = 0;
        for (int i = 0; i < 9999; i++) {
            for (int j = 0; j < 9999; j++) {
                sum += 1;
            }
        }
    }

    public static void main(String[] args) {
        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();

        // 1.

        Blog blog1 = new Blog("blog1Owner");
        Article article1 = new Article("title1", "fefe", "writer1");
        Comment comment1 = new Comment("comment1", 1);
        Comment subComment1 = new Comment("sub_comment", 1);
        blog1.addArticle(article1);
        var articles1 = blog1.getArticles("reader1");
        
        blog1.getArticles(user)


        System.out.println("---------------------------------------");

        // 2.

        // Blog blog2 = new Blog("second blog","blog2Owner");


        // var articles = blog2.addArticle(title, content, name);

        // System.out.println("1.name : " + articles.get(0).getName() + " 2.content : " + articles.get(0).getContent());

        // System.out.println("---------------------------------------");

        // // 3.

        // Blog blog3 = new Blog("third blog");
        // Writer writer2 = new Writer("second writer");
        // writer2.addArticle(blog3, "one", "fwefwefwewf");
        // // timeTanos();
        // writer2.addArticle(blog3, "two", "eeeeeeeeeerere");
        // // timeTanos();
        // writer2.addArticle(blog3, "three", "reeeeeeee");
        // // timeTanos();
        // Reader reader2 = new Reader("second reader");

        // articles = reader2.getArticles(blog3);
        // blog3.setSortingType(Order.ASCENDING_BY_REVISE_TIME);
        // for (int i = 0; i < articles.size(); i++) {
        //     System.out.println(articles.get(i).getOrderNumber());
        // }

        // for (int i = 0; i < articles.size(); i++) {
        //     System.out.println(articles.get(i).getReviseTime());
        // }

        // System.out.println("---------------------------------------");

        // reader2.addReaction(blog3, articles.get(0), Reaction.GREAT);
        // int arr[] = articles.get(0).getReactionCount();
        // System.out.println(arr[0]);
        // reader2.removeReaction(blog3, articles.get(0), Reaction.GREAT);
        // System.out.println(arr[0]);

        // reader2.addComment(blog3, articles.get(0), "first comment");
        // var zeroComments = reader2.getComments(blog3, articles.get(0));
        // System.out.println(zeroComments.get(0).getContent());

        

        
    }
}
