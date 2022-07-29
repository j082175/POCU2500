package academy.pocu.comp2500.assignment4;

public class ToUpperCommand implements ICommand {
    private int x;
    private int y;
    private Canvas currentCanvas;
    private Canvas reverseCanvas;
    private Canvas backupCurrentCanvas;
    private Character originPixelList[][];
    private boolean isExecuted = false;
    private boolean isSame = false;

    public ToUpperCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean execute(Canvas canvas) {
        if (this.x >= 0 && this.y >= 0 && this.x < canvas.getWidth() && this.y < canvas.getHeight()) {
            if (isExecuted) {
                return false;
            }
            isExecuted = true;

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
            this.currentCanvas.toUpper(this.x, this.y);

            for (int i = 0; i < canvas.getHeight(); i++) {
                for (int j = 0; j < canvas.getWidth(); j++) {
                    this.backupCurrentCanvas.drawPixel(i, j, this.currentCanvas.getPixel(i, j));
                }
            }

            boolean c = false;
            // 기존 canvas 랑 새로운 거랑 똑같은지
            for (int i = 0; i < canvas.getHeight(); i++) {
                for (int j = 0; j < canvas.getWidth(); j++) {
                    if (this.originPixelList[i][j] == this.currentCanvas.getPixel(i, j)) {
                        continue;
                    } else {
                        isSame = false;
                        c = true;
                        break;
                    }
                }
                if (c) {
                    break;
                } else {
                    isSame = true;
                }
            }

            return true;
        }

        return false;
    }
    @Override
    public boolean undo() {
        if (isExecuted) {

            if (isSame) {
                return true;
            }

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

            if (isSame) {
                return false;
            }

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