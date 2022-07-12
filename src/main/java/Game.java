

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        String[][] target = new String[6][6];
        square(target);

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int axisY = random.nextInt(5) + 1;
        int axisX = random.nextInt(5) + 1;

        System.out.println("All set. Get ready to rumble!\n");

        while (true) {
            System.out.print("Enter first index: ");
            int enteredY = scanner.nextInt();
            if (enteredY > target.length - 1 || enteredY <= 0) {
                System.out.println("Entered index must be between 1-5 !");
                continue;
            }

            System.out.print("Enter second index: ");
            int enteredX = scanner.nextInt();
            if (enteredX > target.length - 1 || enteredX <= 0) {
                System.out.println("Entered index must be between 1-5 !");
                continue;
            }

            if (enteredY == axisY && enteredX == axisX) {
                target[axisY][axisX] = "X";
                arrays(target);
                System.out.println("You have won");
                break;
            } else {
                failedShot(target, enteredY, enteredX);
                arrays(target);
                System.out.println("Please, try again");
            }
        }
    }

    public static void square(String[][] target) {
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target.length; j++) {
                target[0][j] = String.valueOf(j);
                target[i][0] = String.valueOf(i);
                if (i != 0 && j != 0) {
                    target[i][j] = "-";
                }
                System.out.print(target[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public static void arrays(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " | ");
            }
            System.out.println();
        }
    }


    public static String[][] failedShot(String[][] arr, int firstIndex, int secondIndex) {
        arr[firstIndex][secondIndex] = "*";
        return arr;
    }
}