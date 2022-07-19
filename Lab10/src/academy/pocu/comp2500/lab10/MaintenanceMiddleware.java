package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.time.OffsetDateTime;

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
        if (this.iRequestHandler != null) {
            return new ServiceUnavailableResult(offsetDateTime, offsetDateTime);
        }

        // 다음 핸들러에 요청을 넘김
        return null;
    }
}
