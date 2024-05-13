package service;

public class Time {
    private static Time instance;
    private int time;

    private Time()
    {
        this.time = 0;
    }

    public static Time getInstance()
    {
        if (instance == null)
        {
            instance = new Time();
        }

        return instance;
    }

    public int getTimeInHrs()
    {
        if(this.time == 24)
        {
            this.time = 0;
        }else{
            this.time += 1;
        }

        return this.time;
    }
}
