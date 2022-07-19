package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class MaintenanceMiddleware implements IRequestHandler{
    //점검시간은 1시간

    private IRequestHandler iRequestHandler;
    private OffsetDateTime offsetDateTime;

    public MaintenanceMiddleware(IRequestHandler iRequestHandler, OffsetDateTime offsetDateTime) {
        this.iRequestHandler = iRequestHandler;
        this.offsetDateTime = offsetDateTime;
    }

    @Override
    public ResultBase handle(Request request) {
        // 점검중일때
        OffsetDateTime currentDateTime = OffsetDateTime.now(ZoneOffset.UTC);



        if (this.offsetDateTime.isAfter(currentDateTime.minusHours(1))) {
            return new ServiceUnavailableResult(offsetDateTime, offsetDateTime.plusHours(1));
        }

        // 다음 핸들러에 요청을 넘김
        return this.iRequestHandler.handle(request);
    }
}
