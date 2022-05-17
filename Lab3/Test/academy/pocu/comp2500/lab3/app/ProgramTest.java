package academy.pocu.comp2500.lab3.app;

import academy.pocu.comp2500.lab3.ListItem;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;



class ProgramTest {

    @Test
    void main() {

    ListItemTest test = new ListItemTest();

    test.testListItemString();
    test.testListItemStringChar();
    test.testAddSublistItem();
    test.testGetSublistItem();
    test.testRemoveSublistItem();
    test.testGetText();
    test.testSetText();
    test.testGetBulletStyle();
    test.testSetBulletStyle();
    test.testToString();




    }

}