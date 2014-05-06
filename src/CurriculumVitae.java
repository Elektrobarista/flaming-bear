import	java.io.File;
import	java.io.IOException;	
import	java.io.RandomAccessFile;	
import 	java.util.Scanner;

public class CurriculumVitae {
	// KLassenvariablen
	String phoneNumber = new String();
	String email = new String();
	String[] personalData = new String [3];
	String[] [] education = new String[2] [6];
	
	// Tauscht alle Umlaute gegen Latexkonforme Codierung um
	String convertUmlaut(String convert){
		convert = convert.replaceAll("ä", "\\\\\"a");
		convert = convert.replaceAll("ü", "\\\\\"u");
		convert = convert.replaceAll("ö", "\\\\\"o");
		convert = convert.replaceAll("Ä", "\\\\\"A");
		convert = convert.replaceAll("Ü", "\\\\\"U");
		convert = convert.replaceAll("Ö", "\\\\\"O");
		convert = convert.replaceAll("ß", "\\\\\"ss");
		return convert;
	}
	
	// Erzeugt einen String in dem Latex-Code für persönliche Daten steht. ( Name, Vorname, Bild)
	String createPersonalData(String firstName, String familyName, String picturePath) throws InvalidName ,InvalidPicture{
			// Liest Lineseperator aus.
			String lineSeparator = System.getProperty("line.separator");
			// Wurde ein Vorname eingegeben?
			if (firstName.equals("") == true){
				throw new InvalidName();
			}
			// Wurde ein Nachname eingegeben?
			if (familyName.equals("") == true)try{
				throw new InvalidName();
			}
			catch (InvalidName e){
				firstName = "InvalidName: Kein Familienname";
			}
			String latexPath = "";
			for (int i = 0; i < picturePath.length(); i++){
				//Umwandlung von '\' bei Windows in '\\'
				if (picturePath.charAt(i)=='\\'){
					latexPath = latexPath + "\\\\";
				}
				else{
					latexPath = latexPath + picturePath.charAt(i);
				}
			}
			File bild = new File(latexPath);
			// Gibt es eine Bilddatei?
			if(bild.exists() == false||(picturePath.endsWith(".JPG") == false && picturePath.endsWith(".jpg") == false)){
				throw new InvalidPicture();
			}
			latexPath = "";
			for (int i = 0; i < picturePath.length(); i++){
				//Umwandlung von '\' für Latex
				if (picturePath.charAt(i)=='\\'){
					latexPath = latexPath + "/";
				}
				else{
					latexPath = latexPath + picturePath.charAt(i);
				}
			}		
		return "\\firstname{"+firstName+"}"+lineSeparator+"\\familyname{"+familyName+"}"+lineSeparator+"\\photo[96pt]{"+latexPath+"}";
	}
	// Wenn eine gültige Telefonnummer übergeben wird konvertierung in Latex-Code
	String writeMobileLine()throws InvalidMobileNumber{
		char[] number = this.phoneNumber.toCharArray();
		boolean correctNumber = false;
		// Wenn kein "+" den String anführt ist es keien gültige Eingabe. 
		if (number[0] == '+'){
			correctNumber = true;
		}
		// Überprüft ob alle restlichen Zeichen des Übergebenen Strings Ziffern von 0-9 oder Leerzeichen sind.
		for (int i = 1 ; i < number.length ; i++ ){
			if (number[i] == '0'||number[i] == '1'||number[i] == '2'||
					number[i] == '3'||number[i] == '4'||number[i] == '5'
					||number[i] == '6'||number[i] == '7'||number[i] == '8'
						||number[i] == '9'||number[i] == ' '){
			}
			else{
				correctNumber = false;
				break;
			}		
		}
		// Wenn es sich um keine gültige Eingabe für die Telefonummer gehandelt hat wird eine Exception geschmissen.
		if (correctNumber == false){
			throw new InvalidMobileNumber();
		}
		// Die Telefonnummer mit dem Code für Latex als String zurückgegeben.
		return this.writeCVLine("\\mobilesymbol", this.phoneNumber);
	}
	
