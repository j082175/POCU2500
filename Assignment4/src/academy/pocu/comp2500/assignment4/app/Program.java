package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.Canvas;

public class Program {

    public static void main(String[] args) {
        Canvas canvas = new Canvas(10, 5);

        canvas.drawPixel(0, 0, '*');
        canvas.drawPixel(1, 2, '$');
        canvas.drawPixel(0, 1, '&');

        canvas.drawPixel(9, 4, '&');

        System.out.println(canvas.getDrawing());

        canvas.clear();

        System.out.println(canvas.getDrawing());

        canvas.fillHorizontalLine(3, '?');

        System.out.println(canvas.getDrawing());

        canvas.fillVerticalLine(3, 'a');

        System.out.println(canvas.getDrawing());
        canvas.increasePixel(3, 0);
        System.out.println(canvas.getDrawing());
        canvas.toUpper(4, 0);
        System.out.println(canvas.getDrawing());

    }
}
