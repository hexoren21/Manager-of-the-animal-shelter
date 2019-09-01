package save_file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Interfaces.ReadWrite;
import animals.Animal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import list_animals_singleton.ListAnimalsSingleton;

public class CsvOutputInput implements ReadWrite {
	ListAnimalsSingleton listAnimalsSingleton;

	public CsvOutputInput() {
		listAnimalsSingleton = ListAnimalsSingleton.getInstance();
	}

	@Override
	public void writeData() {
		String csvFile = "CsvAnimals.csv";
		ObservableList<Animal> listAnimals = listAnimalsSingleton.getListAnimals();
		FileWriter writer = null;
		try {
			writer = new FileWriter(csvFile);
			writer.append("Name,Age\n");
			for (Animal a : listAnimals) {
				writer.append(a.getName_());
				writer.append(",");
				writer.append(Integer.toString(a.getAge_()));
				writer.append("\n");
			}
		} catch (IOException ex) {
			System.out.println(ex);
		} finally {
			try {
				writer.flush();
				writer.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	@Override
	public void readData() {
		String csvFile = "CsvAnimals.csv";
		BufferedReader reader = null;
		try {
			ObservableList<Animal> listAnimals = FXCollections.observableArrayList();
			String line = "";
			reader = new BufferedReader(new FileReader(csvFile));
			reader.readLine();

			while ((line = reader.readLine()) != null) {
				String[] fields = line.split(",");

				if (fields.length > 0) {
					Animal animal = new Animal();
					animal.setName_(fields[0]);
					animal.setAge_(Integer.parseInt(fields[1]));
					listAnimals.add(animal);
				}
			}
			listAnimalsSingleton.setListAnimals(listAnimals);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(listAnimalsSingleton.getListAnimals());
	}
}
