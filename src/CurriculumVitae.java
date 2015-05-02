
public class CurriculumVitae {
	
private enum Color{Black,Grey,Orange,Purple,Red,Green,Blue};
private enum Style{Casual,Classic,Oldstyle,Banking};
private String firstName;
private String lastName;
private static String style = new String( Style.Casual.toString().toLowerCase());
private String colorScheme = new String( Color.Black.toString().toLowerCase());;
private String layout = new String("geometry");
private String sectionCollection[];
private int sectionNumber;
private StringBuilder content = new StringBuilder("");


public CurriculumVitae(int sections){
	this.sectionNumber = sections;
	this.sectionCollection = new String[sections-1];
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


public void setSection(int number, Section section){
	if(number <= sectionNumber && number  >= 0){
		this.sectionCollection[number] = section.toString();
	}
	
}

public String getCV() throws IncompleteCVException{ // Exception Klasse muss noch geschrieben werden
	if ((style != ""||style != null) && (colorScheme != "" || colorScheme != null)&& (layout != "" || layout != null )){
		//Hier wird der Lebenslauf generiert
	}
	
	
	return content.toString();
}
















	public static void main(String[] args) {
		CurriculumVitae cu = new CurriculumVitae(4);
		Section n = new Section("testname");
		n.addCVLine("test1","test2");
		n.addCVEntry("t","g","h","q","j","k");
		cu.setSection(0,n);
		System.out.println(cu.sectionCollection.length);
		System.out.println(cu.sectionCollection[0]);
		
	

	}

}
