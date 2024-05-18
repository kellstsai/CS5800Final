package com.example;

import java.time.LocalTime;

public enum Shift {
    FIRST_SHIFT(LocalTime.of(8, 0), LocalTime.of(16, 0)),
    SECOND_SHIFT(LocalTime.of(16, 0), LocalTime.of(0, 0)),
    THIRD_SHIFT(LocalTime.of(0, 0), LocalTime.of(8, 0));

    public LocalTime start;
    public LocalTime end;

    Shift(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }
}
