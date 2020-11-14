package ua.lviv.lgs.VerkhovnaRada;

import java.util.Scanner;

public class Main {
    static void menu() {
        System.out.println();
        System.out.println("Введіть 1 щоб додати фракцію");
        System.out.println("Введіть 2 щоб видалити конкретну фракцію");
        System.out.println("Введіть 3 щоб вивести усі  фракції");
        System.out.println("Введіть 4 щоб очистити конкретну фракцію");
        System.out.println("Введіть 5 щоб вивести конкретну фракцію");
        System.out.println("Введіть 6 щоб додати депутата в фракцію");
        System.out.println("Введіть 7 щоб видалити депутата з фракції");
        System.out.println("Введіть 8 щоб вивести список хабарників");
        System.out.println("Введіть 9 щоб вивести найбільшого хабарника\n");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            menu();

            switch (scanner.nextInt()) {

                case 1: {
                    VerkhovnaRadda.getInstance().addFaction();
                    break;
                }

                case 2: {
                    VerkhovnaRadda.getInstance().deleteFaction();
                    break;
                }

                case 3: {
                    VerkhovnaRadda.getInstance().getAllFaction();
                    break;
                }

                case 4: {
                    VerkhovnaRadda.getInstance().clearFaction();
                    break;
                }

                case 5: {
                    VerkhovnaRadda.getInstance().getDeputyGroup();
                    break;
                }

                case 6: {
                    VerkhovnaRadda.getInstance().addDeputyToFaction();
                    break;
                }

                case 7: {
                    VerkhovnaRadda.getInstance().removeDeputyFromFaction();
                    break;
                }

                case 8: {
                    VerkhovnaRadda.getInstance().getBribeFromFaction();
                    break;
                }

                case 9: {
                    VerkhovnaRadda.getInstance().getLargestBribeFromFaction();
                    break;
                }

                default: {
                    System.out.println("Введите число от 1 до 9!");
                    break;
                }
            }
        }
    }
}
