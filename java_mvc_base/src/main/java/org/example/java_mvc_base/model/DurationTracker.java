package org.example.java_mvc_base.model;

import java.time.Duration;
import java.time.Instant;

public class DurationTracker {

    private Instant startTime;
    private Instant endTime;

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public Duration calculateDuration() {
        // Check if both start time and end time are set
        if (startTime != null && endTime != null) {
            return Duration.between(startTime, endTime);
        } else {
            // If either start time or end time is not set, return null or throw an exception
            // In this example, I'm returning null, but you might handle this differently based on your use case.
            return null;
        }
    }


}
