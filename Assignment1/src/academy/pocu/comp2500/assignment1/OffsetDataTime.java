package academy.pocu.comp2500.assignment1;

import java.time.LocalDateTime;

public class OffsetDataTime {
    private LocalDateTime data;

    public OffsetDataTime(LocalDateTime data) {
        this.data = data;
    }

    public LocalDateTime getData() {
        return this.data;
    }
}
