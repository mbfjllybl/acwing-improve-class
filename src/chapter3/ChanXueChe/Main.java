package chapter3.ChanXueChe;

import java.util.Scanner;

/**
 * @author mbfjllybl
 * @version 1.0
 * @description: TODO
 * @date 2021/12/6 上午11:04
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1, y1, x2, y2;
        x1 = scanner.nextDouble();
        y1 = scanner.nextDouble();
        double sum = 0;
        while (scanner.hasNext()) {
            x1 = scanner.nextDouble();
            y1 = scanner.nextDouble();
            x2 = scanner.nextDouble();
            y2 = scanner.nextDouble();
            sum += Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) * 2;
        }
        int mins = (int)Math.round(sum / 1000 / 20 * 60);
        int hours = mins / 60;
        mins %= 60;
        System.out.println(String.format("%d:%02d", hours, mins));
        scanner.close();
    }
}
