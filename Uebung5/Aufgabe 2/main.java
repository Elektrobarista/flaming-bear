
public class main {

	public static void main(String[] args) {
		Cocktail c = new Tequila(new LongDrink(),2);
		System.out.println(c.getBeschreibung());
		System.out.println(c.getPreis());

	}

}
