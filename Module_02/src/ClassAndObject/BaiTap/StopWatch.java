package ClassAndObject.BaiTap;

import ClassAndObject.ThucHanh.RandomValue;

import java.time.LocalTime;

 public class StopWatch {

    private Long startTime;
    private Long endTimer;

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    public Long getStartTime() {
        return startTime;
    }

    public Long getEndTimer() {
        return endTimer;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.endTimer = System.currentTimeMillis();
    }
     public double elapsedTime() {
         return (endTimer - startTime) / 1000.0;
     }

     public static void main(String[] args) {
         RandomValue randomValue = new RandomValue();;
     }
 }
