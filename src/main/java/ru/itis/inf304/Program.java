package ru.itis.inf304;

public class Program {
    private String channel;
    private BroadcastsTime time;
    private String name;

    public Program(String channel, BroadcastsTime time, String name) {
        this.channel = channel;
        this.time = time;
        this.name = name;
    }
    public String getChannel() {
        return channel;
    }

    public BroadcastsTime getTime() {
        return time;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Program{" +
                "channel='" + channel + '\'' +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}