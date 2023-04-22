package tn.esprit.gestionzoo.entities;

import tn.esprit.gestionzoo.main.AnimalType;
public abstract class Animal implements AnimalType, Comparable<Animal> {
	private String family;
	private String name;
	private int age;
	private boolean isMammal;

	private static int totalNumberOfAnimals;

	public Animal(String family, String name, int age, boolean isMammal) {
		this.family = family;
		this.name = name;
		this.isMammal = isMammal;
		setAge(age);

		//System.out.println("A new animal is créated");
		Animal.totalNumberOfAnimals++;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age > 0) {
			this.age = age;
		} else {
			this.age = 0;
			System.err.println("negatif age");
		}
	}

	public boolean isMammal() {
		return isMammal;
	}

	public void setMammal(boolean isMammal) {
		this.isMammal = isMammal;
	}

	public abstract void seDeplacer();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((family == null) ? 0 : family.hashCode());
		result = prime * result + (isMammal ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (age != other.age)
			return false;
		if (family == null) {
			if (other.family != null)
				return false;
		} else if (!family.equals(other.family))
			return false;
		if (isMammal != other.isMammal)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String predateur = this.getStringType();
		return "Animal [family=" + family + ", name=" + name + ", age=" + age + predateur + ", isMammal=" + isMammal
				+ "]";
	}

	public int compareTo(Animal other) {
		if (this.name.compareTo(other.name) == 0) {
			return this.age - other.age;
		}
		return this.name.compareTo(other.name);
	}

}



