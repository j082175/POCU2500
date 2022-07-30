package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;
import java.util.LinkedList;

public class OverdrawAnalyzer extends Canvas {
    private ArrayList<LinkedList<Character>> pixelHistory = new ArrayList<>();
    private int index[][];
    private int totalOverdrawCount = 0;
    private int width;
    private int height;

    public OverdrawAnalyzer(int width, int height) {
        super(width, height);
        this.width = width;
        this.height = height;

        for (int i = 0; i < width * height; i++) {
            this.pixelHistory.add(new LinkedList<>());
        }

        this.index = new int[width][height];
    }

    public LinkedList<Character> getPixelHistory(int x, int y) {
        return this.pixelHistory.get(dimensionConvert(x, y, this.width));
    }

    public int getOverdrawCount(int x, int y) {
        return this.pixelHistory.get(dimensionConvert(x, y, this.width)).size();
    }

    public int getOverdrawCount() {
        int total = 0;
        for (int i = 0; i < width * height; i++) {
            total += this.pixelHistory.get(i).size();
        }
        return total;
    }

    @Override
    public void drawPixel(int x, int y, char ch) {
        if (super.getPixel(x, y) != ch) {
            super.drawPixel(x, y, ch);
            totalOverdrawCount++;
            this.pixelHistory.get(dimensionConvert(x, y, this.width)).add(ch);
        }
    }

    @Override
    public boolean increasePixel(int x, int y) {
        boolean result = super.increasePixel(x, y);
        if (result) {
            totalOverdrawCount++;
            this.pixelHistory.get(dimensionConvert(x, y, this.width)).add(super.getPixel(x, y));
        }
        return result;
    }

    @Override
    public boolean decreasePixel(int x, int y) {
        boolean result = super.decreasePixel(x, y);
        if (result) {
            totalOverdrawCount++;
            this.pixelHistory.get(dimensionConvert(x, y, this.width)).add(super.getPixel(x, y));
        }
        return result;
    }

    @Override
    public void toUpper(int x, int y) {
        if (super.getPixel(x, y) >= 97 && super.getPixel(x, y) <= 122) {
            super.toUpper(x, y);
            totalOverdrawCount++;
            this.pixelHistory.get(dimensionConvert(x, y, this.width)).add(super.getPixel(x, y));
        }
    }

    @Override
    public void toLower(int x, int y) {
        if (super.getPixel(x, y) >= 65 && super.getPixel(x, y) <= 90) {
            super.toLower(x, y);
            totalOverdrawCount++;
            this.pixelHistory.get(dimensionConvert(x, y, this.width)).add(super.getPixel(x, y));
        }
    }

    @Override
    public void fillHorizontalLine(int y, char ch) {
        super.fillHorizontalLine(y, ch);
        for (int i = 0; i < super.getWidth(); i++) {
            this.pixelHistory.get(dimensionConvert(i, y, this.width)).add(super.getPixel(i, y));
            totalOverdrawCount++;
        }
    }

    @Override
    public void fillVerticalLine(int x, char ch) {
        super.fillVerticalLine(x, ch);
        for (int i = 0; i < super.getHeight(); i++) {
            this.pixelHistory.get(dimensionConvert(x, i, this.width)).add(super.getPixel(x, i));
            totalOverdrawCount++;
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (super.getPixel(i, j) != ' ') {
                    totalOverdrawCount++;
                    super.drawPixel(i, j, ' ');
                    this.pixelHistory.get(dimensionConvert(i, j, this.width)).add(super.getPixel(i, j));
                }
            }
        }
    }

    private int dimensionConvert(int x, int y, int width) {
        return (width * x) + y;
    }
}