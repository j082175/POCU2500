package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this

        registry.registerBlogCreator("Blog"); //: 블로그를 생성하는 생성자를 등록한다.
        registry.registerTagFilterSetter("Blog", "setTagFilter"); //: 태그 필터를 설정하는 메서드를 등록한다.
        registry.registerAuthorFilterSetter("Blog", "setUserFilter"); //: 작성자 필터를 설정하는 메서드를 등록한다.
        registry.registerPostOrderSetter("Blog", "setSortingType"); //: 블로그 글의 정렬 방법을 설정하는 메서드를 등록한다.
        registry.registerPostListGetter("User", "getArticles"); //: 블로그 글 목록을 가져오는 메서드를 등록한다.
        registry.registerPostAdder("User", "addArticle"); //: 블로그에 글을 추가하는 메서드를 등록한다.
        registry.registerPostTitleUpdater("User", "changeArticleTitle"); //: 발행된 블로그 글의 제목을 바꾸는 메서드를 등록한다.
        registry.registerPostBodyUpdater("User", "changeArticleContent"); //: 발행된 블로그 글의 본문을 바꾸는 메서드를 등록한다.
        registry.registerPostTagAdder("User", "addArticleTag"); //: 블로그 글에 태그를 추가하는 메서드를 등록한다.
        registry.registerCommentAdder("User", "addComment"); //: 블로그 글에 댓글을 추가하는 메서드를 등록한다.
        registry.registerSubcommentAdder("User", "addSubComment"); //: 댓글에 하위 댓글을 추가하는 메서드를 등록한다.
        registry.registerCommentUpdater("User", "changeComment"); //: 댓글의 내용을 바꾸는 메서드를 등록한다.
        registry.registerSubcommentUpdater("User", "changeSubComment"); //: 하위 댓글의 내용을 바꾸는 메서드를 등록한다.
        registry.registerReactionAdder("User", "addReaction"); //: 블로그 글에 리액션을 추가하는 메서드를 등록한다.
        registry.registerReactionRemover("User", "removeReaction"); //: 블로그 글로부터 리액션을 제거하는 메서드를 등록한다.
        registry.registerCommentUpvoter("User", "recommendTheComment"); //: 댓글을 추천하는 메서드를 등록한다.
        registry.registerCommentDownvoter("User", "notRecommendTheComment"); //: 댓글을 비추천하는 메서드를 등록한다.
        registry.registerCommentListGetter("User", "getComments"); //: 블로그 글에 달린 댓글들을 가져오는 메서드를 등록한다.
        registry.registerSubcommentListGetter("User", "getSubComments"); //: 댓글에 달린 하위 댓글들을 가져오는 메서드를 등록한다.
        registry.registerSubcommentUpvoter("User", "recommendTheSubComment"); //: 하위 댓글을 추천하는 메서드를 등록한다.
        registry.registerSubcommentDownvoter("User", "notRecommendTheSubComment"); //: 하위 댓글을 비추천하는 메서드를 등록한다.

    }
}
