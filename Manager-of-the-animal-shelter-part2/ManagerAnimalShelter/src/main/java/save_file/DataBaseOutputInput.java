package save_file;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Interfaces.ReadWrite;
import animals.Animal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import list_animals_singleton.ListAnimalsSingleton;

public class DataBaseOutputInput implements ReadWrite {

	ListAnimalsSingleton listAnimalsSingleton;

	public DataBaseOutputInput() {
		listAnimalsSingleton = ListAnimalsSingleton.getInstance();
	}

	@Override
	public void writeData() {
		deleteAllAnimal();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDataBase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		for (Animal animal : listAnimalsSingleton.getListAnimals()) {
			entityManager.merge(animal);
		}
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}

	public void deleteAllAnimal() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDataBase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("delete from Animal");
		query.executeUpdate();
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}

	@Override
	public void readData() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDataBase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<Animal> query = entityManager.createQuery("Select a from Animal a", Animal.class);
		ObservableList<Animal> listAnimals = FXCollections.observableArrayList(query.getResultList());
		entityManager.close();
		entityManagerFactory.close();
		listAnimalsSingleton.setListAnimals(listAnimals);
		System.out.println(listAnimals);
	}
}
