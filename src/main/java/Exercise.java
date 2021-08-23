import java.util.Date;
import java.util.Scanner;

/* Nhập vào int ngày, int tháng, int năm, int giờ, int phút, int giây
phát sinh ra timestamp
*/

public class Exercise {
    public static void main(String[] main) {
        Scanner input = new Scanner(System.in);

        System.out.print("Ngày: ");
        int day = input.nextInt();

        System.out.print("Tháng: ");
        int month = input.nextInt();

        System.out.print("Năm: ");
        int year = input.nextInt();

        System.out.print("Giờ: ");
        int hour = input.nextInt();

        System.out.print("Phút: ");
        int min = input.nextInt();

        System.out.print("Giây: ");
        int sec = input.nextInt();

        System.out.println("Dữ liệu đầu vào");
        System.out.format("%d/%d/%d %d:%d:%d\n", day, month, year, hour, min, sec);

        long dateTranfSec = yearCheck(year) + monthCheck(month, year) + dayCheck(day) + hourCheck(hour) + minCheck(min) + sec;
        //System.out.println(dateTranfSec);
    }

    public static long yearCheck(int year) {
        long yearToSec;
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            yearToSec = (year - 1970) * 366 * 24 * 60 * 60;
        } else {
            yearToSec = (year - 1970) * 365 * 24 * 60 * 60;
        }
        return yearToSec;
    }

    public static long monthCheck(int month, int year) {
        long monthToSec = 0;
        for (int i = 1; i < month; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                monthToSec += 31 * 24 * 60 * 60;
            }
            if (i == 2) {
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    monthToSec += 29 * 24 * 60 * 60;
                } else {
                    monthToSec += 28 * 24 * 60 * 60;
                }
            }
            if (i == 4 || i == 6 || i == 9 || i == 11) {
                monthToSec += 30 * 24 * 60 * 60;
            }
        }
        return monthToSec;
    }

    public static long dayCheck(int day) {
        long dayToSec = (day - 1) * 24 * 60 * 60;
        return dayToSec;
    }

    public static long hourCheck(int hour) {
        long hourToSec = hour * 60 * 60;
        return hourToSec;
    }

    public static long minCheck(int min) {
        long minToSec = min * 60;
        return minToSec;
    }
}
