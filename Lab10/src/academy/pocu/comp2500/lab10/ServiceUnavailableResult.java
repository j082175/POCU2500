package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

import java.time.OffsetDateTime;

public class ServiceUnavailableResult extends ResultBase {
    //이 개체의 ResultCode는 SERVICE_UNAVAILABLE여야 합니다.
    private OffsetDateTime startDateTime;
    private OffsetDateTime endDateTime;

    public ServiceUnavailableResult(OffsetDateTime startDateTime, OffsetDateTime endDateTime) {
        super(ResultCode.SERVICE_UNAVAILABLE);
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public OffsetDateTime getStartDateTime() {
        return this.startDateTime;
    }

    public OffsetDateTime getEndDateTime() {
        return this.endDateTime;
    }
}
