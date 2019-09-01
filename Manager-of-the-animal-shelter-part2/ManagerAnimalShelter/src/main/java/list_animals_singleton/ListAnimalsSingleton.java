package list_animals_singleton;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


import animals.Animal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@XmlRootElement(name="listaZwierząt")
public class ListAnimalsSingleton {
	
	
	private int numberMarkLis = -1;
	private ObservableList<Animal> listAnimals;
	private static ListAnimalsSingleton instance;
	
	private ListAnimalsSingleton() {
		ObservableList<Animal> animals = FXCollections.observableArrayList();
 		this.listAnimals = animals;
    }
    
    public static ListAnimalsSingleton getInstance() {
        if (instance == null) {
            instance = new ListAnimalsSingleton();
        }
        
        return instance;
    }
    @XmlElements(@XmlElement(name="Animal"))
	public ObservableList<Animal> getListAnimals() {
		return listAnimals;
	}


	public void setAnimal(Animal animal) {
		this.listAnimals.add(animal);
	}
	
	public void setListAnimals(ObservableList<Animal> listAnimals) {
		this.listAnimals = listAnimals;
	}
	@XmlTransient
	public int getNumberMarkLis() {
		return numberMarkLis;
	}

	public void setNumberMarkLis(int numberMarkLis) {
		this.numberMarkLis = numberMarkLis;
	}
	
	
}
