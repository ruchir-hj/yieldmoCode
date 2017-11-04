package com.yieldmo;

/**
 * Class representing a Segment(start,end)
 */
public class Segment {
    int startTime;
    int endTime;

    public Segment(int start, int end) {
        this.startTime = start;
        this.endTime = end;
    }

    @Override
    public String toString() {
        return "Segment{" + startTime +
                ", " + endTime +
                "}";
    }
}
