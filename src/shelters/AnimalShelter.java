package shelters;

import animals.Animal;

import java.util.ArrayList;

public class AnimalShelter {
    private ArrayList<Animal> animalsList = new ArrayList<>();
    public AnimalShelter() {
        animalsList = new ArrayList<>();
    }

    public ArrayList<Animal> getAnimalsList() {
        return animalsList;
    }

    public boolean setAnimal(Animal animal) {
        if(animalsList.size() >=3) {
            System.out.println("(AnimalShelter) Wrong, shelter is full!!");
            return false;
        }
        else {
            this.animalsList.add(animal);
            return true;
        }
    }

    public boolean deleteForName(String name) {
        boolean flagDelete = false;
        for (int i = 0; i < animalsList.size(); i++) {

            if (animalsList.get(i).getName_().equals(name)) {
                System.out.println("(AnimalShelter)Delete animal");
                animalsList.remove(i);
                flagDelete = true;
            }
        }
        return flagDelete;
    }

    @Override
    public String toString() {
        return "AnimalShelter{" +
                "animalsList=" + animalsList +
                '}';
    }
}
