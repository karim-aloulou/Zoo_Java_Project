package tn.esprit.gestionzoo.main;

public interface AnimalType {
	public boolean estPredateur();

	default String getStringType() {
		if (estPredateur()) {
			return "je suis un predateur";
		} else {
			return "je suis une proie";
		}
	};

}
