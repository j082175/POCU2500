package academy.pocu.comp2500.assignment4;

public class Canvas {

    private int width;
    private int height;
    private char pixel[][];

    private int x;
    private int y;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixel = new char[width][height];
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    private void drawPixel(int x, int y, char ch) {
        if (Math.abs(x) <= (width / 2) && Math.abs(y) <= (height / 2)) {
            this.pixel[x][y] = ch;
        }
    }

    private char getPixel(int x, int y) {
        if (Math.abs(x) <= (width / 2) && Math.abs(y) <= (height / 2)) {
            return this.pixel[x][y];
        } else {
            return 0;
        }
    }

    private boolean increasePixel(int x, int y) {
        if (this.pixel[x][y] >= 32 && this.pixel[x][y] < 126) {
            this.pixel[x][y]++;
            return true;
        } else {
            return false;
        }
    }

    private boolean decreasePixel(int x, int y) {
        if (this.pixel[x][y] > 32 && this.pixel[x][y] <= 126) {
            this.pixel[x][y]--;
            return true;
        } else {
            return false;
        }
    }

    private void toUpper(int x, int y) {
        if (this.pixel[x][y] >= 97 && this.pixel[x][y] <= 122) {
            this.pixel[x][y] -= 32;
        }
    }

    private void toLower(int x, int y) {
        if (this.pixel[x][y] >= 65 && this.pixel[x][y] <= 90) {
            this.pixel[x][y] += 32;
        }
    }

    private void fillHorizontalLine(int y, char ch) {
        if (Math.abs(y) <= (height / 2)) {
            for (int i = 0; i < height; i ++) {
                this.pixel[i][y] = ch;
            }
        }
    }

    private void fillVerticalLine(int x, char ch) {
        if (Math.abs(x) <= (width / 2)) {
            for (int i = 0; i < width; i++) {
                this.pixel[x][i] = ch;
            }
        }
    }

    private void clear() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.pixel[i][j] = ' ';
            }
        }
    }
}
