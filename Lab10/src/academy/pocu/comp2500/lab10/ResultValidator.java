package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

public class ResultValidator {
    ResultBase resultBase;

    public ResultValidator(ResultBase resultBase) {
        this.resultBase = resultBase;
    }

    public boolean isValid(ResultCode resultCode) {
        if (this.resultBase.getCode().getClass() == resultCode.getClass()) {
            return true;
        }

        return false;
    }
}
