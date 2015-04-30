
public class CurriculumVitae {
	
private enum Color{Black,Grey,Orange,Purple,Red,Green,Blue};
private enum Style{Casual,Classic,Oldstyle,Banking};
private String firstName;
private String lastName;
private static String style = new String( Style.Casual.toString().toLowerCase());
private String colorScheme = new String( Color.Black.toString().toLowerCase());;
private String layout = new String("geometry");
private int sectionNumber;
private Section section;//???Fraglich???

public CurriculumVitae(int sections){
	this.sectionNumber = sections;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public static void setStyle(String style) {
	CurriculumVitae.style = style;
}

public void setColorScheme(String colorSheme) {
	this.colorScheme = colorSheme;
}

public void setLayout(String layout) {
	this.layout = layout;
}

//Ich habe bisher noch keine Ahung, was diese Methode genau machen soll
public void setSection(int number, Section section){
	
}

















	public static void main(String[] args) {
		
	

	}

}
