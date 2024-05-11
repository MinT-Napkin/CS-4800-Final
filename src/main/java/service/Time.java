package service;

public class Time {
    public static int getTimeInHrs()
    {
        long time = System.currentTimeMillis();

        int timeInSeconds = (int) time*100;
        int timeInMins = timeInSeconds/60;
        int timeInHrs = timeInMins/60;

        return timeInHrs;
    }
}
