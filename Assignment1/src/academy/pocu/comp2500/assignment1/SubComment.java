package academy.pocu.comp2500.assignment1;

public class SubComment {
    private Recommend recommendCount[];
    private String content;

    public SubComment(String content) {
        recommendCount = new Recommend[2];
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public Recommend[] getRecommentCount() {
        return this.recommendCount;
    }
}
