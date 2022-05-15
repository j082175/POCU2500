package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        registry.registerBlogCreator("Blog"); //: 블로그를 생성하는 생성자를 등록한다.
        registry.registerTagFilterSetter("Blog","setTagFilter"); //: 태그 필터를 설정하는 메서드를 등록한다.
        registry.registerAuthorFilterSetter("Blog","setWriterFilter"); //: 작성자 필터를 설정하는 메서드를 등록한다.
        registry.registerPostOrderSetter("Blog","setSortingType"); //: 블로그 글의 정렬 방법을 설정하는 메서드를 등록한다.
        registry.registerPostListGetter("Reader","getArticle"); //: 블로그 글 목록을 가져오는 메서드를 등록한다.
        registry.registerPostAdder("Writer","addArticle"); //: 블로그에 글을 추가하는 메서드를 등록한다.
        registry.registerPostTitleUpdater("Writer","changeArticleTitle"); //: 발행된 블로그 글의 제목을 바꾸는 메서드를 등록한다.
        registry.registerPostBodyUpdater("Writer","changeArticleContent"); //: 발행된 블로그 글의 본문을 바꾸는 메서드를 등록한다.
        registry.registerPostTagAdder("Writer","addArticleTag"); //: 블로그 글에 태그를 추가하는 메서드를 등록한다.
        registry.registerCommentAdder("Reader","addComment"); //: 블로그 글에 댓글을 추가하는 메서드를 등록한다.
        registry.registerSubcommentAdder("Reader","addSubComment") ;//: 댓글에 하위 댓글을 추가하는 메서드를 등록한다.
        registry.registerCommentUpdater("Reader","changeComment"); //: 댓글의 내용을 바꾸는 메서드를 등록한다.
        registry.registerSubcommentUpdater("Reader","changeSubComment"); //: 하위 댓글의 내용을 바꾸는 메서드를 등록한다.
        registry.registerReactionAdder("Reader","addReaction"); //: 블로그 글에 리액션을 추가하는 메서드를 등록한다.
        registry.registerReactionRemover("Reader","removeReaction"); //: 블로그 글로부터 리액션을 제거하는 메서드를 등록한다.
        registry.registerCommentUpvoter("Reader","recommendTheComment"); //: 댓글을 추천하는 메서드를 등록한다.
        registry.registerCommentDownvoter("Reader","notRecommendTheComment"); //: 댓글을 비추천하는 메서드를 등록한다.
        registry.registerCommentListGetter("Reader","getComments"); //: 블로그 글에 달린 댓글들을 가져오는 메서드를 등록한다.
        registry.registerSubcommentListGetter("Reader","getSubComments"); //: 댓글에 달린 하위 댓글들을 가져오는 메서드를 등록한다.
        registry.registerSubcommentUpvoter("Reader","recommendTheSubComment"); //: 하위 댓글을 추천하는 메서드를 등록한다.
        registry.registerSubcommentDownvoter("Reader","notRecommendTheSubComment"); //: 하위 댓글을 비추천하는 메서드를 등록한다.

        
    }
}
