import	java.io.File;
import	java.io.IOException;	
import	java.io.RandomAccessFile;	

public class CurriculumVitae {
	// Tauscht alle Umlaute gegen Latexkonforme Codierung um
	String convertUmlaut(String s){
		String u="";
		for (int i = 0; i < s.length(); i++){
			//Umwandlung von '�'
			if (s.charAt(i)=='�'){
				u =u + "\\\"a";
				continue;
			}
			//Umwandlung von '�'
			if (s.charAt(i)=='�'){
				u =u + "\\\"o";
				continue;
			}			
			//Umwandlung von '�'
			if (s.charAt(i)=='�'){
				u =u + "\\\"u";
				continue;
			}
			//Umwandlung von '�'
			if (s.charAt(i)=='�'){
				u =u + "\\ss ";
				continue;
			}
			else{
				u =u + s.charAt(i);
			}
		}
			
		return u;
	}
	// Erzeugt einen String in dem Latex-Code f�r pers�nliche Daten steht. ( Name, Vorname, Bild)
	String createPersonalData(){
		return "Test";
	}
	// Wenn eine g�ltige Telefonnummer �bergeben wird konvertierung in Latex-Code
	String writeMobileLine(String phoneNumber){
		char[] number = phoneNumber.toCharArray();
		boolean correctNumber = false;
		// Wenn kein "+" den String anf�hrt ist es keien g�ltige Eingabe. 
		if (number[0] == '+'){
			correctNumber = true;
		}
		// �berpr�ft ob alle restlichen Zeichen des �bergebenen Strings Ziffern von 0-9 oder Leerzeichen sind.
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
		// Wenn es sich um keine g�ltige Eingabe f�r die Telefonummer gehandelt hat wird eine Exception geschmissen.
		if (correctNumber == false) try{
			throw new InvalidMobileNumber();
		}
		// Die Exception wird aufgefangen und eine Fehlermeldung wird als String zur�ckgegeben.
		catch (InvalidMobileNumber ex){
			return "InvalidMobileNumber:Keine gueltige Telephonnummer";
		}
		// Ansonsten wird die Telefonnummer mit dem Code f�r Latex als String zur�ckgegeben.
		return "\\cvline{\\mobilesymbol}{" + phoneNumber + "}";
	}
	
	// Wenn eine g�ltige Email-Adresse �bergeben wird konvertierung in Latex-Code
		// Wirft eine Exception wenn kein "@" vorhanden ist.
		String writeEMailLine(String email){
		char[] mail = email.toCharArray();
		boolean atExist = false ;
		// Geht den �bergebenen String durch und schaut ob "@" vorhanden ist.
		for (int i = 0 ; i < mail.length ; i++){
			if (mail[i] == '@'){
				atExist = true ;
			}	
		}
		// Wenn kein "@" vorhanden ist wird eine Exception geworfen
		if (atExist == false) try {
			throw new InvalidEmail();
		}
		// F�ngt die Excetion auf und gibt einen String zur�ck
		catch (InvalidEmail ex) {
			return "InvalidEmail:Keine gueltige Email eingegeben";
		}
		// Ansonsten wird ein String der die Email Darstellung in Latex erzegen soll zur�ckgegeben.
		return "\\cvline{\\emailsymbol}{\\{mailto:" + email +"}{" + email + "}}" ;
	}
	// 2 Strings werden geschrieben.
	String writeCVLine(String firstString, String secondString){
		if (secondString == "")try{
			throw new InvalidCVLine();
		}
		// Wenn der 2. String leer ist wird eine Exception geworfen.
		catch (InvalidCVLine ex){
			return "InvalidCVLine:Kein 2. String";
		}
		return "\\cvline{" + firstString + "}{" + secondString +"}";
	}
	// 6 Strings werden geschrieben.
	String createCVEntry(String firstString ,String secondString, String thirdString, String fourthString, String fithString, String sixthString){
		if (firstString == "" || secondString == "") try{
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
		// �berpr�ft ob es die Datei gibt sie schreibbar ist und der Typ ".tex" ist.
		// Schmei�t eine Exception wenn nicht.
		if (path.endsWith(".tex") == false || datei.exists() == false || datei.canWrite() == false)try{
			throw new InvalidFile();
		}
		catch (InvalidFile ex){
			System.out.println("InvalidFile:Datei existtiert nicht oder kann nicht geschrieben werden.");
		}
		// �ffnet und beschreibt die Datei.
		else try {
			// Liest den Betriebssystemt line Seperator aus.
			String lineSeparator = System.getProperty("line.separator");
			RandomAccessFile curriculumVitae = new RandomAccessFile(datei,"rw");
			curriculumVitae.writeBytes("%use class moderncv"+lineSeparator +"\\documentclass[11pt,a4paper]{moderncv}"+lineSeparator+lineSeparator+"%language package"+lineSeparator
											+ "\\usepackage[german]{babel}"+lineSeparator+lineSeparator+"%choosen theme"+lineSeparator+"\\moderncvtheme[blue]{classic}"+lineSeparator);
			curriculumVitae.writeBytes(this.convertUmlaut(this.createPersonalData())+lineSeparator);
			curriculumVitae.writeBytes(this.convertUmlaut(this.writeEMailLine("maxmusterman@mail.com"))+lineSeparator);
			curriculumVitae.writeBytes(this.writeMobileLine("+49 1223 231")+lineSeparator);
			curriculumVitae.writeBytes(this.convertUmlaut(this.createCVEntry("Studium", "Uni Mainz", "Informatik", "Mathematik", "", "")));
			curriculumVitae.close();
		}
		catch (IOException e){
			System.out.println("IOException:Datei nicht gefunden.");
		}
	}
}
