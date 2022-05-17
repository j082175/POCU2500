package academy.pocu.comp2500.lab3.app;

import academy.pocu.comp2500.lab3.ListItem;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;



class ProgramTest {

    @Test
    void main() {
        ListItem item = new ListItem("This is item");

        item.addSublistItem(new ListItem("This is sublist item1"));
        item.addSublistItem(new ListItem("This is sublist item2"));

        String s = item.toString();
        /*
         * This is item
         * This is sublist item1
         * This is sublist item2
         */
        System.out.println(s);
        item.removeSublistItem(0);

        s = item.toString();
        /*
         * This is item
         * This is sublist item2
         */
        System.out.println(s);
        assertEquals(
                "* This is item\r\n" +
                        "    * This is sublist item2\r\n", s);





    }

}