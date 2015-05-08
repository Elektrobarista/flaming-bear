
public class CurriculumVitae {
	
private enum Color{Black,Grey,Orange,Purple,Red,Green,Blue};
private enum Style{Casual,Classic,Oldstyle,Banking};
private String firstName;
private String lastName;
private String style = new String( Style.Casual.toString().toLowerCase());
private String colorScheme = new String( Color.Black.toString().toLowerCase());;
private String layout = new String("geometry");
private String sectionCollection[];
private int sectionNumber;
private StringBuilder content = new StringBuilder("");


public CurriculumVitae(int sections){
	this.sectionNumber = sections;
	this.sectionCollection = new String[sections];
}


public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public void setStyle(String style) {
	this.style = style;
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

public String getCV() throws IncompleteCVException{
	if (!(style.equals("")) && !(colorScheme.equals("")) && !(layout.equals("")) ){
		content.append("\\documentclass[11pt, a4paper]{moderncv} \n\\moderncvtheme[" + colorScheme +"]" + "{" + style +"}");
		content.append("\n\\usepackage[german]{babel}\n\\usepackage[utf8]{inputenc}\n\\usepackage{" + layout + "}");
		content.append("\n\\firstname{" + firstName + "}" + "\n\\firstname{" + lastName + "}\n\\begin{document}\n\\makecvtitle");
		for(int i = 0; i <= sectionCollection.length - 1; i++){
			content.append(sectionCollection[i]);
		}
		content.append("\n\\end{document}");
		
	}
	else {
		throw new IncompleteCVException();
	}
	
	
	
	return content.toString();
}
















	public static void main(String[] args) throws IncompleteCVException {
		CurriculumVitae cu = new CurriculumVitae(3);
		Section contact = new Section("Kontaktdaten");
		Section edu = new Section("Ausbildung");
		Section lang = new Section("Sprachen");
		contact.addCVLine("", "Sesamstraße");
		contact.addCVLine("", "12345 Muppet Show");
		contact.addCVLine("\\mobilesymbol", "+ 00 123 4567890");
		contact.addCVLine("\\emailsymbol", "\\href{mailto:kermit@muppetshow.de}{kermit@muppetshow.de");
		edu.addCVEntry("10/2012 --heute","Studium der Informatik","Johannes Gutenberg-Universität Mainz");
		edu.addCVEntry("10/2005 -- 5/2012","Abitur","Muppet-Gymnasium","Note: 1,3");
		lang.addCVLine("Englisch", "Muttersprache");
		lang.addCVLine("Deutsch","Fließend in Wort und Schrift" );
		cu.setSection(0,contact);
		cu.setSection(1,edu);
		cu.setSection(2,lang);
		cu.setFirstName("Kermit");
		cu.setLastName("der Frosch");
		
		System.out.println(cu.getCV());
		
	

	}

}
