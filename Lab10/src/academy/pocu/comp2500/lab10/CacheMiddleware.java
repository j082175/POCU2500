package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

public class CacheMiddleware implements IRequestHandler{
    private IRequestHandler iRequestHandler;
    private int cacheExpiredRate;

    private boolean isValid;

    public CacheMiddleware(IRequestHandler iRequestHandler, int cacheExpiredRate) {
        this.iRequestHandler = iRequestHandler;
        this.cacheExpiredRate = cacheExpiredRate;
        this.isValid = false;
    }


    @Override
    public ResultBase handle(Request request) {

        ResultBase resultBase = this.iRequestHandler.handle(request);
        if (isValid)
        if (resultBase instanceof OkResult) {
            if (this.cacheExpiredRate != 0) {
                this.cacheExpiredRate--;
                return new CachedResult(this.cacheExpiredRate);
            }
        }

        isValid = true;
        return this.iRequestHandler.handle(request);

    }
}
