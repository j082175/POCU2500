package academy.pocu.comp2500.lab3;

import java.util.ArrayList;

public class ListItem {
    private String text;
    private char bulletStyle;
    private final ArrayList<ListItem> sublistItem;

    private StringBuilder sb;

    public ListItem(String text) {
        this.text = text;
        this.bulletStyle = '*';
        sublistItem = new ArrayList<>();
        sb = new StringBuilder();
        stringSetter();
    }

    public ListItem(String text, char bulletStyle) {
        this.text = text;
        this.bulletStyle = bulletStyle;
        sublistItem = new ArrayList<>();
        sb = new StringBuilder();
        stringSetter();
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
        this.sublistItem.add(listItem);
        sb.append(listItem.toString());
    }

    public ListItem getSublistItem(int index) {
        return sublistItem.get(index);
    }

    public String toString() {

        return sb.toString();
    }

    public void removeSublistItem(int index) {
        // 색인 값은 언제나 유효하다고 가정한다.
        this.sublistItem.remove(index);
    }

    private void stringSetter() {
        switch (bulletStyle) {
            case '*':
                break;
            case '>':
                sb.append("    ");
                break;
            case '-':
                sb.append("        ");
                break;
            default:
                break;
        }
        
        sb.append(String.format("%c %s%s", this.bulletStyle,this.text,System.lineSeparator()));
    }
}
