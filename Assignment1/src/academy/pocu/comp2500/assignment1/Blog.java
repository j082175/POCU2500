package academy.pocu.comp2500.assignment1;

import java.lang.reflect.Array;
import java.sql.Struct;
import java.util.ArrayList;

public class Blog {
    private ArrayList<Page> pages;
    private String name;

    public Blog(String name) {
        this.name = name;
        pages = new ArrayList<>(100);
    }

    public void AddNewPage(String article, String content, User writer, String tag) {
        pages.add(new Page(article, content, writer, tag));

    }

    public void ReviseTheContentOfPageRightBefore(User writer, String content) {
        ArrayList<Page> newPages = new ArrayList<>(100);

        for (int i = 0; i < pages.size(); i++) {
            if (pages.get(i).getUserId() == writer.getUserId()) {
                newPages.add(pages.get(i));
            }
        }

        Page backup;
        for (int i = 0; i < newPages.size() - 1; i++) {
            if (newPages.get(i).getMillisNow() > newPages.get(i + 1).getMillisNow()) {
                backup = newPages.get(i);
                newPages.set(i, newPages.get(i + 1));
                newPages.set(i + 1, backup);
            }
        }

        Page latestPage = newPages.get(newPages.size() - 1);

        for (int i = 0; i < pages.size(); i++) {
            if (pages.get(i).getMillisNow() == latestPage.getMillisNow()) {
                pages.get(i).setContent(content);
            }
        }

    }

    public void ReviseTheTitleOfPageRightBefore(User writer, String article) {
        ArrayList<Page> newPages = new ArrayList<>(100);

        for (int i = 0; i < pages.size(); i++) {
            if (pages.get(i).getUserId() == writer.getUserId()) {
                newPages.add(pages.get(i));
            }
        }

        Page backup;
        for (int i = 0; i < newPages.size() - 1; i++) {
            if (newPages.get(i).getMillisNow() > newPages.get(i + 1).getMillisNow()) {
                backup = newPages.get(i);
                newPages.set(i, newPages.get(i + 1));
                newPages.set(i + 1, backup);
            }
        }

        Page latestPage = newPages.get(newPages.size() - 1);

        for (int i = 0; i < pages.size(); i++) {
            if (pages.get(i).getMillisNow() == latestPage.getMillisNow()) {
                pages.get(i).setArticle(article);
            }
        }
    }

    public boolean AddNewTagToPage(String article, String tag) {
        
        return false;
    }

    public boolean GetPages(User user, String tag, Order sortingType) {
        // 1. 기본값 : user, tag 와 sortingType 이 null 일때
        // 2. user 만 넣을때
        // 3. tag 만 넣을때
        // 4. 정렬 조건만 넣을때

        return false;
    }

    public ArrayList<Page> GetPagesByTag(String tag) {
        ArrayList<Page> newPages = new ArrayList<>(100);

        for (int i = 0; i < this.pages.size(); i++) {
            if (this.pages.get(i).getTag() == tag) {
                newPages.add(this.pages.get(i));
            }
        }

        return newPages;
    }

    public ArrayList<Page> GetPagesByUserId(int userId) {
        ArrayList<Page> newPages = new ArrayList<>(100);

        for (int i = 0; i < this.pages.size(); i++) {
            if (this.pages.get(i).getUserId() == userId) {
                newPages.add(this.pages.get(i));
            }
        }

        return newPages;
    }

    public ArrayList<Page> GetPagesByOrder(Order sortingType) {
        ArrayList<Page> newPages = new ArrayList<>(100);
        newPages = pages;
        Page backup;
        switch (sortingType) {
            case DESCENDING_BY_WRITE_TIME:
                for (int i = 0; i < newPages.size(); i++) {
                    for (int j = 0; j < newPages.size() - 1 - i; j++) {
                        if (newPages.get(j).getMillisNow() > newPages.get(j + 1).getMillisNow()) {

                            backup = newPages.get(i);
                            newPages.set(j, newPages.get(j + 1));
                            newPages.set(j + 1, backup);
                        }
                    }
                }
                break;
            case ASCENDING_BY_WRITE_TIME:
            
                for (int i = 0; i < newPages.size(); i++) {

                    for (int j = 0; j < newPages.size() - 1 - i; j++) {
                        if (newPages.get(i).getMillisNow() < newPages.get(j + 1).getMillisNow()) {

                            backup = newPages.get(j);
                            newPages.set(j, newPages.get(j + 1));
                            newPages.set(j + 1, backup);
                        }
                    }
                }
                break;
            case DESCENDING_BY_REVISE_TIME:

                break;
            case ASCENDING_BY_REVISE_TIME:

                break;
            case ASCENDING_BY_ARTICLE:

                break;
        }

        return newPages;
    }

    public ArrayList<Page> GetAllPages() {

        return this.pages;
    }

    public void WriteTheComment(int index, String comment) {
        pages.get(index).setComments(comment);
    }

}
