package com.weatherservice;

import java.util.Date;

/**
 * Class for representing weather warning
 */
public class Warning {
    private String text;
    private Date time;
    private EventThreshold threshold;

    public Warning(String text, Date time, EventThreshold threshold) {
        this.text = text;
        this.time = time;
        this.threshold = threshold;
    }

    public String getDetails() {
        return "Warning: " + text + ", time: " + time + ", threshold: " + threshold.getLevel();
    }

    public Date getTime() {
        return time;
    }

    public EventThreshold getThreshold() {
        return threshold;
    }
}