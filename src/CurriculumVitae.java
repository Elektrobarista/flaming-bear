import	java.io.File;
import	java.io.IOException;	
import	java.io.RandomAccessFile;	

public class CurriculumVitae {
	// Tauscht alle Umlaute gegen Latexkonforme Codierung um
	String convertUmlaut(String s){
		String u="";
		for (int i = 0; i < s.length(); i++){
			//Umwandlung von 'ä'
			if (s.charAt(i)=='ä'){
				u =u + "\\\"a";
				continue;
			}
			//Umwandlung von 'ö'
			if (s.charAt(i)=='ö'){
				u =u + "\\\"o";
				continue;
			}			
			//Umwandlung von 'ü'
			if (s.charAt(i)=='ü'){
				u =u + "\\\"u";
				continue;
			}
			//Umwandlung von 'ß'
			if (s.charAt(i)=='ß'){
				u =u + "\\ss ";
				continue;
			}
			else{
				u =u + s.charAt(i);
			}
		}
			
		return u;
	}
	// Erzeugt einen String in dem Latex-Code für persönliche Daten steht. ( Name, Vorname, Bild)
	String createPersonalData(){
		return "Test";
	}
	// Wenn eine gültige Telefonnummer übergeben wird konvertierung in Latex-Code
	String writeMobileLine(String phoneNumber){
		char[] number = phoneNumber.toCharArray();
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
		if (correctNumber == false) try{
			throw new InvalidMobileNumber();
		}
		// Die Exception wird aufgefangen und eine Fehlermeldung wird als String zurückgegeben.
		catch (InvalidMobileNumber ex){
			return "InvalidMobileNumber:Keine gueltige Telephonnummer";
		}
		// Ansonsten wird die Telefonnummer mit dem Code für Latex als String zurückgegeben.
		return "\\cvline{\\mobilesymbol}{" + phoneNumber + "}";
	}
	
	// Wenn eine gültige Email-Adresse übergeben wird konvertierung in Latex-Code
		// Wirft eine Exception wenn kein "@" vorhanden ist.
		String writeEMailLine(String email){
		char[] mail = email.toCharArray();
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
		// Überprüft ob es die Datei gibt sie schreibbar ist und der Typ ".tex" ist.
		// Schmeißt eine Exception wenn nicht.
		if (path.endsWith(".tex") == false || datei.exists() == false || datei.canWrite() == false)try{
			throw new InvalidFile();
		}
		catch (InvalidFile ex){
			System.out.println("InvalidFile:Datei existtiert nicht oder kann nicht geschrieben werden.");
		}
		// Öffnet und beschreibt die Datei.
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
