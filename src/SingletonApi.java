import shelters.AnimalShelter;

public class SingletonApi{
    private static SingletonApi instance;
    AnimalShelter animalShelter_;
    private SingletonApi(AnimalShelter animalShelter) {
        this.animalShelter_ = animalShelter;
    }
    public static SingletonApi getInstance(AnimalShelter animalShelter) {
        if (instance == null) {
            instance = new SingletonApi(animalShelter);
        }
        return instance;
    }

    public void statusAnimalShelter() {
        int size = animalShelter_.getAnimalsList().size();
        System.out.println("amount of animal : " + size);
        if (size <= 2) System.out.println("status: empty");
        else  System.out.println("status: full");
        System.out.println(animalShelter_);
    }
}
