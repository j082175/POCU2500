package academy.pocu.comp2500.assignment4;

public class ClearCommand implements ICommand {
    private Canvas currentCanvas;
    //private Canvas reverseCanvas;
    private Canvas backupCurrentCanvas;
    //private Character originPixelList[][];
    private boolean isExecuted = false;

    public ClearCommand() {

    }

    @Override
    public boolean execute(Canvas canvas) {
        if (isExecuted) {
            return false;
        }
        isExecuted = true;

        // 기존 canvas 상태 저장
        //this.originPixelList = new Character[canvas.getHeight()][canvas.getWidth()];
        //this.reverseCanvas = new Canvas(canvas.getWidth(), canvas.getHeight());
        this.backupCurrentCanvas = new Canvas(canvas.getWidth(), canvas.getHeight());

/*        for (int i = 0; i < canvas.getHeight(); i++) {
            for (int j = 0; j < canvas.getWidth(); j++) {
                this.originPixelList[i][j] = canvas.getPixel(i, j);
            }
        }*/

/*        for (int i = 0; i < canvas.getHeight(); i++) {
            for (int j = 0; j < canvas.getWidth(); j++) {
                this.reverseCanvas.drawPixel(i, j, this.originPixelList[i][j]);
            }
        }*/

        //canvas 변경
        this.currentCanvas = canvas;
        this.currentCanvas.clear();

        for (int i = 0; i < canvas.getHeight(); i++) {
            for (int j = 0; j < canvas.getWidth(); j++) {
                this.backupCurrentCanvas.drawPixel(i, j, this.currentCanvas.getPixel(i, j));
            }
        }

        return true;


    }

    @Override
    public boolean undo() {
        if (isExecuted) {

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

            /*for (int i = 0; i < currentCanvas.getHeight(); i++) {
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
            }*/

            return false;
        }
        return false;
    }

    @Override
    public boolean redo() {
        if (isExecuted) {

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

            /*for (int i = 0; i < currentCanvas.getHeight(); i++) {
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
            }*/

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
