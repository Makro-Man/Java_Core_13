package ua.lviv.lgs.VerkhovnaRada;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Faction {
    public String getNameFaction() {
        return nameFaction;
    }

    public void setNameFaction(String nameFaction) {
        this.nameFaction = nameFaction;
    }

    private String nameFaction;

    @Override
    public String toString() {
        return "Faction{" +
                "nameFaction='" + nameFaction + '\'' +
                '}';
    }

    public Faction(String nameFaction) {
        this.nameFaction = nameFaction;
    }

List<Deputy> faction = new ArrayList<Deputy>();
    public void addDeputy(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter firstName:");
        String firstName = scanner.next();
        System.out.println("Enter lastname:");
        String lastname = scanner.next();
        System.out.println("Enter age:");
        int age = scanner.nextInt();
        System.out.println("Enter weight: ");
        double weight = scanner.nextDouble();
        System.out.println("Enter height: ");
        double height = scanner.nextDouble();
        System.out.println("Is Grafter? ");
        boolean isGrafter = scanner.nextBoolean();
        Deputy deputy=new Deputy(weight,height,lastname,firstName,age,isGrafter);
        if (deputy.isGrafter()){
            deputy.getBribe();
        }
        faction.add(deputy);
        System.out.println("Депутат " + deputy.toString() + " успішно добавлено до фракції!");

    }
    public void deleteDeputy(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фамилию депутата:");
        String surname = scanner.next();
        System.out.println("Введите имя депутата:");
        String name = scanner.next();
        boolean Correct = isDeputyExists(faction, surname, name);
        if (Correct){
            Iterator<Deputy> iterator = faction.iterator();
            while (iterator.hasNext()){
                Deputy deputySecond = iterator.next();
                if (deputySecond.getLastName().equalsIgnoreCase(surname) && deputySecond.getFirstName().equalsIgnoreCase(name)) {
                    iterator.remove();
                    System.out.println("Депутат " + deputySecond.toString() + " успішно видалений із фракції!");
                }else {
                    System.out.println("Такого депутата немає");
                }
            }
        }
    }
    public void getBribeDeputy(){
        for (Deputy deputy:faction){
            if (deputy.isGrafter()){
                System.out.println("Депутат який бере взятки"+ deputy.toString());
            }
        }

    }
    public void getMaxBribeDeputy(){
        int max = 0;
        int index=-1;
        for (int i = 0; i<faction.size(); i++){
            if (faction.get(i).isGrafter()){
                if (faction.get(i).getSizeBribe()>max){
                    max=faction.get(i).getSizeBribe();
                    index= faction.indexOf(faction.get(i));
                }
            }
        }
        if (index >= 0) {
            System.out.println("Найбільший хабарник " + faction.get(index).toString());
        } else {
            System.out.println("Тут хабарників немає");
        }
    }
    public void getAllDeputies() {
        System.out.println("Депутати:");
        for (Deputy deputy : faction) {
            System.out.println(deputy.toString());
        }
    }
    public void deleteFactionDeputy(){
        faction.clear();
        System.out.println("Депутати були видалені");
    }

    static boolean isDeputyExists(List<Deputy> faction, String surname, String name) {
        boolean flag = false;

        for (Deputy deputy : faction) {
            if (deputy.getLastName().equalsIgnoreCase(surname) && deputy.getFirstName().equalsIgnoreCase(name)) {
                flag = true;
            }
        }

        return flag;
    }
}
