package academy.pocu.comp2500.lab3;

import java.util.ArrayList;

public class ListItem {
    private String text;
    private char bulletStyle;
    private final ArrayList<ListItem> sublistItem;

    private String newString;

    private int addCount = 0;

    private int deadline = 0;

    public ListItem(String text) {
        this.text = text;
        this.bulletStyle = '*';
        sublistItem = new ArrayList<>();
        stringSetter();

    }

    public ListItem(String text, char bulletStyle) {
        this.text = text;
        this.bulletStyle = bulletStyle;
        sublistItem = new ArrayList<>();
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
        if (deadline != 1) {
            deadline++;
            // 먼저 기존 listitem 띄어쓰기 검사
            for (int i = 0; i < newString.length(); i++) {
                if (this.newString.charAt(i) == ' ') {
                    addCount++;
                }
            }
        }

            if (listItem == null) {
                return;
            }
    
            StringBuilder sb = new StringBuilder();
    
            if ((addCount % 4 == 0) && (this.bulletStyle == listItem.bulletStyle)) {
                
            }
            
            
            for (int i = 0; i < addCount; i++) {
                sb.append(" ");
            }
    
            sb.append(listItem.toString());
            listItem.newString = sb.toString();
    
            this.sublistItem.add(listItem);
        

    }

    public ListItem getSublistItem(int index) {
        return sublistItem.get(index);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(newString);

        for (int i = 0; i < sublistItem.size(); i++) {
            s.append(sublistItem.get(i).toString());
        }

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
