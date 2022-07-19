package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

public class CacheMiddleware implements IRequestHandler{
    private IRequestHandler iRequestHandler;
    private int cacheExpiredRate;

    public CacheMiddleware(IRequestHandler iRequestHandler, int cacheExpiredRate) {
        this.iRequestHandler = iRequestHandler;
        this.cacheExpiredRate = cacheExpiredRate;
    }


    @Override
    public ResultBase handle(Request request) {
        return null;
    }
}
