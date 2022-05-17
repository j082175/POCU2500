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

        listItem.addCount += this.addCount + 4;
        // StringBuilder sb = new StringBuilder();

        // if (listItem.sublistItem != null) {
        // for (int i = 0; i < listItem.sublistItem.size(); i++) {
        // ListItem list;
        // list = listItem.getSublistItem(i);
        // // System.out.println(list);

        // String a = list.toString();
        // String b = " ";
        // String result = b + a;
        // listItem.getSublistItem(i).newString = result;
        // }
        // }

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

        // if (deadline != 1) {
        // deadline++;
        // // 먼저 기존 listitem 띄어쓰기 검사
        for (int i = 0; i < newString.length(); i++) {
            if (this.newString.charAt(i) == '*' || this.newString.charAt(i) == '-'
                    || this.newString.charAt(i) == '>') {
                break;
            }

            if (this.newString.charAt(i) == ' ') {
                this.addCount++;
            }
        }

        for (int i = 0; i < listItem.newString.length(); i++) {
            if (listItem.newString.charAt(i) == '*' || listItem.newString.charAt(i) == '-'
                    || listItem.newString.charAt(i) == '>') {
                break;
            }

            if (listItem.newString.charAt(i) == ' ') {
                listItem.addCount++;
            }
        }

        this.sublistItem.add(listItem);

        subindex++;
    }

    public ListItem getSublistItem(int index) {
        return sublistItem.get(index);
        // return sublistItem[index];
    }

    ////////////////////////////
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append(this.newString);

        for (int i = 0; i < sublistItem.size(); i++) {
            s.append("    ");

            // for (int j = 0; j < newString.length(); j++) {
            // if (this.newString.charAt(j) == '*' || this.newString.charAt(j) == '-'
            // || this.newString.charAt(j) == '>') {
            // break;
            // }

            // if (this.newString.charAt(j) == ' ') {
            // getSublistItem(i).addCount++;
            // }
            // }
            for (int j = 0; j < addCount / 2; j++) {
                s.append(" ");
                for (int k = 0; k < getSublistItem(i).addCount / 2 - 1; k++) {
                    s.append(" ");
                }

            }

            s.append(sublistItem.get(i).toString());
        }

        return s.toString();
    }
    ///////////////////////////////

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
