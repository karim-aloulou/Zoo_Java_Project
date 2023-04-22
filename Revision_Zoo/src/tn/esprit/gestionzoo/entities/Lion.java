package tn.esprit.gestionzoo.entities;

public class Lion extends Animal {
int circonferenceCriniere;

public int getCirconferenceCriniere() {return circonferenceCriniere;}
public void setCirconferenceCriniere(int circonferenceCriniere) {this.circonferenceCriniere=circonferenceCriniere;}
public Lion(String family, String name, int age, boolean isMammal,int circonferenceCriniere) {
	super(family, name, age, isMammal);
	this.circonferenceCriniere=circonferenceCriniere;
	}
@Override
public void seDeplacer() {
	System.out.println("Je suis un lion, je cours");

}
@Override
public String toString() {
	return "Lion [circonferenceCriniere=" + circonferenceCriniere + "]"+ super.toString();
}
public boolean estPredateur() {return true;}

}
