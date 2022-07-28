package academy.pocu.comp2500.assignment4;

public class Canvas {
    private int width;
    private int height;
    private char pixel[][];

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixel = new char[width][height];
        this.clear();
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void drawPixel(int x, int y, char ch) {
        if (x >= 0 && y >= 0 && x < width && y < height) {
            this.pixel[x][y] = ch;
        }
    }

    public char getPixel(int x, int y) {
        if (x >= 0 && y >= 0 && x < width && y < height) {
            return this.pixel[x][y];
        } else {
            return 0;
        }
    }

    public boolean increasePixel(int x, int y) {
        if (this.pixel[x][y] >= 32 && this.pixel[x][y] < 126) {
            this.pixel[x][y]++;
            return true;
        } else {
            return false;
        }
    }

    public boolean decreasePixel(int x, int y) {
        if (this.pixel[x][y] > 32 && this.pixel[x][y] <= 126) {
            this.pixel[x][y]--;
            return true;
        } else {
            return false;
        }
    }

    public void toUpper(int x, int y) {
        if (this.pixel[x][y] >= 97 && this.pixel[x][y] <= 122) {
            this.pixel[x][y] -= 32;
        }
    }

    public void toLower(int x, int y) {
        if (this.pixel[x][y] >= 65 && this.pixel[x][y] <= 90) {
            this.pixel[x][y] += 32;
        }
    }

    public void fillHorizontalLine(int y, char ch) {
        if (y >= 0 && y < height) {
            for (int i = 0; i < width; i++) {
                this.pixel[i][y] = ch;
            }
        }
    }

    public void fillVerticalLine(int x, char ch) {
        if (x >= 0 && x < width) {
            for (int i = 0; i < height; i++) {
                this.pixel[x][i] = ch;
            }
        }
    }

    public void clear() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.pixel[i][j] = ' ';
            }
        }
    }

    public String getDrawing() {

        StringBuilder builder = new StringBuilder();

        for (int j = 0; j < height + 2; j++) {
            if (j == 0 || j == height + 1) {
                builder.append('+');
                for (int i = 0; i < width; i++) {
                    builder.append('-');
                }
                builder.append('+');
                builder.append('\n');
                continue;
            }

            builder.append('|');
            for (int k = 0; k < width; k++) {
                builder.append(this.pixel[k][j - 1]);
            }
            builder.append('|');
            builder.append('\n');

        }

        return builder.toString();
    }
}
