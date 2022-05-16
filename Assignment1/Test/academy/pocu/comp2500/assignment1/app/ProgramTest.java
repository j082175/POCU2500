package academy.pocu.comp2500.assignment1.app;

import academy.pocu.comp2500.assignment1.App;
import academy.pocu.comp2500.assignment1.registry.Registry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    @Test
    void timeTanos() {
    }

    @Test
    void main() {
        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();
        //assert 1 > 2;
    }
}