
public abstract class Zutat extends Cocktail {
	
	private Cocktail cocktail;

	public Zutat(Cocktail cocktail, double capacity) {
		this.cocktail = cocktail;
	}

	@Override
	public double getPreis() {		
		return cocktail.getPreis() + preis;
	}

	@Override
	public String getBeschreibung() {	
		return cocktail.getBeschreibung() + "mit den Zutaten" + beschreibung;
	}

}
