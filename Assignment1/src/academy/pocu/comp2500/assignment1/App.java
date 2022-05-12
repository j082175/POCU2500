package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        registry.registerBlogCreator("Blog");

        registry.registerTagFilterSetter("Blog", "GetPagesByTag");

        registry.registerAuthorFilterSetter("Blog", "GetPagesByUserId");

        registry.registerPostOrderSetter("Blog", "GetPagesByOrder");

        registry.registerPostListGetter("Blog", "GetAllPages");

        registry.registerPostAdder("Blog", "AddNewPage");

        registry.registerPostTitleUpdater("Blog", "ReviseTheTitleOfPageRightBefore");

        registry.registerPostBodyUpdater("Blog", "ReviseTheContentOfPageRightBefore");

        registry.registerPostTagAdder("Blog", "AddNewTagToPage");

        registry.registerCommentAdder("Blog", "WriteTheComment");

        
    }
}
