package com.retor.buslib.lib.model;

/**
 * Created by retor on 13.08.2015.
 */
public class Bus {
    private int GaragNumb;
    private String Marsh;
    private int Graph;
    private int Smena;
    private String TimeNav;
    private double Latitude;
    private double Longitude;
    private int Speed;
    private long Azimuth;

    public int getGaragNumb() {
        return GaragNumb;
    }

    public void setGaragNumb(final int garagNumb) {
        GaragNumb = garagNumb;
    }

    public String getMarsh() {
        return Marsh;
    }

    public void setMarsh(final String marsh) {
        Marsh = marsh;
    }

    public int getGraph() {
        return Graph;
    }

    public void setGraph(final int graph) {
        Graph = graph;
    }

    public int getSmena() {
        return Smena;
    }

    public void setSmena(final int smena) {
        Smena = smena;
    }

    public String getTimeNav() {
        return TimeNav;
    }

    public void setTimeNav(final String timeNav) {
        TimeNav = timeNav;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(final double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(final double longitude) {
        Longitude = longitude;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(final int speed) {
        Speed = speed;
    }

    public long getAzimuth() {
        return Azimuth;
    }

    public void setAzimuth(final long azimuth) {
        Azimuth = azimuth;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "GaragNumb=" + GaragNumb +
                ", Marsh='" + Marsh + '\'' +
                ", Graph=" + Graph +
                ", Smena=" + Smena +
                ", TimeNav='" + TimeNav + '\'' +
                ", Latitude=" + Latitude +
                ", Longitude=" + Longitude +
                ", Speed=" + Speed +
                ", Azimuth=" + Azimuth +
                '}';
    }
}
