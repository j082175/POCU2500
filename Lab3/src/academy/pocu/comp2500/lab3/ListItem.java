package academy.pocu.comp2500.lab3;

import java.util.ArrayList;

public class ListItem {
    private String text;
    private char bulletStyle;
    private final ArrayList<ListItem> sublistItem;
    // private ListItem sublistItem[];
    private String newString;

    private int addCount = 0;

    private int deadline = 0;

    private int subindex = 0;

    public ListItem(String text) {
        this.text = text;
        this.bulletStyle = '*';
        sublistItem = new ArrayList<>();
        stringSetter();
        // sublistItem = new ListItem[100];
    }

    public ListItem(String text, char bulletStyle) {
        this.text = text;
        this.bulletStyle = bulletStyle;
        sublistItem = new ArrayList<>();
        stringSetter();
        // sublistItem = new ListItem[100];
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public char getBulletStyle() {
        return this.bulletStyle;
    }

    public void setBulletStyle(char bulletStyle) {
        this.bulletStyle = bulletStyle;
    }

    public void addSublistItem(ListItem listItem) {
        if (listItem == null) {
            return;
        }
        // listItem.addCount += 4;

        if (listItem.sublistItem != null) {
            for (int i = 0; i < listItem.sublistItem.size(); i++) {
                ListItem list;
                list = listItem.getSublistItem(i);
                // System.out.println(list);

                String a = list.toString();
                String b = "    ";
                String result = b + a;
                listItem.getSublistItem(i).newString = result;
            }
        }

        // if (listItem.sublistItem != null) {
        // for (int i = 0; i < subindex; i++) {
        // System.out.println(listItem.subindex);
        // listItem.sublistItem[i].addCount += 4;
        // // String a = listItem.sublistItem.get(i).toString();
        // // String b = " ";
        // // String result = b + a;
        // // listItem.sublistItem.get(i).newString = result;
        // }
        // }

        StringBuilder sb = new StringBuilder();

        // if (deadline != 1) {
        // deadline++;
        // // 먼저 기존 listitem 띄어쓰기 검사
        // for (int i = 0; i < newString.length(); i++) {
        // if (this.newString.charAt(i) == '*' || this.newString.charAt(i) == '-'
        // || this.newString.charAt(i) == '>') {
        // break;
        // }

        // if (this.newString.charAt(i) == ' ') {
        // listItem.addCount++;
        // }
        // }
        // }

        // for (int i = 0; i < 4; i++) {
        // sb.append(" ");
        // }

        // // why?
        // for (int i = 0; i < listItem.addCount; i++) {
        // sb.append(" ");
        // }

        // for (int i = 0; i < listItem.addCount; i++) {
        // sb.append(" ");
        // }
        // sb.append(listItem.toString());
        // listItem.newString = sb.toString();

        this.sublistItem.add(listItem);
        // this.sublistItem[subindex] = listItem;
        subindex++;
    }

    public ListItem getSublistItem(int index) {
        return sublistItem.get(index);
        // return sublistItem[index];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append(newString);

        for (int i = 0; i < sublistItem.size(); i++) {
            s.append("    ");
            s.append(sublistItem.get(i).toString());
        }

        // for (int i = 0; i < subindex + 1; i++) {
        // s.append(sublistItem[i].toString());
        // }

        return s.toString();
    }

    public void removeSublistItem(int index) {
        // 색인 값은 언제나 유효하다고 가정한다.

        this.sublistItem.remove(index);

    }

    private void stringSetter() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%c %s%s", this.bulletStyle, this.text, System.lineSeparator()));

        this.newString = sb.toString();
    }
}
