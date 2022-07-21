package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class MaintenanceMiddleware implements IRequestHandler {
    //점검시간은 1시간

    private IRequestHandler iRequestHandler;
    private OffsetDateTime startDateTime;

    public MaintenanceMiddleware(IRequestHandler iRequestHandler, OffsetDateTime startDateTime) {
        this.iRequestHandler = iRequestHandler;
        this.startDateTime = startDateTime;
    }

    @Override
    public ResultBase handle(Request request) {
        // 점검중일때
        OffsetDateTime currentDateTime = OffsetDateTime.now(ZoneOffset.UTC);

        if (this.startDateTime.isAfter(currentDateTime)) {
            return this.iRequestHandler.handle(request);
        }

        if (this.startDateTime.isAfter(currentDateTime.minusHours(1))) {
            return new ServiceUnavailableResult(startDateTime, startDateTime.plusHours(1));
        }

        // 다음 핸들러에 요청을 넘김
        return this.iRequestHandler.handle(request);
    }
}
