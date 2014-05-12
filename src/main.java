import 	java.util.Scanner;
public class main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		CurriculumVitae kermit = new CurriculumVitae();
		kermit.loadCV();
		/*
		kermit.personalData[0] = "Kermit der";
		kermit.personalData[1] = "Frosch";
		System.out.println("Bilddateipfad eingeben(.jpg):");
		kermit.personalData[2] = scanner.nextLine();
		kermit.phoneNumber = "+78 787 8787";
		kermit.email = "kermit@frosch.de";
		kermit.adress[0] ="Sesamstraße 1";
		kermit.adress[1] ="123 Irgendwo";
		kermit.education[0][0] = "2000-2001";
		kermit.education[0][1] = "Uni Mainz";
		kermit.education[0][2] = "Informatik";
		kermit.education[0][3] = "";
		kermit.education[0][4] = "";
		kermit.education[0][5] = "";
		kermit.education[1][0] = "Vorher";
		kermit.education[1][1] = "Schule";
		kermit.education[1][2] = "";
		kermit.education[1][3] = "";
		kermit.education[1][4] = "";
		kermit.education[1][5] = "";
		kermit.language[0][0] = "Muttersprache";
		kermit.language[0][1] = "Deutsch";
		kermit.language[0][2] = "";
		kermit.language[0][3] = "";
		kermit.language[0][4] = "";
		kermit.language[0][5] = "";
		kermit.language[1][0] = "Sprachen";
		kermit.language[1][1] = "Englisch";
		kermit.language[1][2] = "Spanisch";
		kermit.language[1][3] = "";
		kermit.language[1][4] = "";
		kermit.language[1][5] = "";
		*/
		System.out.println("Dateipfad für .tex Datei angeben:");
		kermit.writeCV("c:\\users\\lars\\current.tex");
		scanner.close();	
		kermit.SaveCV("c:\\users\\lars\\test2.cv");
	}

}

