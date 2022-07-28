package academy.pocu.comp2500.assignment4;

public class DrawPixelCommand implements ICommand {
    private int x;
    private int y;
    private char character;
    private Canvas currentCanvas;
    private Canvas reverseCanvas;
    private Canvas backupCurrentCanvas;

    //private ArrayList<Canvas> canvasArrayList = new ArrayList<>();
    private int index = 0;
    private boolean isExecuted = false;
    private Character originPixelList[][];
/*    public Canvas getCanvas() {
        return this.canvas;
    }*/

    public DrawPixelCommand(int x, int y, char character) {
        this.x = x;
        this.y = y;
        this.character = character;
    }
    @Override
    public boolean execute(Canvas canvas) {
        if (this.x >= 0 && this.y >= 0 && this.x < canvas.getWidth() && this.y < canvas.getHeight()) {
            if (isExecuted) {
                return false;
            }
            isExecuted = true;
/*            this.canvas = canvas;
            this.canvasArrayList.add(this.canvas);
            this.canvas.drawPixel(this.x, this.y, this.character);
            this.canvasArrayList.add(this.canvas);
            this.index++;*/

            // 기존 canvas 상태 저장
            this.originPixelList = new Character[canvas.getHeight()][canvas.getWidth()];
            this.reverseCanvas = new Canvas(canvas.getWidth(), canvas.getHeight());
            this.backupCurrentCanvas = new Canvas(canvas.getWidth(), canvas.getHeight());

            for (int i = 0; i < canvas.getHeight(); i++) {
                for (int j = 0; j < canvas.getWidth(); j++) {
                    this.originPixelList[i][j] = canvas.getPixel(i, j);
                }
            }

            for (int i = 0; i < canvas.getHeight(); i++) {
                for (int j = 0; j < canvas.getWidth(); j++) {
                    this.reverseCanvas.drawPixel(i, j, this.originPixelList[i][j]);
                }
            }

            //canvas 변경
            this.currentCanvas = canvas;
            this.currentCanvas.drawPixel(this.x, this.y, this.character);

            for (int i = 0; i < canvas.getHeight(); i++) {
                for (int j = 0; j < canvas.getWidth(); j++) {
                    this.backupCurrentCanvas.drawPixel(i, j, this.currentCanvas.getPixel(i, j));
                }
            }
/*            char a = this.currentCanvas.getPixel(1, 2);
            char b = this.backupCurrentCanvas.getPixel(1, 2);*/

            return true;
        }

        return false;
    }
    @Override
    public boolean undo() {
        if (isExecuted) {
/*            if (this.index > 0) {
                this.index--;
                this.canvas = this.canvasArrayList.get(this.index);
                return true;
            }*/

            //check
/*            char e = this.currentCanvas.getPixel(1, 2);
            char f = this.backupCurrentCanvas.getPixel(1, 2);

            char a = this.currentCanvas.getPixel(0, 0);
            char b = this.backupCurrentCanvas.getPixel(0, 0);
            char c = this.originPixelList[0][0];
            char d = this.reverseCanvas.getPixel(0,0);*/
            for (int i = 0; i < this.currentCanvas.getHeight(); i++) {
                for (int j = 0; j < this.currentCanvas.getWidth(); j++) {
                    if (this.currentCanvas.getPixel(i, j) == this.backupCurrentCanvas.getPixel(i, j)) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
            //

            for (int i = 0; i < currentCanvas.getHeight(); i++) {
                for (int j = 0; j < currentCanvas.getWidth(); j++) {
                    if (this.currentCanvas.getPixel(i, j) == this.originPixelList[i][j]) {
                        continue;
                    } else {
                        for (int m = 0; m < currentCanvas.getHeight(); m++) {
                            for (int n = 0; n < currentCanvas.getWidth(); n++) {
                                this.reverseCanvas.drawPixel(m, n, this.currentCanvas.getPixel(m, n));
                                this.currentCanvas.drawPixel(m, n, this.originPixelList[m][n]);
                            }
                        }


                        //backup
                        for (int m = 0; m < currentCanvas.getHeight(); m++) {
                            for (int n = 0; n < currentCanvas.getWidth(); n++) {
                                this.backupCurrentCanvas.drawPixel(m, n, this.currentCanvas.getPixel(m, n));
                            }
                        }

                        return true;
                    }
                }
            }

            return false;
        }
        return false;
    }

    @Override
    public boolean redo() {
        if (isExecuted) {
/*            if (this.index == 0 && this.canvasArrayList.size() != 0) {
                this.index++;
                this.canvas = this.canvasArrayList.get(this.index);
                return true;
            }*/
            //check
            for (int i = 0; i < this.currentCanvas.getHeight(); i++) {
                for (int j = 0; j < this.currentCanvas.getWidth(); j++) {
                    if (this.currentCanvas.getPixel(i, j) == this.backupCurrentCanvas.getPixel(i, j)) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
            //

            for (int i = 0; i < currentCanvas.getHeight(); i++) {
                for (int j = 0; j < currentCanvas.getWidth(); j++) {
                    if (this.currentCanvas.getPixel(i, j) == this.originPixelList[i][j]) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }

            for (int m = 0; m < currentCanvas.getHeight(); m++) {
                for (int n = 0; n < currentCanvas.getWidth(); n++) {
                    this.currentCanvas.drawPixel(m, n, this.reverseCanvas.getPixel(m, n));
                    this.reverseCanvas.drawPixel(m, n, this.originPixelList[m][n]);
                }
            }

            //backup
            for (int m = 0; m < currentCanvas.getHeight(); m++) {
                for (int n = 0; n < currentCanvas.getWidth(); n++) {
                    this.backupCurrentCanvas.drawPixel(m, n, this.currentCanvas.getPixel(m, n));
                }
            }

            return true;
        }
        return false;
    }
}
