package ClassAndObject.BaiTap;

import java.time.LocalTime;

class StopWatch02 {
    private LocalTime startTime, endTime;

    public StopWatch02() {
        startTime = LocalTime.now();
    }

    public StopWatch02(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void start() {
        startTime = LocalTime.now();
    }

    public void stop() {
        endTime = LocalTime.now();
    }

    public int getElapsedTime() {
        int miliSecond = ((endTime.getHour() - startTime.getHour()) * 3600 + (endTime.getMinute() - startTime.getMinute()) * 60 + (endTime.getSecond() - startTime.getSecond()) * 1000);
        return miliSecond;
    }
}


class OOPStopWatch {
    public static int[] selectionSort(int... a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    int tempt = a[i];
                    a[i] = a[j];
                    a[j] = tempt;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] num = new int[100000];
        for (int i = 0; i < 100000; i++) {
            num[i] = (int) (Math.random() * 1000);
        }
        LocalTime start = LocalTime.now();
        num = selectionSort(num);
        LocalTime end = LocalTime.now();
        StopWatch02 sw = new StopWatch02(start, end);
        System.out.println("Thời gian sắp xếp xong mảng length = 100.000 là: " + sw.getElapsedTime()/1000+ " (seconds)");
    }
}
