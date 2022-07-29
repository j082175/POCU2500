package academy.pocu.comp2500.assignment4;

import java.util.LinkedList;

public class OverdrawAnalyzer extends Canvas {
    private int listCount[][];
    private LinkedList<Character> pixelHistory[][];
    private int totalOverdrawCount = 0;

    public OverdrawAnalyzer(int width, int height) {
        super(width, height);
        this.pixelHistory = new LinkedList[width][height];
        this.listCount = new int[width][height];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.pixelHistory[i][j] = new LinkedList<>();
            }
        }
    }

    public LinkedList<Character> getPixelHistory(int x, int y) {
        return this.pixelHistory[x][y];
    }

    public int getOverdrawCount(int x, int y) {
        return 0;
    }

    public int getOverdrawCount() {
        return this.totalOverdrawCount;
    }

    @Override
    public void drawPixel(int x, int y, char ch) {
        if (super.getPixel(x, y) != ch) {
            super.drawPixel(x, y, ch);
            totalOverdrawCount++;
            this.pixelHistory[x][y].add(this.listCount[x][y]++, super.getPixel(x, y));
        }
    }

    @Override
    public boolean increasePixel(int x, int y) {
        if (super.getPixel(x, y) == 126) {
            return false;
        }

        boolean result = super.increasePixel(x, y);
        totalOverdrawCount++;
        this.pixelHistory[x][y].add(this.listCount[x][y]++, super.getPixel(x, y));
        return result;
    }

    @Override
    public boolean decreasePixel(int x, int y) {
        if (super.getPixel(x, y) == 32) {
            return false;
        }

        boolean result = super.decreasePixel(x, y);
        totalOverdrawCount++;
        this.pixelHistory[x][y].add(this.listCount[x][y]++, super.getPixel(x, y));
        return result;
    }

    @Override
    public void toUpper(int x, int y) {
        if (super.getPixel(x, y) >= 65 && super.getPixel(x, y) <= 90) {
            return;
        }

        super.toUpper(x, y);
        totalOverdrawCount++;
        this.pixelHistory[x][y].add(this.listCount[x][y]++, super.getPixel(x, y));
    }

    @Override
    public void toLower(int x, int y) {
        if (super.getPixel(x, y) >= 97 && super.getPixel(x, y) <= 122) {
            return;
        }

        super.toLower(x, y);
        totalOverdrawCount++;
        this.pixelHistory[x][y].add(this.listCount[x][y]++, super.getPixel(x, y));
    }

    @Override
    public void fillHorizontalLine(int y, char ch) {
        super.fillHorizontalLine(y, ch);
        for (int i = 0; i < super.getWidth(); i++) {
            if (super.getPixel(i, y) == ch) {
                continue;
            }
            this.pixelHistory[i][y].add(this.listCount[i][y]++, super.getPixel(i, y));
            totalOverdrawCount++;
        }
    }

    @Override
    public void fillVerticalLine(int x, char ch) {
        super.fillVerticalLine(x, ch);
        for (int i = 0; i < super.getHeight(); i++) {
            if (super.getPixel(x, i) == ch) {
                continue;
            }
            this.pixelHistory[x][i].add(this.listCount[x][i]++, super.getPixel(x, i));
            totalOverdrawCount++;
        }
    }

    @Override
    public void clear() {
        totalOverdrawCount += (super.getHeight() * super.getWidth());
        super.clear();
    }
}
