package tn.esprit.gestionzoo.entities;

public class Dauphin extends Animal {
	int profondeurMaximale;

	public int getProfondeurMaximale() {
		return profondeurMaximale;
	}

	public void setProfondeurMaximale(int profondeurMaximale) {
		this.profondeurMaximale = profondeurMaximale;
	}

	public Dauphin(String family, String name, int age, boolean isMammal, int profondeurMaximale) {
		super(family, name, age, isMammal);
		this.profondeurMaximale = profondeurMaximale;
	}

	@Override
	public void seDeplacer() {
		System.out.println("Je suis un dauphin, je nage");

	}

	@Override
	public String toString() {
		return "Dauphin [profondeurMaximale=" + profondeurMaximale + "]" + super.toString();
	}

	public boolean estPredateur() {
		return false;
	}
}
