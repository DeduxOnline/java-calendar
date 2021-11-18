import java.time.DayOfWeek;
import java.time.Month;
import java.time.LocalDate;
import java.util.Scanner;
public class calendar {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static void main (String[] avr) {
        System.out.println(YELLOW + "Calendar" + RESET);
        Scanner in = new Scanner(System.in);
        System.out.print("Input year: ");
        int year = in.nextInt();
        System.out.print("Input number of month: ");
        int month = in.nextInt();
        System.out.print("Input day: ");
        int find = in.nextInt();
        in.close();
        System.out.println();
        int[][] mat;
        mat = new int[6][8];
        int k;
        int d = 1;
        int j = 0;
        int monthN = Month.of(month).maxLength();
        LocalDate date = LocalDate.of(year, month, 1);
        DayOfWeek days = date.getDayOfWeek();
        k = switch (days) {
            case MONDAY -> 0;
            case TUESDAY -> 1;
            case WEDNESDAY -> 2;
            case THURSDAY -> 3;
            case FRIDAY -> 4;
            case SATURDAY -> 5;
            default -> 6;
        };
        while (monthN > d - 1) {
            if (k > 6) {
                j++;
                k = 0;
            }
            mat[j][k] = d;
            k++;
            d++;
        }
        System.out.println("\t  " + Month.of(month) + " " + year);
        System.out.println(GREEN + "Mo\tTu\tWe\tTh\tFr" + RED + "\tSa\tSu" + RESET);
        for (int[] ints : mat) {
            for (j = 0; j < ints.length; j++) {
                if (ints[j] == 0) {
                    System.out.print(" \t");
                } else {
                    if (find == ints[j]) {
                        System.out.printf(BLUE + "%d\t" + RESET, ints[j]);
                    } else {
                        System.out.printf("%d\t", ints[j]);
                    }
                }
            }
            System.out.println();
        }
    }

}

