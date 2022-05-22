package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Blog {
    private ArrayList<Article> articles;
    private ArrayList<String> tagFilter;
    private String userFilter;
    private Order sortingType;

    private String owner;
    // sibal

    public Blog(String user) {

        this.tagFilter = new ArrayList<>();
        this.userFilter = null;
        this.sortingType = Order.DESCENDING_BY_WRITE_TIME;
        articles = new ArrayList<>(100);

        this.owner = user;
    }

    // dangerous code
    public ArrayList<Article> getArticles() {
        boolean isChecked = false;

        setSortingType(this.sortingType);

        ArrayList<Article> result = new ArrayList<>();
        result = this.articles;
        ArrayList<Article> newArticles = new ArrayList<>();
        if (tagFilter.size() != 0) {
            for (int i = 0; i < this.articles.size(); i++) {
                for (int j = 0; j < this.tagFilter.size(); j++) {
                    for (int k = 0; k < this.articles.get(i).getTag().size(); k++) {
                        if (this.articles.get(i).getTag().get(k).equals(tagFilter.get(j))) {
                            newArticles.add(this.articles.get(i));
                            isChecked = true;
                            break;
                            // newArticles.add(this.articles.get(i));
                        } else {
                            isChecked = false;
                        }

                    }
                    if (isChecked == true) {
                        break;
                    }
                }
            }
            result = newArticles;
        }

        ArrayList<Article> newArticles2 = new ArrayList<>();

        if (userFilter != null) {
            for (int i = 0; i < result.size(); i++) {
                if (result.get(i).getUserName().equals(userFilter)) {
                    newArticles2.add(result.get(i));
                }
            }
            result = newArticles2;

        }

        if (this.articles == null) {

        }
        return result;
    }

    public String getUser() {
        return this.owner;
    }

    public ArrayList<String> getTagFilter() {
        return this.tagFilter;
    }

    public String getUserFilter() {
        if (userFilter == null) {
            return "";
        } else {
            return this.userFilter;
        }
    }

    public void setTagsOrNull(String tagOrNull) {
        if (tagOrNull == null) {
            this.tagFilter.clear();
        }

        if (tagOrNull != null) {
            for (int i = 0; i < this.tagFilter.size(); i++) {
                if (!this.tagFilter.get(i).equals(tagOrNull)) {
                    this.tagFilter.add(tagOrNull);
                }
            }

            if (this.tagFilter.size() == 0) {
                this.tagFilter.add(tagOrNull);
            }
        }
    }

    public void setUserOrNull(String userOrNull) {
        if (userOrNull == null) {
            this.userFilter = null;
        }
        this.userFilter = userOrNull;
    }

    public void setSortingType(Order sortingType) {
        this.sortingType = sortingType;

        switch (this.sortingType) {
            case DESCENDING_BY_WRITE_TIME:
                for (int i = 0; i < articles.size(); i++) {
                    for (int j = 0; j < articles.size() - 1 - i; j++) {
                        if (articles.get(j).getTimeNano() < articles.get(j + 1).getTimeNano()) {
                            Article backup = articles.get(j);

                            articles.set(j, articles.get(j + 1));
                            articles.set(j + 1, backup);
                        }
                    }
                }
                break;

            case ASCENDING_BY_WRITE_TIME:
                for (int i = 0; i < articles.size(); i++) {
                    for (int j = 0; j < articles.size() - 1 - i; j++) {
                        if (articles.get(j).getTimeNano() > articles.get(j + 1).getTimeNano()) {
                            Article backup = articles.get(j);
                            articles.set(j, articles.get(j + 1));
                            articles.set(j + 1, backup);
                        }
                    }
                }
                break;

            case DESCENDING_BY_REVISE_TIME:
                for (int i = 0; i < articles.size(); i++) {
                    for (int j = 0; j < articles.size() - 1 - i; j++) {
                        if (articles.get(j).getReviseTimeNano() < articles.get(j + 1).getReviseTimeNano()) {
                            Article backup = articles.get(j);
                            articles.set(j, articles.get(j + 1));
                            articles.set(j + 1, backup);
                        }
                    }
                }
                break;

            case ASCENDING_BY_REVISE_TIME:
                for (int i = 0; i < articles.size(); i++) {
                    for (int j = 0; j < articles.size() - 1 - i; j++) {
                        if (articles.get(j).getReviseTimeNano() > articles.get(j + 1).getReviseTimeNano()) {
                            Article backup = articles.get(j);
                            articles.set(j, articles.get(j + 1));
                            articles.set(j + 1, backup);
                        }
                    }
                }
                break;
            case ASCENDING_BY_ARTICLE:
                for (int i = 0; i < articles.size(); i++) {
                    for (int j = 0; j < articles.size() - 1 - i; j++) {
                        if (articles.get(j).getTitle().compareTo(articles.get(j + 1).getTitle()) > 0) {
                            Article backup = articles.get(j);
                            articles.set(j, articles.get(j + 1));
                            articles.set(j + 1, backup);
                        }
                    }
                }
                break;

            default:
                break;
        }
    }

    public Order getSortingType() {
        return this.sortingType;
    }

    // User defined methods

    public void addArticle(Article article) {
        articles.add(article);
    }
}
