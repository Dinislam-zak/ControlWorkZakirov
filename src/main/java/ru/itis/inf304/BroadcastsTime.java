package ru.itis.inf304;

public class BroadcastsTime implements Comparable<BroadcastsTime> {
    private byte hour;
    private byte minutes;

    public BroadcastsTime(byte hour, byte minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    public BroadcastsTime(String s) {
    }


    public byte getHour() {
        return hour;
    }

    public byte getMinutes() {
        return minutes;
    }

    public boolean after(BroadcastsTime t) {
        if (this.hour > t.getHour()) {
            return true;
        } else if (this.hour == t.getHour() && this.minutes > t.getMinutes()) {
            return true;
        }
        return false;
    }

    public boolean before(BroadcastsTime t) {
        if (this.hour < t.getHour()) {
            return true;
        } else if (this.hour == t.getHour() && this.minutes < t.getMinutes()) {
            return true;
        }
        return false;
    }

    public boolean between(BroadcastsTime t1, BroadcastsTime t2) {
        if (this.after(t1) && this.before(t2)) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(BroadcastsTime t) {
        if (this.hour != t.getHour()) {
            return this.hour - t.getHour();
        } else {
            return this.minutes - t.getMinutes();
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minutes);
    }
}
