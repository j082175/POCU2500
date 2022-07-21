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

    private HashMap<Integer, Integer> requestHashSet;


    public CacheMiddleware(IRequestHandler iRequestHandler, int cacheExpiredRate) {
        this.iRequestHandler = iRequestHandler;
        this.cacheExpiredRate = cacheExpiredRate;
        this.requestHashSet = new HashMap<>();
    }


    @Override
    public ResultBase handle(Request request) {

        //ResultBase resultBase = this.iRequestHandler.handle(request);

        if (this.requestHashSet.containsKey(request.hashCode())) {
            if (request.user != null) {

                //var a = request.user.getUsername();
                //var b = this.requestHashSet.get(request.title).getUsername();


                    if (this.requestHashSet.get(request.hashCode()) != 1) {

                        this.requestHashSet.put(request.hashCode(), this.requestHashSet.get(request.hashCode()) - 1);


                        return new CachedResult(this.requestHashSet.get(request.hashCode()));
                    }

            }

        }



/*        if (resultBase instanceof OkResult) {
            if (this.cacheExpiredRate != 0) {
                this.cacheExpiredRate--;
                return new CachedResult(this.cacheExpiredRate);
            }
        }*/


        this.requestHashSet.put(request.hashCode(), this.cacheExpiredRate);
        return this.iRequestHandler.handle(request);

    }
}