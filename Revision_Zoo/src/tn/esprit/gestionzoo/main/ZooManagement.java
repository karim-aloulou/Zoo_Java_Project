package tn.esprit.gestionzoo.main;
import tn.esprit.gestionzoo.entities.Dauphin;
import tn.esprit.gestionzoo.entities.Lion;
import tn.esprit.gestionzoo.entities.Perroquet;
import tn.esprit.gestionzoo.entities.Zoo;
import tn.esprit.gestionzoo.entities.singe;
import tn.esprit.gestionzoo.exceptions.FullZooException;

public class ZooManagement {

	public static void main(String[] args) {
		
		Zoo myZoo = new Zoo("Clifornia Zoo", "California", 12);
		
		Lion lion = new Lion("Félins", "Simba the King lion", 15, true,20);
		Perroquet pero = new Perroquet("oiseau", "charlie", 20, false, 120);
		singe singe = new singe("Primate", "mooky", 10, true);
		
		singe singe2 = new singe("Primate", "saadoun", 12, true);
		
		myZoo.addCage();
		
		try {
			myZoo.addAnimal(lion);
			myZoo.addAnimal(pero);
			myZoo.addAnimal(singe);
		} catch (FullZooException e) {
			e.printStackTrace();
		}
		myZoo.affectAnimalToCage(0, singe);
		myZoo.affectAnimalToCage(3, pero);
		
		System.out.println(myZoo.getNonFreeAnimals());
		

		
	}

}