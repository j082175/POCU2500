package academy.pocu.comp2500.assignment4;

import academy.pocu.comp2500.assignment4.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        // registry.registerDrawPixelCommandCreator("Foo");
        // OR
        // registry.registerDrawPixelCommandCreator("Foo", "bar");
        registry.registerDrawPixelCommandCreator("DrawPixelCommand");
        registry.registerIncreasePixelCommandCreator("IncreasePixelCommand", "execute");
        registry.registerDecreasePixelCommandCreator("DecreasePixelCommand", "execute");
        registry.registerFillHorizontalLineCommandCreator("FillHorizontalLineCommand", "execute");
        registry.registerFillVerticalLineCommandCreator("FillVerticalLineCommand", "execute");
        registry.registerToLowercaseCommandCreator("ToLowerCommand", "execute");
        registry.registerToUppercaseCommandCreator("ToUpperCommand", "execute");
        registry.registerClearCommandCreator("ClearCommand", "execute");
    }
}