	// Wenn eine gültige Email-Adresse übergeben wird konvertierung in Latex-Code
		// Wirft eine Exception wenn kein "@" vorhanden ist.
		String writeEmailLine(){
		char[] mail = this.email.toCharArray();
		boolean atExist = false ;
		// Geht den übergebenen String durch und schaut ob "@" vorhanden ist.
		for (int i = 0 ; i < mail.length ; i++){
			if (mail[i] == '@'){
				atExist = true ;
			}	
		}
		// Wenn kein "@" vorhanden ist wird eine Exception geworfen
		if (atExist == false) try {
			throw new InvalidEmail();
		}
		// Fängt die Excetion auf und gibt einen String zurück
		catch (InvalidEmail ex) {
			return "InvalidEmail:Keine gueltige Email eingegeben";
		}
		// Ansonsten wird ein String der die Email Darstellung in Latex erzegen soll zurückgegeben.
		return this.writeCVLine("\\emailsymbol", "\\href{mailto:" + this.email +"}{" + this.email + "");
	}
	// 2 Strings werden geschrieben.
	String writeCVLine(String firstString, String secondString)throws InvalidCVLine{
		if (secondString.equals("") == true){
			throw new InvalidCVLine();
		}
		return "\\cvline{" + firstString + "}{" + secondString +"}";
	}
	// 6 Strings werden geschrieben.
	String createCVEntry(String firstString ,String secondString, String thirdString, String fourthString, String fithString, String sixthString){
		if (firstString.equals("") == true || secondString.equals("") == true) try{
			throw new InvalidCVEntry();
		}
		catch (InvalidCVEntry ex){
			return "InvalidCVEntry:Kein 1. String oder 2.String";
		}
		return "\\cventry{" + firstString + "}{" + secondString +"}{" + thirdString + "}{" + fourthString +"}{" + fithString + "}{" + sixthString + "}";
	}
	// Schreibt die Datei falls vorhanden, schreibbar und vom Typ ".tex".
	public void writeCV(String path){
		File datei = new File (path); 
		// Überprüft ob es die Datei gibt sie schreibbar ist und der Typ ".tex" ist.
		// Schmeißt eine Exception wenn nicht.
		if (path.endsWith(".tex") == false)try{
			throw new InvalidFile();
		}
		catch (InvalidFile ex){
			System.out.println("InvalidFile:Datei existiert nicht oder kann nicht geschrieben werden.");
		}
		// Öffnet und beschreibt die Datei.
		else try{
			File dateiPfad = new File(path.replaceAll(datei.getName(),""));
			dateiPfad.mkdirs();
			datei.createNewFile();
			if (datei.exists() == false || datei.canWrite() == false)try{
				throw new InvalidFile();
			}
			catch (InvalidFile ex){
				System.out.println("InvalidFile:Datei existtiert nicht oder kann nicht geschrieben werden.");
			}
			else try{
				
			
				// Liest den Betriebssystemt line Seperator aus.
				String lineSeparator = System.getProperty("line.separator");
				RandomAccessFile curriculumVitae = new RandomAccessFile(datei,"rw");
				curriculumVitae.writeBytes("%use class moderncv"+lineSeparator +"\\documentclass[11pt,a4paper]{moderncv}"+lineSeparator+lineSeparator+"%language package"+lineSeparator
											+ "\\usepackage[german]{babel}"+lineSeparator+lineSeparator+"%choosen theme"+lineSeparator+"\\moderncvtheme[blue]{classic}"+lineSeparator);
				// Schreiben der Datei.	
				Scanner scanner = new Scanner(System.in);
				System.out.println("Vornamen eingeben:");
				String firstName = scanner.nextLine();
				System.out.println("Nachname eingeben:");
				String familyName = scanner.nextLine();
				System.out.println("Pfad zu einer Bilddatei angeben .jpg (C:\\User\\Pictures\\bild.jpg)");
				String picturePath = scanner.nextLine();
				curriculumVitae.writeBytes(this.convertUmlaut(this.createPersonalData(firstName,familyName,picturePath))+lineSeparator);
				curriculumVitae.writeBytes("\\begin{document}"+lineSeparator+"\\maketitle"+lineSeparator+"\\section{Komtaktdaten}"+lineSeparator);
				System.out.println("Adresse eingeben:(Straße 12)(123 Wohnort)");
				String street = scanner.nextLine();
				String city = scanner.nextLine();
				curriculumVitae.writeBytes(this.convertUmlaut(this.writeCVLine(street, city))+lineSeparator);
				System.out.println("Email-Adresse eingeben:");
				String email = scanner.nextLine();
				curriculumVitae.writeBytes(this.convertUmlaut(this.writeEmailLine())+lineSeparator);
				System.out.println("Telefonnummer eingeben (+49 ...):");
				String phoneNumber = scanner.nextLine();
				curriculumVitae.writeBytes(this.writeMobileLine()+lineSeparator);
				curriculumVitae.writeBytes("\\section{Ausbildung}"+lineSeparator);
				System.out.println("Ausbildungsinformationen eingeben 6 Felder:");
				String first = scanner.nextLine();
				String second = scanner.nextLine();
				String third = scanner.nextLine();
				String fourth = scanner.nextLine();
				String fifth = scanner.nextLine();
				String sixth = scanner.nextLine();
				curriculumVitae.writeBytes(this.convertUmlaut(this.createCVEntry(first, second, third, fourth, fifth, sixth))+lineSeparator);
				scanner.close();
				curriculumVitae.writeBytes("\\end{document}");
				curriculumVitae.close();
			}
		
			catch (IOException e){
				System.out.println("IOException:Datei nicht gefunden.");
			}
		}
		catch (IOException e){
			System.out.println("Fehler Datei kann nicht erstellt werde.");
		}
	}
}
