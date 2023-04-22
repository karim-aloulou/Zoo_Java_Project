package tn.esprit.gestionzoo.entities;

public class singe extends Animal {
	String fruitPrefere;
	
	public singe(String family, String name, int age, boolean isMammal) 
	{super(family, name, age, isMammal);
	this.fruitPrefere = "Banane";}
	
	public singe(String family, String name, int age, boolean isMammal,String fruitPrefere)
	{super(family, name, age, isMammal);
	this.fruitPrefere = fruitPrefere;}

	@Override
	public void seDeplacer() {
		System.out.println("Je suis un perroquet, je vole");
	}

	@Override
	public String toString() {
		return "Singe [fruitPrefere=" + fruitPrefere + "]" + super.toString();
	}

	@Override
	public boolean estPredateur() {
		return false;
	}

}
