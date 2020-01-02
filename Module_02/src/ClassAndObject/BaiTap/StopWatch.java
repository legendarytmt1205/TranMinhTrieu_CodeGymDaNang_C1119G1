package ClassAndObject.BaiTap;

import java.util.Date;

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


    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();

    }
}
