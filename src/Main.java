import java.io.File;


public class Main {

	public static void main(String[] args) throws IncompleteCVException, ClassNotFoundException {
		CurriculumVitae cu = new CurriculumVitae(3);
		Section contact = new Section("Kontaktdaten");
		Section edu = new Section("Ausbildung");
		Section lang = new Section("Sprachen");
		contact.addCVLine("", "Sesamstraﬂe");
		contact.addCVLine("", "12345 Muppet Show");
		contact.addCVLine("\\mobilesymbol", "+ 00 123 4567890");
		contact.addCVLine("\\emailsymbol", "\\href{mailto:kermit@muppetshow.de}{kermit@muppetshow.de");
		edu.addCVEntry("10/2012 --heute","Studium der Informatik","Johannes Gutenberg-Universit‰t Mainz");
		edu.addCVEntry("10/2005 -- 5/2012","Abitur","Muppet-Gymnasium","Note: 1,3");
		lang.addCVLine("Englisch", "Muttersprache");
		lang.addCVLine("Deutsch","Flieﬂend in Wort und Schrift" );
		cu.setSection(0,contact);
		cu.setSection(1,edu);
		cu.setSection(2,lang);
		cu.setFirstName("Kermit");
		cu.setLastName("der Frosch");
		File f = new File("C:"+File.separator+"Users"+File.separator+"Alex"+File.separator+"cv.es");
		cu.saveCV(f);
		
		System.out.println(cu.loadCV(f).getCV());

	}

}
