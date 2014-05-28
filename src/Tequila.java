
class Tequila extends Zutat{

	public Tequila(Cocktail cocktail, double capacity) {
		super(cocktail, capacity);
		preis = 0.80 * capacity;
		beschreibung = "Tequila";
	}

}
