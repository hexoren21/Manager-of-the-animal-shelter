import animals.Animal;
import shelters.AnimalShelter;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        AnimalShelter animalShelter = new AnimalShelter();
        SingletonApi singletonApi = SingletonApi.getInstance(animalShelter);
        String move;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 -> add\n2 -> delete\n3 -> end project\nstatus -> show actual animal shelter");
            move = scanner.nextLine();
            if (move.equals("1")) {
                Animal animal;
                String name;
                int age;
                System.out.println("give the name of animal");
                name = scanner.nextLine();
                System.out.println("give the age");
                age = scanner.nextInt();
                animal = Animal.builder()
                        .name(name)
                        .age(age)
                        .build();
                if(animalShelter.setAnimal(animal)) System.out.println("animal added");;
            } else if (move.equals("2")) {
                Animal animal;
                String name;
                System.out.println("give the name of animal to be remove");
                name = scanner.nextLine();
                if (animalShelter.deleteForName(name)) {
                    System.out.println("delete animal");
                } else {
                    System.out.println("not animal for this name in shelter");
                }
            } else if (move.equals("status")) {
                singletonApi.statusAnimalShelter();
            } else {
                System.out.println("Wrong words!!");
            }
            System.out.println("next question ? (y/n)");
            while(true) {
                move = scanner.nextLine();
                if (move.equals("n")) return;
                else if (move.equals("y")) break;
            }

        }
    }
}