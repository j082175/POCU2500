package academy.pocu.comp2500.lab3.app;

import java.util.ArrayList;

import academy.pocu.comp2500.lab3.ListItem;

public class Program {

    
    public static void main(String[] args) {


    //     System.out.println("few");

    //     ArrayList<ListItem> list = new ArrayList<>();

    //     ListItem listItem1 = new ListItem("My first item"); //띄어쓰기 x

    //     ListItem sublistItem1 = new ListItem("This is sublist item1", '>'); //띄어쓰기 x
    //     ListItem sublistItem2 = new ListItem("This is sublist item2", '>'); //띄어쓰기 x

    //     listItem1.addSublistItem(sublistItem1);
    //     listItem1.addSublistItem(sublistItem2);

    //     ListItem listItem2 = new ListItem("My second item");

    //     ListItem listItem3 = new ListItem("My third item");

    //     ListItem sublistItem3 = new ListItem("This is sublist item3", '>');
    //     ListItem subSublistItem1 = new ListItem("This is sub-sublist item1", '-');

    //     sublistItem3.addSublistItem(subSublistItem1); // 0 , 4
    //     listItem3.addSublistItem(sublistItem3);

    //     list.add(listItem1);
    //     list.add(listItem2);
    //     list.add(listItem3);

    //     String actual = toString(list);

    //     StringBuilder sb = new StringBuilder();
    //     sb.append(String.format("* My first item%s", System.lineSeparator()));
    //     sb.append(String.format("    > This is sublist item1%s", System.lineSeparator()));
    //     sb.append(String.format("    > This is sublist item2%s", System.lineSeparator()));
    //     sb.append(String.format("* My second item%s", System.lineSeparator()));
    //     sb.append(String.format("* My third item%s", System.lineSeparator()));
    //     sb.append(String.format("    > This is sublist item3%s", System.lineSeparator()));
    //     sb.append(String.format("        - This is sub-sublist item1%s",
    //             System.lineSeparator()));

    //     String expected = sb.toString();

    //     assert expected.equals(actual);

    //     System.out.print(actual);
    // }

    // private static String toString(ArrayList<ListItem> list) {
    //     StringBuilder sb = new StringBuilder();
    //     for (ListItem item : list) {
    //         sb.append(item);
    //     }

    //     return sb.toString();
    
    

        ListItem item1 = new ListItem("This is item1");
        ListItem sublistItem1 = new ListItem("This is sublist item1");
        ListItem subSublistItem1 = new ListItem("This is sub-sublist item1");
        ListItem subSublistItem2 = new ListItem("This is sub-sublist item2");
        ListItem subSubSublistItem1 = new ListItem("fuckyou!!!!!!!!");
        
        sublistItem1.addSublistItem(subSublistItem1); //0, 4
        sublistItem1.addSublistItem(subSublistItem2); //0, 4
        subSublistItem1.addSublistItem(subSubSublistItem1); //0, 4
        item1.addSublistItem(sublistItem1);

        String s = item1.toString();

        System.out.println(s);
    }
}
