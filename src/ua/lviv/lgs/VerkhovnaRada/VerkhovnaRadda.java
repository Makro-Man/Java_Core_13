package ua.lviv.lgs.VerkhovnaRada;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class VerkhovnaRadda {
    private static VerkhovnaRadda instance = new VerkhovnaRadda();
    private VerkhovnaRadda(){}
    public static VerkhovnaRadda getInstance() {
        if (instance == null) {
            instance = new VerkhovnaRadda();
        }

        return instance;
    }
    List<Faction> VerkhovnaRadaList = new ArrayList<Faction>();
    public void addFaction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of faction: ");
        String faction = scanner.next();

        Faction faction1 = new Faction(faction);

        VerkhovnaRadaList.add(faction1);
        System.out.println(faction1.toString() + " добавлено");
    }
    public void deleteFaction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of factiom:");
        String faction = scanner.next();

        boolean Correct = isFactionExists(VerkhovnaRadaList, faction);

        if (Correct) {

            Iterator<Faction> iterator = VerkhovnaRadaList.iterator();

            while (iterator.hasNext()) {
                Faction nextDeputyGroup = iterator.next();

                if (nextDeputyGroup.getNameFaction().equalsIgnoreCase(faction)) {
                    iterator.remove();
                    System.out.println(nextDeputyGroup.toString() + " видалено");
                }
            }

        } else {
            System.out.println("Фракцію у ВР немає");
        }
    }
    public void getAllFaction() {
        System.out.println("Фракції у ВР: ");
        for (Faction deputyGroup : VerkhovnaRadaList) {
            System.out.println(deputyGroup.toString());
        }
    }

    public void clearFaction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of faction:");
        String faction = scanner.next();

        boolean Correct = isFactionExists(VerkhovnaRadaList, faction);

        if (Correct) {
            for (Faction faction1 : VerkhovnaRadaList) {
                if (faction1.getNameFaction().equalsIgnoreCase(faction)) {
                    faction1.deleteFactionDeputy();
                }
            }

        } else {
            System.out.println("Немає");
        }
    }

    public void getDeputyGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of factiom:");
        String faction1 = scanner.next();

        for (Faction faction : VerkhovnaRadaList) {
            if (faction.getNameFaction().equalsIgnoreCase(faction1)) {
                System.out.println(faction.toString());
                faction.getAllDeputies();
            }
        }
    }

    public void addDeputyToFaction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of faction:");
        String faction = scanner.next();

        boolean Correct = isFactionExists(VerkhovnaRadaList, faction);

        if (Correct) {
            for (Faction faction1 : VerkhovnaRadaList) {
                if (faction1.getNameFaction().equalsIgnoreCase(faction)) {
                    faction1.addDeputy();
                }
            }

        } else {
            System.out.println("Немає");
        }
    }

    public void removeDeputyFromFaction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of faction:");
        String faction = scanner.next();

        boolean Correct = isFactionExists(VerkhovnaRadaList, faction);

        if (Correct) {
            for (Faction faction1 : VerkhovnaRadaList) {
                if (faction1.getNameFaction().equalsIgnoreCase(faction)) {
                    faction1.deleteDeputy();
                }
            }

        } else {
            System.out.println("Немає");
        }
    }

    public void getBribeFromFaction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of faction:");
        String faction = scanner.next();

        boolean Correct = isFactionExists(VerkhovnaRadaList, faction);

        if (Correct) {
            for (Faction faction1 : VerkhovnaRadaList) {
                if (faction1.getNameFaction().equalsIgnoreCase(faction)) {
                    faction1.getBribeDeputy();
                }
            }

        } else {
            System.out.println("Немає");
        }
    }

    public void getLargestBribeFromFaction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of faction:");
        String faction = scanner.next();

        boolean Correct = isFactionExists(VerkhovnaRadaList, faction);

        if (Correct) {
            for (Faction faction1 : VerkhovnaRadaList) {
                if (faction1.getNameFaction().equalsIgnoreCase(faction)) {
                    faction1.getMaxBribeDeputy();
                }
            }

        } else {
            System.out.println("Немає");
        }
    }

    public void getAllDeputiesFromDeputyGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of faction:");
        String faction = scanner.next();

        boolean Correct = isFactionExists(VerkhovnaRadaList, faction);

        if (Correct) {
            for (Faction faction1 : VerkhovnaRadaList) {
                if (faction1.getNameFaction().equalsIgnoreCase(faction)) {
                    faction1.getAllDeputies();;
                }
            }

        } else {
            System.out.println("Немає");
        }
    }
    static boolean isFactionExists(List<Faction> VerkhovnaRadaList, String NameFaction) {
        boolean flag = false;

        for (Faction faction : VerkhovnaRadaList) {
            if (faction.getNameFaction().equalsIgnoreCase(NameFaction)) {
                flag = true;
            }
        }

        return flag;
    }

}
