package academy.pocu.comp2500.assignment1;

public class Subcomment {
    private Recommend recommendCount[];
    private String content;

    public Subcomment(String content) {
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
