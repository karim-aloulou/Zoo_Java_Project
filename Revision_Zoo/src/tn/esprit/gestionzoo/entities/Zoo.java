package tn.esprit.gestionzoo.entities;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import tn.esprit.gestionzoo.exceptions.FullZooException;

public class Zoo {
	private Set<Animal> animals;
	private String name;
	private String city;
	private int nbrCage;
	private TreeMap<Integer, TreeSet<Animal>> animalsCage;

	public Zoo(String name, String city, int nbrCage) {
		/*this.animals = new TreeSet<Animal>(new Comparator<Animal>() {
			@Override
			public int compare(Animal o1, Animal o2) {
				return o1.getFamily().compareTo(o2.getFamily());
			}
		});*/
		this.animals = new TreeSet<Animal>((o1, o2) -> o1.getFamily().compareTo(o2.getFamily()));

		this.name = name;
		this.city = city;
		setNbrCage(nbrCage);

		animalsCage = new TreeMap<Integer, TreeSet<Animal>>();
		for (int i = 0; i < this.nbrCage; i++) {
			addCage();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getNbrCage() {
		return this.animalsCage.size();
	}

	public TreeMap<Integer, TreeSet<Animal>> getAnimalsCage() {
		return animalsCage;
	}

	public void setAnimalsCage(TreeMap<Integer, TreeSet<Animal>> animalsCage) {
		this.animalsCage = animalsCage;
	}

	public void setNbrCage(int nbrCage) {
		if (nbrCage < 10) {
			System.err.println("zoo cant have less than 10 cages, setting to 10 cages");
			this.nbrCage = 10;
		} else if (nbrCage > 20) {
			System.err.println("zoo cant have more than 20 cages, setting to 20 cages");
			this.nbrCage = 20;
		} else {
			this.nbrCage = nbrCage;
		}
	}

	public void displayZoo() {
		System.out.println("name : " + this.name);
		System.out.println("city : " + this.city);
		System.out.println("number of cages : " + this.nbrCage);
		System.out.println("number of Animals : " + this.animals.size());
	}

	public void addCage() {
		if (getNbrCage() == 20) {
			System.err.println("zoo cant have more than 20 cages");
		} else {
			this.animalsCage.put(getNbrCage(), new TreeSet<Animal>());
		}
	}

	public void affectAnimalToCage(int cageNumber, Animal animal) {
		if (cageNumber < getNbrCage()) {
			if (this.animals.contains(animal)) {
				this.animalsCage.get(cageNumber).add(animal);
			} else {
				System.err.println("Cannot affect non exsisting animal in this Zoo");
			}
		} else {
			System.err.println("Cage number " + cageNumber + " does not exist");

		}

	}

	public TreeSet<Animal> getFreeAnimals() {
		TreeSet<Animal> freeAnimals = (TreeSet<Animal>) this.animals;
		freeAnimals.removeAll(getNonFreeAnimals());
		return freeAnimals;
	}

	public TreeSet<Animal> getNonFreeAnimals() {
		TreeSet<Animal> nonFreeAnimals = new TreeSet<Animal>();

		for (TreeSet<Animal> animals : this.animalsCage.values()) {
			nonFreeAnimals.addAll(animals);
		}

		return nonFreeAnimals;
	}

	public boolean addAnimal(Animal an) throws FullZooException {
		// check array full
		if (this.animals.size() == 50) {
			throw new FullZooException("Zoo is full");
		}
		if (this.animals.contains(an)) {
			System.out.println("Animal exists");
			return false;
		}
		this.animals.add(an);
		return true;
	}

	public boolean removeAnimal(Animal an) {
		return this.animals.remove(an);
	}

/*	public void displayAnimals() {
		for (Animal a : this.animals) {
			System.out.println(a);
		}
	}
*/
	public void displayAnimals() {
		animals.forEach(a->System.out.println(a));
	}
	public void displayAllPredators() {
		System.out.println("Prédateurs : ");
		for (Animal a : this.animals) {
			if (a.estPredateur()) {
				System.out.println(a);
			}
		}
	}

	public void displayAllPreys() {
		System.out.println("Proies : ");
		for (Animal a : this.animals) {
			if (!a.estPredateur()) {
				System.out.println(a);
			}
		}
	}

	@Override
	public String toString() {
		return "Zoo [" + " name=" + name + ", city=" + city + ", nbrCage=" + nbrCage + ", numberOfAnimals="
				+ this.animals.size() + "]";
	}

}