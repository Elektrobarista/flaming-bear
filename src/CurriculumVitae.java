import	java.io.File;
import	java.io.IOException;	
import	java.io.RandomAccessFile;	
import 	java.util.Scanner;

public class CurriculumVitae {
	// KLassenvariablen
	String phoneNumber = new String();
	String email = new String();
	String[] personalData = new String [3];
	String[] [] education = new String [2] [6];
	String[] adress = new String [2];
	String[] [] language = new String [2] [6];
	RandomAccessFile curriculumVitae;
	
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
	String createPersonalData() throws InvalidName ,InvalidPicture{
			// Liest Lineseperator aus.
			String lineSeparator = System.getProperty("line.separator");
			// Wurde ein Vorname eingegeben?
			if (personalData[0].equals("") == true){
				throw new InvalidName();
			}
			// Wurde ein Nachname eingegeben?
			if (personalData[1].equals("") == true){
				throw new InvalidName();
			}
			String latexPath = "";
			for (int i = 0; i < personalData[2].length(); i++){
				//Umwandlung von '\' bei Windows in '\\'
				if (personalData[2].charAt(i)=='\\'){
					latexPath = latexPath + "\\\\";
				}
				else{
					latexPath = latexPath + personalData[2].charAt(i);
				}
			}
			File bild = new File(latexPath);
			// Gibt es eine Bilddatei?
			if(bild.exists() == false||(personalData[2].endsWith(".JPG") == false && personalData[2].endsWith(".jpg") == false)){
				throw new InvalidPicture();
			}
			latexPath = "";
			for (int i = 0; i < personalData[2].length(); i++){
				//Umwandlung von '\' für Latex
				if (personalData[2].charAt(i)=='\\'){
					latexPath = latexPath + "/";
				}
				else{
					latexPath = latexPath + personalData[2].charAt(i);
				}
			}		
		return "\\firstname{"+personalData[0]+"}"+lineSeparator+"\\familyname{"+personalData[1]+"}"+lineSeparator+"\\photo[96pt]{"+latexPath+"}";
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
		return "\\cvline{\\mobilesymbol}{this.phoneNumber}";
	}
	
	// Wenn eine gültige Email-Adresse übergeben wird konvertierung in Latex-Code
		// Wirft eine Exception wenn kein "@" vorhanden ist.
		String writeEmailLine()throws InvalidEmail{
		char[] mail = this.email.toCharArray();
		boolean atExist = false ;
		// Geht den übergebenen String durch und schaut ob "@" vorhanden ist.
		for (int i = 0 ; i < mail.length ; i++){
			if (mail[i] == '@'){
				atExist = true ;
			}	
		}
		// Wenn kein "@" vorhanden ist wird eine Exception geworfen
		if (atExist == false){
			throw new InvalidEmail();
		}
		// Ansonsten wird ein String der die Email Darstellung in Latex erzegen soll zurückgegeben.
		return "\\cvline{\\emailsymbol}{\\href{mailto:" + this.email +"}{" + this.email + "}}";
	}
	// 2 Strings werden geschrieben.
	String writeCVLine(String firstString, String secondString)throws InvalidCVLine{
		if (secondString.equals("") == true){
			throw new InvalidCVLine();
		}
		return "\\cvline{" + firstString + "}{" + secondString +"}";
	}
	// 6 Strings werden geschrieben.
	String createCVEntry(String[] cvEntry)throws InvalidCVEntry{
		if (cvEntry[0].equals("") == true || cvEntry[1].equals("") == true){
			throw new InvalidCVEntry();
		}
		return "\\cventry{" + cvEntry[0] + "}{" + cvEntry[1] +"}{" + cvEntry[2] + "}{" + cvEntry[3] +"}{" + cvEntry[4] + "}{" + cvEntry[5] + "}";
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
			System.out.println("InvalidFile:Datei existtiert nicht oder kann nicht geschrieben werden.");
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
				//Schreibt Anfang des Latex DOKUMENTS
				curriculumVitae.writeBytes("%use class moderncv"+lineSeparator +"\\documentclass[11pt,a4paper]{moderncv}"+lineSeparator+lineSeparator+"%language package"+lineSeparator
											+ "\\usepackage[german]{babel}"+lineSeparator+lineSeparator+"%choosen theme"+lineSeparator+"\\moderncvtheme[blue]{classic}"+lineSeparator);
				// Schreiben der Datei.	
				{
				curriculumVitae.writeBytes(this.convertUmlaut(this.createPersonalData())+lineSeparator);
				}
				curriculumVitae.writeBytes("\\begin{document}"+lineSeparator+"\\maketitle"+lineSeparator+"\\section{Komtaktdaten}"+lineSeparator);
				curriculumVitae.writeBytes(this.convertUmlaut(this.writeCVLine("",adress[0]))+lineSeparator);
				curriculumVitae.writeBytes(this.convertUmlaut(this.writeCVLine("",adress[1]))+lineSeparator);
				curriculumVitae.writeBytes(this.convertUmlaut(this.writeEmailLine())+lineSeparator);
				curriculumVitae.writeBytes(this.writeMobileLine()+lineSeparator);
				curriculumVitae.writeBytes("\\section{Ausbildung}"+lineSeparator);
				curriculumVitae.writeBytes(this.convertUmlaut(this.createCVEntry(education[0]))+lineSeparator);
				curriculumVitae.writeBytes(this.convertUmlaut(this.createCVEntry(education[1]))+lineSeparator);
				curriculumVitae.writeBytes("\\section{Sprachen}"+lineSeparator);
				curriculumVitae.writeBytes(this.convertUmlaut(this.createCVEntry(language[0]))+lineSeparator);
				curriculumVitae.writeBytes(this.convertUmlaut(this.createCVEntry(language[1]))+lineSeparator);
				curriculumVitae.writeBytes("\\end{document}");
				curriculumVitae.close();
			}
			//Exceptons werden abgefangen
			catch(InvalidMobileNumber e){
				curriculumVitae.writeBytes("InvalidMobileNumber:Kein zweiter eintrag.");
			}
			catch(InvalidEmail e){
				curriculumVitae.writeBytes("InvalidEmail:Kein zweiter eintrag.");
			}
			catch(InvalidCVLine e){
				curriculumVitae.writeBytes("InvalidCVLine:Kein zweiter eintrag.");
			}
			catch(InvalidCVEntry e){
				curriculumVitae.writeBytes("InvalidCVEntry:Kein erster oder zweiter eintrag.");
			}
			catch(InvalidPicture e){
				curriculumVitae.writeBytes("InvalidPicture:Kein Bild gefunden.");
			}
			catch(InvalidName e){
				curriculumVitae.writeBytes("InvalidName:Kein Vor oder Nachnahme eingegeben.");
			}
			catch (IOException e){
				System.out.println("IOException:Datei nicht gefunden.");
			}
			curriculumVitae.close();
		}
		catch (IOException e){
			System.out.println("Fehler Datei kann nicht erstellt werde.");
		}
	}
}
