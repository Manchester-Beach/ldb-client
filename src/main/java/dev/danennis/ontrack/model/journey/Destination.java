package dev.danennis.ontrack.model.journey;

import lombok.Data;

@Data
public class Destination {
    public String crs;
    public String name;
    public String scheduled;
    public String estimated;

    public Destination() {
    }

    public Destination(String crs, String name, String scheduled, String estimated) {
        this.crs = crs;
        this.name = name;
        this.scheduled = scheduled;
        this.estimated = estimated;
    }

    public String getCrs() {
        return crs;
    }

    public void setCrs(String crs) {
        this.crs = crs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScheduled() {
        return scheduled;
    }

    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    public String getEstimated() {
        return estimated;
    }

    public void setEstimated(String estimated) {
        this.estimated = estimated;
    }
}
