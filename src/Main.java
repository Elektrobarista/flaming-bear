import java.io.File;
import java.util.Scanner;

/*
 * Main Class to create the CV
 */
public class Main {

	public static void main(String[] args) throws IncompleteCVException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		String user;
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
		System.out.println("Name des Userverzeichnisses eingeben:");
		user = sc.nextLine();
		sc.close();
		File f = new File("C:"+File.separator+"Users"+File.separator+user+File.separator+"cv.gz");
		File g= new File("C:"+File.separator+"Users"+File.separator+user+File.separator+"cv.tex");
		cu.saveCV(f);
		cu.loadCV(f).writeCV(g);
		System.out.println("done");
	}

}
