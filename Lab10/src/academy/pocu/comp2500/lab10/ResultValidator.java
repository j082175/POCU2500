package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

public class ResultValidator {
    private ResultBase resultBase;

    public ResultValidator(ResultBase resultBase) {
        this.resultBase = resultBase;
    }

    public boolean isValid(ResultCode resultCode) {


        if (this.resultBase.getCode() == resultCode) {
            switch (this.resultBase.getCode()) {
                case OK:
                    if (this.resultBase instanceof OkResult) {
                        return true;
                    }
                    break;

                case NOT_FOUND:
                    if (this.resultBase instanceof NotFoundResult) {
                        return true;
                    }
                    break;
                case NOT_MODIFIED:
                    if (this.resultBase instanceof CachedResult) {
                        return true;
                    }
                    break;
                case SERVICE_UNAVAILABLE:
                    if (this.resultBase instanceof ServiceUnavailableResult) {
                        return true;
                    }
                    break;
                case UNAUTHORIZED:
                    if (this.resultBase instanceof UnauthorizedResult) {
                        return true;
                    }
                    break;
                default:
                    break;
            }
        }

        return false;
    }
}
