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

    public static void multiTagFilterTestCase() {
        Blog blog1 = new Blog("BlogOwner1");

        Article article1 = new Article("a1", "p1", "body");
        Article article2 = new Article("a1", "p2", "body");
        Article article3 = new Article("a2", "p3", "body");

        blog1.addArticle(article1);
        blog1.addArticle(article2);
        blog1.addArticle(article3);

        article1.addArticleTag("a1", "t1");
        article2.addArticleTag("a1", "t2");
        article3.addArticleTag("a2", "t1");
        article3.addArticleTag("a2", "t2");

        blog1.setTagsOrNull("t1");

        var articles = blog1.getArticles();
        for (var a : articles) {
            System.out.println(a.getTitle());
        }
        System.out.println("------------------");

        //blog1.resetTagFilter();
        blog1.setTagsOrNull(null);

        blog1.setTagsOrNull("t2");

        var articles1 = blog1.getArticles();
        for (var a : articles1) {
            System.out.println(a.getTitle());
        }
        System.out.println("------------------");

        //blog1.resetTagFilter();
        blog1.setTagsOrNull(null);

        blog1.setTagsOrNull("t1");
        blog1.setTagsOrNull("t2");
        blog1.setTagsOrNull("t1");
        blog1.setTagsOrNull("t1");
        blog1.setTagsOrNull("t1");

        var articles2 = blog1.getArticles();
        for (var a : articles2) {
            System.out.println(a.getTitle());
        }
        System.out.println("------------------");

        article1.addReaction("a1", Reaction.ANGRY);
        article1.addReaction("a1", Reaction.ANGRY);
        article1.removeReaction("a1", Reaction.ANGRY);

        article1.addReaction("a1", Reaction.FUN);
        article1.addReaction("a1", Reaction.FUN);
        article1.addReaction("a1", Reaction.FUN);

        article1.addReaction("a1", Reaction.GREAT);

        article1.addReaction("a1", Reaction.LOVE);
        article1.addReaction("a1", Reaction.LOVE);
        article1.addReaction("a1", Reaction.LOVE);
        article1.addReaction("a1", Reaction.LOVE);

        article1.addReaction("a1", Reaction.SAD);
        article1.addReaction("a1", Reaction.SAD);
        article1.addReaction("a1", Reaction.SAD);

        System.out.println(article1.getReactions(Reaction.ANGRY));
        System.out.println(article1.getReactions(Reaction.FUN));
        System.out.println(article1.getReactions(Reaction.GREAT));
        System.out.println(article1.getReactions(Reaction.LOVE));
        System.out.println(article1.getReactions(Reaction.SAD));

    }

    public static void tagUserComplexFilterTestCase() {
        Blog blog1 = new Blog("BlogOwner1");

        Article article1 = new Article("a1", "p1", "body");
        Article article2 = new Article("a1", "p2", "body");
        Article article3 = new Article("a2", "p3", "body");
        Article article4 = new Article("a2", "p4", "body");

        blog1.addArticle(article1);
        blog1.addArticle(article2);
        blog1.addArticle(article3);
        blog1.addArticle(article4);

        article1.addArticleTag("a1", "t1");
        article2.addArticleTag("a1", "t2");
        article3.addArticleTag("a2", "t1");
        article4.addArticleTag("a2", "t2");

        blog1.setTagsOrNull("t1");

        var articles = blog1.getArticles();

        for (var a : articles) {
            System.out.println(a.getTitle());
        }
        System.out.println("----------------------------");

        //blog1.resetTagFilter();
        blog1.setTagsOrNull(null);

        blog1.setUserOrNull("a1");

        var articles2 = blog1.getArticles();

        for (var a : articles2) {
            System.out.println(a.getTitle());
        }
        System.out.println("----------------------------");

        //blog1.resetUserFilter();
        blog1.setUserOrNull(null);

        blog1.setTagsOrNull("t1");

        blog1.setUserOrNull("a2");

        var articles3 = blog1.getArticles();
        for (var a : articles3) {
            System.out.println(a.getTitle());
        }

        System.out.println("----------------------------");

        //blog1.resetTagFilter();
        blog1.setTagsOrNull(null);
        //blog1.resetUserFilter();
        blog1.setUserOrNull(null);



        blog1.setTagsOrNull("t2");
        blog1.setUserOrNull("a1");
        var articles4 = blog1.getArticles();
        for (var a : articles4) {
            System.out.println(a.getTitle());
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

        // 3. 태그 필터를 사용하여 지정된 태그 있는것만 가져옴.
        {
            Blog blog1 = new Blog("BlogOwner1");
            blog1.setTagsOrNull("TAG1");

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
            blog1.setTagsOrNull("TAG1");
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
            blog1.setTagsOrNull("tag1");
            blog1.setTagsOrNull("tag1");
            blog1.setTagsOrNull("tag1");
            blog1.setUserOrNull("b");

            Article article1 = new Article("a", "article1", "first_post");
            // Thread.sleep(1000);
            Article article2 = new Article("b", "article2", "secone_post");
            // Thread.sleep(1000);
            Article article3 = new Article("c", "article3", "third_post");
            // Thread.sleep(1000);

            blog1.addArticle(article1);
            blog1.addArticle(article2);
            blog1.addArticle(article3);

            article1.addArticleTag("a", "tag3");
            article1.addArticleTag("a", "tag2");
            article1.addArticleTag("a", "tag1");

            article2.addArticleTag("b", "tag1");
            article2.addArticleTag("b", "tag3");
            article2.addArticleTag("b", "tag2");

            article3.addArticleTag("c", "tag1");
            article3.addArticleTag("c", "tag2");
            article3.addArticleTag("c", "tag3");

            ArrayList<Article> articles = blog1.getArticles(); // 여기서 태그 달린것들만 가져와야함.

            for (var a : articles) {
                System.out.println(a.getTitle());
            }
        }

        // 7. 블로그글 본문수정

        {
            // Blog blog1 = new Blog("BlogOwner1");
            // // blog1.setSortingType(Order.ASCENDING_BY_ARTICLE);

            // Article article1 = new Article("a", "Crticle1", "first_post");
            // Thread.sleep(100);
            // Article article2 = new Article("b", "Brticle2", "secone_post");
            // Thread.sleep(100);
            // Article article3 = new Article("c", "Article3", "third_post");
            // Thread.sleep(100);

            // blog1.addArticle(article1);
            // blog1.addArticle(article2);
            // blog1.addArticle(article3);

            // article1.addReaction(Reaction.GREAT);
            // article1.addReaction(Reaction.ANGRY);
            // article1.addReaction(Reaction.GREAT);
            // article1.addReaction(Reaction.GREAT);

            // ArrayList<Article> articles = blog1.getArticles(); // 여기서 태그 달린것들만 가져와야함.

            // for (var a : articles) {
            // System.out.println(a.getTitle());
            // }

            // Comment comment1 = new Comment("one", "content1");
            // Comment comment2 = new Comment("two", "content2");
            // Comment comment3 = new Comment("three", "content3");
            // Comment comment4 = new Comment("four", "content4");
            // Comment comment5 = new Comment("five", "content5");

            // // article1 에 comment 5개 추가

            // article1.addComment(comment1);
            // article1.addComment(comment2);
            // article1.addComment(comment3);
            // article1.addComment(comment4);
            // article1.addComment(comment5);

            // /// comment1 에 subcomment 5개 추가
            // Comment subcomment1 = new Comment("one", "subcomment1");
            // Comment subcomment2 = new Comment("two", "subcomment2");
            // Comment subcomment3 = new Comment("three", "subcomment3");
            // Comment subcomment4 = new Comment("four", "subcomment4");
            // Comment subcomment5 = new Comment("five", "subcomment5");

            // comment1.addSubComment(subcomment1);
            // comment1.addSubComment(subcomment2);
            // comment1.addSubComment(subcomment3);
            // comment1.addSubComment(subcomment4);
            // comment1.addSubComment(subcomment5);

            // /// subcomment1 에 5개 추가

            // Comment subsubcomment1 = new Comment("one", "subsubcomment1");
            // Comment subsubcomment2 = new Comment("two", "subsubcomment2");
            // Comment subsubcomment3 = new Comment("three", "subsubcomment3");
            // Comment subsubcomment4 = new Comment("four", "subsubcomment4");
            // Comment subsubcomment5 = new Comment("five", "subsubcomment5");

            // subcomment1.addSubComment(subsubcomment1);
            // subcomment1.addSubComment(subsubcomment2);
            // subcomment1.addSubComment(subsubcomment3);
            // subcomment1.addSubComment(subsubcomment4);
            // subcomment1.addSubComment(subsubcomment5);

            // /// comment1 추천 ///
            // comment1.recommendTheComment();
            // comment1.recommendTheComment();
            // comment1.recommendTheComment(); // 3

            // comment2.notRecommendTheComment();
            // comment2.notRecommendTheComment(); // -2

            // comment3.recommendTheComment();
            // comment3.recommendTheComment();
            // comment3.recommendTheComment();
            // comment3.recommendTheComment(); // 4

            // comment4.notRecommendTheComment();
            // comment4.notRecommendTheComment();
            // comment4.notRecommendTheComment(); // -3

            // comment5.recommendTheComment();
            // comment5.notRecommendTheComment(); // 0

            // var result = article1.getComments();
            // for (var a : result) {
            // System.out.println(a.getContent() + " " + a.getRCount());
            // }

            // System.out.println("-----------------------------------");

            // comment1.recommendTheSubComment(0);
            // comment1.recommendTheSubComment(0);
            // comment1.recommendTheSubComment(0); // 3

            // comment1.notRecommendTheSubComment(1);
            // comment1.notRecommendTheSubComment(1); // -2

            // comment1.recommendTheSubComment(2);
            // comment1.recommendTheSubComment(2);
            // comment1.recommendTheSubComment(2);
            // comment1.recommendTheSubComment(2); // 4

            // comment1.notRecommendTheSubComment(3);
            // comment1.notRecommendTheSubComment(3);
            // comment1.notRecommendTheSubComment(3); // -3

            // comment1.recommendTheSubComment(4);
            // comment1.notRecommendTheSubComment(4); // 0

            // var resultsub = comment1.getSubComments();

            // for (var a : resultsub) {
            // System.out.println(a.getContent() + " " + a.getRCount());
            // }

            // System.out.println("-----------------------------------");

            // subcomment1.recommendTheSubComment(0);
            // subcomment1.recommendTheSubComment(0);
            // subcomment1.recommendTheSubComment(0); // 3

            // subcomment1.notRecommendTheSubComment(1);
            // subcomment1.notRecommendTheSubComment(1); // -2

            // subcomment1.recommendTheSubComment(2);
            // subcomment1.recommendTheSubComment(2);
            // subcomment1.recommendTheSubComment(2);
            // subcomment1.recommendTheSubComment(2); // 4

            // subcomment1.notRecommendTheSubComment(3);
            // subcomment1.notRecommendTheSubComment(3);
            // subcomment1.notRecommendTheSubComment(3); // -3

            // subcomment1.recommendTheSubComment(4);
            // subcomment1.notRecommendTheSubComment(4); // 0

            // var resultsubsub = subcomment1.getSubComments();

            // for (var a : resultsubsub) {
            // System.out.println(a.getContent() + " " + a.getRCount());
            // }

            // subcomment1.changeSubComment("three", "fuckyou");

            // var resultsubsub2 = subcomment1.getSubComments();
            // for (var a : resultsubsub2) {
            // System.out.println(a.getContent() + " " + a.getRCount());
            // }
        }

        // 8.

        {
            Blog blog1 = new Blog("1");
            Article article1 = new Article("a", "t1", "fewfwe");
            blog1.addArticle(article1);

            Comment comment1 = new Comment("one", "fe");
            Comment comment2 = new Comment("two", "fe2");
            Comment comment3 = new Comment("three", "fe3");
            Comment comment4 = new Comment("four", "fe4");

            article1.addComment(comment1);
            article1.addComment(comment2);
            article1.addComment(comment3);
            article1.addComment(comment4);

            multiTagFilterTestCase();
            tagUserComplexFilterTestCase();
        }
    }
}
