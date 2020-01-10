package dev.danennis.ontrack.model;

import lombok.Data;

@Data
public class Departure {
    String arrivalCrs;
    boolean isCancelled;
    String estimatedDepartureTime;
    String arrivalName;
    String platform;
    String scheduledDepartureTime;

    public Departure(String arrivalCrs, boolean isCancelled, String estimatedDepartureTime, String arrivalName, String platform, String scheduledDepartureTime) {
        this.arrivalCrs = arrivalCrs;
        this.isCancelled = isCancelled;
        this.estimatedDepartureTime = estimatedDepartureTime;
        this.arrivalName = arrivalName;
        this.platform = platform;
        this.scheduledDepartureTime = scheduledDepartureTime;
    }

    public Departure() {
    }

    public String getArrivalCrs() {
        return arrivalCrs;
    }

    public void setArrivalCrs(String arrivalCrs) {
        this.arrivalCrs = arrivalCrs;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public String getEstimatedDepartureTime() {
        return estimatedDepartureTime;
    }

    public void setEstimatedDepartureTime(String estimatedDepartureTime) {
        this.estimatedDepartureTime = estimatedDepartureTime;
    }

    public String getArrivalName() {
        return arrivalName;
    }

    public void setArrivalName(String arrivalName) {
        this.arrivalName = arrivalName;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getScheduledDepartureTime() {
        return scheduledDepartureTime;
    }

    public void setScheduledDepartureTime(String scheduledDepartureTime) {
        this.scheduledDepartureTime = scheduledDepartureTime;
    }
}
