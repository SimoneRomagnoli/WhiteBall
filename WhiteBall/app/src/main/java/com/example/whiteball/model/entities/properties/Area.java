package com.example.whiteball.model.entities.properties;

import android.graphics.Point;
import android.graphics.Region;

public class Area {

    private Region region;

    public Area(Point point, int radius) {
        this.region = new Region(point.x - radius, point.y - radius, point.x + radius, point.y + radius);
    }

    public Region getRegion() {
        return this.region;
    }

    public void setRegion(Point point, int radius) {
        this.region = new Region(point.x - radius, point.y - radius, point.x + radius, point.y + radius);
    }
}
