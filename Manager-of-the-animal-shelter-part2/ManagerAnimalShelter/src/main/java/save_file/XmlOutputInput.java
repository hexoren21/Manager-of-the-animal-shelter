package save_file;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import Interfaces.ReadWrite;
import animals.Animal;
import list_animals_singleton.ListAnimalsSingleton;

public class XmlOutputInput implements ReadWrite {
	ListAnimalsSingleton listAnimalsSingleton;

	public XmlOutputInput() {
		listAnimalsSingleton = ListAnimalsSingleton.getInstance();
	}

	@Override
	public void writeData() {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(ListAnimalsSingleton.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(listAnimalsSingleton, new File("XmlAnimals.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readData() {
		File file = new File("XmlAnimals.xml");
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(ListAnimalsSingleton.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			listAnimalsSingleton = (ListAnimalsSingleton) jaxbUnmarshaller.unmarshal(file);
			ListAnimalsSingleton.getInstance().setListAnimals(listAnimalsSingleton.getListAnimals());
			System.out.println(listAnimalsSingleton.getListAnimals());
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
