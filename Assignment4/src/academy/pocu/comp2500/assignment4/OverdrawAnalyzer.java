package academy.pocu.comp2500.assignment4;

import java.util.LinkedList;

public class OverdrawAnalyzer extends Canvas {
    private LinkedList<Character> pixelHistory = new LinkedList<>();
    private int listCount = 0;
    private LinkedList<Character> pixels[][];
    private int totalOverdrawCount = 0;

    public OverdrawAnalyzer(int width, int height) {
        super(width, height);
        this.pixels = new LinkedList[width][height];
    }

    public LinkedList<Character> getPixelHistory(int x, int y) {
        return this.pixels[x][y];
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
            this.pixelHistory.add(this.listCount++, super.getPixel(x, y));
        }
    }

    @Override
    public boolean increasePixel(int x, int y) {
        if (super.getPixel(x, y) == 126) {
            return false;
        }

        boolean result = super.increasePixel(x, y);
        totalOverdrawCount++;
        this.pixelHistory.add(this.listCount++, super.getPixel(x, y));
        return result;
    }

    @Override
    public boolean decreasePixel(int x, int y) {
        if (super.getPixel(x, y) == 32) {
            return false;
        }

        boolean result = super.decreasePixel(x, y);
        totalOverdrawCount++;
        this.pixelHistory.add(this.listCount++, super.getPixel(x, y));
        return result;
    }

    @Override
    public void toUpper(int x, int y) {
        if (super.getPixel(x, y) >= 65 && super.getPixel(x, y) <= 90) {
            return;
        }

        super.toUpper(x, y);
        totalOverdrawCount++;
        this.pixelHistory.add(this.listCount++, super.getPixel(x, y));
    }

    @Override
    public void toLower(int x, int y) {
        if (super.getPixel(x, y) >= 97 && super.getPixel(x, y) <= 122) {
            return;
        }

        super.toLower(x, y);
        totalOverdrawCount++;
        this.pixelHistory.add(this.listCount++, super.getPixel(x, y));
    }

    @Override
    public void fillHorizontalLine(int y, char ch) {
        super.fillHorizontalLine(y, ch);
        for (int i = 0; i < super.getWidth(); i++) {
            if (super.getPixel(i, y) == ch) {
                continue;
            }
            this.pixelHistory.add(this.listCount++, super.getPixel(i, y));
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
            this.pixelHistory.add(this.listCount++, super.getPixel(x, i));
            totalOverdrawCount++;
        }
    }

    @Override
    public void clear() {
        totalOverdrawCount += (super.getHeight() * super.getWidth());
        super.clear();
    }
}