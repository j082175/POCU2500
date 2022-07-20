package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;
import academy.pocu.comp2500.lab10.pocuflix.User;

import java.util.HashMap;
import java.util.HashSet;

public class CacheMiddleware implements IRequestHandler{
    private IRequestHandler iRequestHandler;
    private int cacheExpiredRate;

    private HashMap<String, User> requestHashSet;


    public CacheMiddleware(IRequestHandler iRequestHandler, int cacheExpiredRate) {
        this.iRequestHandler = iRequestHandler;
        this.cacheExpiredRate = cacheExpiredRate;
        this.requestHashSet = new HashMap<>();
    }


    @Override
    public ResultBase handle(Request request) {

        //ResultBase resultBase = this.iRequestHandler.handle(request);

        if (this.requestHashSet.containsKey(request.title)) {
            if (request.user != null) {
                if (request.user.equals(this.requestHashSet.get(request.title))) {
                    if (this.cacheExpiredRate != 1) {

                            this.cacheExpiredRate--;


                        return new CachedResult(this.cacheExpiredRate);
                    }
                }
            }

            else if (this.requestHashSet.get(request.title) != null) {
                if (this.requestHashSet.get(request.title).equals(request.user)) {
                    if (this.cacheExpiredRate != 1) {

                            this.cacheExpiredRate--;

                        return new CachedResult(this.cacheExpiredRate);
                    }
                }
            }
        }



/*        if (resultBase instanceof OkResult) {
            if (this.cacheExpiredRate != 0) {
                this.cacheExpiredRate--;
                return new CachedResult(this.cacheExpiredRate);
            }
        }*/


        this.requestHashSet.put(request.title, request.user);
        return this.iRequestHandler.handle(request);

    }
}
