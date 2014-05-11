import	java.io.File;
import 	java.util.Scanner;
import	java.io.IOException;	
import	java.io.RandomAccessFile;	
import	java.io.FileReader;	
import	java.io.FileWriter;	
import	java.io.BufferedReader;	
import	java.io.BufferedWriter;	



public class CurriculumVitae {
	// KLassenvariablen
	String lineSeparator = System.getProperty("line.separator");
	String phoneNumber = new String();
	String email = new String();
	String[] personalData = new String [3];
	String[] [] education = new String [2] [6];
	String[] adress = new String [2];
	String[] [] language = new String [2] [6];
	BufferedWriter curriculumVitae;
	
	// Methode zum laden der Daten aus einer .cv Datei
	public void loadCV(){
		
		Scanner scanner = new Scanner(System.in);
		// Pfad der zu ladenden Datei wird durch Benutzer Eingabe eingelesen.
 		System.out.println("In welcher Datei befinden sich ihre CV-Daten?(c:\\User\\ich.cv)");
		String path = scanner.nextLine();
		scanner.close();
		try{
			// Ein BufferdReader zum lesen der Datei wird angelegt.
			BufferedReader readCv = new BufferedReader(new FileReader(new File(path)));
			boolean moreDataExsists = true;
			String readLine;
			//Solange witere Lines in der Datei sind werden diese ausgelesen.
			while(moreDataExsists = true){
				readLine = readCv.readLine();
				if(readLine != null){
					switch (readLine){
						// Es wird je nachdem welches Schl�sselwort eingelesen wurde eine ander Klassenvariable gesetzt.
						case "#PersonalData" :
								this.personalData[0]=readCv.readLine().toString().replaceAll("Vorname: ", "");
								this.personalData[1]=readCv.readLine().toString().replaceAll("Nachname: ", "");
								this.personalData[2]=readCv.readLine().toString().replaceAll("Bild: ", "");
							break;
						case "#Kontaktdaten" :
								this.email=readCv.readLine().toString().replaceAll("Email: ", "");
								this.phoneNumber=readCv.readLine().toString().replaceAll("Telefonnummer: ", "");
								this.adress[0]=readCv.readLine().toString().replaceAll("Stra�e: ", "");
								this.adress[1]=readCv.readLine().toString().replaceAll("Wohnort: ", "");
							break;
						case "#Ausbildung" :
								this.education[0][0]=readCv.readLine().toString().replaceAll("--", "");
								this.education[0][1]=readCv.readLine().toString().replaceAll("--", "");
								this.education[0][2]=readCv.readLine().toString().replaceAll("--", "");
								this.education[0][3]=readCv.readLine().toString().replaceAll("--", "");
								this.education[0][4]=readCv.readLine().toString().replaceAll("--", "");
								this.education[0][5]=readCv.readLine().toString().replaceAll("--", "");
								this.education[1][0]=readCv.readLine().toString().replaceAll("--", "");
								this.education[1][1]=readCv.readLine().toString().replaceAll("--", "");
								this.education[1][2]=readCv.readLine().toString().replaceAll("--", "");
								this.education[1][3]=readCv.readLine().toString().replaceAll("--", "");
								this.education[1][4]=readCv.readLine().toString().replaceAll("--", "");
								this.education[1][5]=readCv.readLine().toString().replaceAll("--", "");
							break;
						case "#Sprache" :
								this.language[0][0]=readCv.readLine().toString().replaceAll("--", "");
								this.language[0][1]=readCv.readLine().toString().replaceAll("--", "");
								this.language[0][2]=readCv.readLine().toString().replaceAll("--", "");
								this.language[0][3]=readCv.readLine().toString().replaceAll("--", "");
								this.language[0][4]=readCv.readLine().toString().replaceAll("--", "");
								this.language[0][5]=readCv.readLine().toString().replaceAll("--", "");
								this.language[1][0]=readCv.readLine().toString().replaceAll("--", "");
								this.language[1][1]=readCv.readLine().toString().replaceAll("--", "");
								this.language[1][2]=readCv.readLine().toString().replaceAll("--", "");
								this.language[1][3]=readCv.readLine().toString().replaceAll("--", "");
								this.language[1][4]=readCv.readLine().toString().replaceAll("--", "");
								this.language[1][5]=readCv.readLine().toString().replaceAll("--", "");	
							break;
						case "$":
							readCv.close();
							moreDataExsists = false;
							
						break;	
					}
				System.out.println(readLine);	
				}
				else{
					moreDataExsists = false;
				}
				
			}

			readCv.close();
		}
		catch(IOException	e){
			
		}
	}
	public void SaveCV(String path){
		Scanner scanner = new Scanner(System.in);
		// Pfad der zu ladenden Datei wird durch Benutzer Eingabe eingelesen.
 		/*System.out.println("In welche Datei sollen die CV-Daten gespeichert werden?(c:\\User\\ich.cv)");
		String path = scanner.nextLine();
		scanner.close();*/
		File datei = new File (path); 
		if (path.endsWith(".cv") == false)try{
			throw new InvalidFile();
		}
		catch (InvalidFile ex){
			System.out.println("InvalidFile:Datei existtiert nicht oder kann nicht geschrieben werden.");
		}
		// �ffnet und beschreibt die Datei.
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
				// Erzeugt einen BufferedWriter zum schreiben der Datei.
				BufferedWriter writeCv = new BufferedWriter(new FileWriter(datei));
				writeCv.write("#PersonalData"+this.lineSeparator);
				writeCv.write("Vorname: "+this.personalData[0]);
				writeCv.write("Nachname: "+this.personalData[1]+this.lineSeparator);
				writeCv.write("Bild: "+this.personalData[2]+this.lineSeparator);
				writeCv.write("#Kontaktdaten"+this.lineSeparator);
				writeCv.write("Email: "+this.email+this.lineSeparator);
				writeCv.write("Telefonnummer: "+this.phoneNumber+this.lineSeparator);
				writeCv.write("Stra�e: "+this.adress[0]+this.lineSeparator);
				writeCv.write("Wohnort: "+this.adress[1]+this.lineSeparator);
				writeCv.write("#Ausbildung"+this.lineSeparator);
				writeCv.write(this.education[0][0]+this.lineSeparator);
				writeCv.write(this.education[0][1]+this.lineSeparator);
				writeCv.write(this.education[0][2]+this.lineSeparator);
				writeCv.write(this.education[0][3]+this.lineSeparator);
				writeCv.write(this.education[0][4]+this.lineSeparator);
				writeCv.write(this.education[0][5]+this.lineSeparator);
				writeCv.write(this.education[1][0]+this.lineSeparator);
				writeCv.write(this.education[1][1]+this.lineSeparator);
				writeCv.write(this.education[1][2]+this.lineSeparator);
				writeCv.write(this.education[1][3]+this.lineSeparator);
				writeCv.write(this.education[1][4]+this.lineSeparator);
				writeCv.write(this.education[1][5]+this.lineSeparator);
				writeCv.write("#Sprachen"+this.lineSeparator);
				writeCv.write(this.language[0][0]+this.lineSeparator);
				writeCv.write(this.language[0][1]+this.lineSeparator);
				writeCv.write(this.language[0][2]+this.lineSeparator);
				writeCv.write(this.language[0][3]+this.lineSeparator);
				writeCv.write(this.language[0][4]+this.lineSeparator);
				writeCv.write(this.language[0][5]+this.lineSeparator);
				writeCv.write(this.language[1][0]+this.lineSeparator);
				writeCv.write(this.language[1][1]+this.lineSeparator);
				writeCv.write(this.language[1][2]+this.lineSeparator);
				writeCv.write(this.language[1][3]+this.lineSeparator);
				writeCv.write(this.language[1][4]+this.lineSeparator);
				writeCv.write(this.language[1][5]+this.lineSeparator);
				writeCv.write("$");
				writeCv.close();
			}
			catch(IOException eq){
			/////////////////	
			}
		}	
		catch(IOException e){
		/////////////////////		
		}
	}
	
	// Tauscht alle Umlaute gegen Latexkonforme Codierung um
	String convertUmlaut(String convert){
		convert = convert.replaceAll("�", "\\\\\"a");
		convert = convert.replaceAll("�", "\\\\\"u");
		convert = convert.replaceAll("�", "\\\\\"o");
		convert = convert.replaceAll("�", "\\\\\"A");
		convert = convert.replaceAll("�", "\\\\\"U");
		convert = convert.replaceAll("�", "\\\\\"O");
		convert = convert.replaceAll("�", "\\\\ss ");
		return convert;
	}
	
	// Erzeugt einen String in dem Latex-Code f�r pers�nliche Daten steht. ( Name, Vorname, Bild)
	String createPersonalData() throws InvalidName ,InvalidPicture{
			// Liest Lineseperator aus.
			
			// Wurde ein Vorname eingegeben?
			if (personalData[0].equals("") == true){
				throw new InvalidName();
			}
			// Wurde ein Nachname eingegeben?
			if (personalData[1].equals("") == true){
				throw new InvalidName();
			}
			if (personalData[2].equals("") == true){
				return "\\firstname{"+personalData[0]+"}"+this.lineSeparator+"\\familyname{"+personalData[1]+"}";
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
				//Umwandlung von '\' f�r Latex
				if (personalData[2].charAt(i)=='\\'){
					latexPath = latexPath + "/";
				}
				else{
					latexPath = latexPath + personalData[2].charAt(i);
				}
			}		
		return "\\firstname{"+personalData[0]+"}"+lineSeparator+"\\familyname{"+personalData[1]+"}"+lineSeparator+"\\photo[96pt]{"+latexPath+"}";
	}
	// Wenn eine g�ltige Telefonnummer �bergeben wird konvertierung in Latex-Code
	String writeMobileLine()throws InvalidMobileNumber{
		char[] number = this.phoneNumber.toCharArray();
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
		if (correctNumber == false){
			throw new InvalidMobileNumber();
		}
		// Die Telefonnummer mit dem Code f�r Latex als String zur�ckgegeben.
		return "\\cvline{\\mobilesymbol}{"+this.phoneNumber+"}";
	}
	
	// Wenn eine g�ltige Email-Adresse �bergeben wird konvertierung in Latex-Code
		// Wirft eine Exception wenn kein "@" vorhanden ist.
		String writeEmailLine()throws InvalidEmail{
		char[] mail = this.email.toCharArray();
		boolean atExist = false ;
		// Geht den �bergebenen String durch und schaut ob "@" vorhanden ist.
		for (int i = 0 ; i < mail.length ; i++){
			if (mail[i] == '@'){
				atExist = true ;
			}	
		}
		// Wenn kein "@" vorhanden ist wird eine Exception geworfen
		if (atExist == false){
			throw new InvalidEmail();
		}
		// Ansonsten wird ein String der die Email Darstellung in Latex erzegen soll zur�ckgegeben.
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
		// �berpr�ft ob es die Datei gibt sie schreibbar ist und der Typ ".tex" ist.
		// Schmei�t eine Exception wenn nicht.
		if (path.endsWith(".tex") == false)try{
			throw new InvalidFile();
		}
		catch (InvalidFile ex){
			System.out.println("InvalidFile:Datei existtiert nicht oder kann nicht geschrieben werden.");
		}
		// �ffnet und beschreibt die Datei.
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
				this.curriculumVitae = new BufferedWriter(new FileWriter(datei));
				//Schreibt Anfang des Latex DOKUMENTS
				curriculumVitae.write("%use class moderncv"+lineSeparator +"\\documentclass[11pt,a4paper]{moderncv}"+lineSeparator+lineSeparator+"%language package"+lineSeparator
											+ "\\usepackage[german]{babel}"+lineSeparator+lineSeparator+"%choosen theme"+lineSeparator+"\\moderncvtheme[blue]{classic}"+lineSeparator);
				// Schreiben der Datei.	
				curriculumVitae.write(this.convertUmlaut(this.createPersonalData())+lineSeparator);
				curriculumVitae.write("\\begin{document}"+lineSeparator+"\\maketitle"+lineSeparator+"\\section{Komtaktdaten}"+lineSeparator);
				curriculumVitae.write(this.convertUmlaut(this.writeCVLine("",adress[0]))+lineSeparator);
				curriculumVitae.write(this.convertUmlaut(this.writeCVLine("",adress[1]))+lineSeparator);
				curriculumVitae.write(this.convertUmlaut(this.writeEmailLine())+lineSeparator);
				curriculumVitae.write(this.writeMobileLine()+lineSeparator);
				curriculumVitae.write("\\section{Ausbildung}"+lineSeparator);
				curriculumVitae.write(this.convertUmlaut(this.createCVEntry(education[0]))+lineSeparator);
				curriculumVitae.write(this.convertUmlaut(this.createCVEntry(education[1]))+lineSeparator);
				curriculumVitae.write("\\section{Sprachen}"+lineSeparator);
				curriculumVitae.write(this.convertUmlaut(this.createCVEntry(language[0]))+lineSeparator);
				curriculumVitae.write(this.convertUmlaut(this.createCVEntry(language[1]))+lineSeparator);
				curriculumVitae.write("\\end{document}");
				curriculumVitae.close();
			}
				//Exceptons werden abgefangen
				catch(InvalidMobileNumber e){
					curriculumVitae.write("InvalidMobileNumber:Keine g\"ultige Telefonnummer.");
				}
				catch(InvalidEmail e){
					curriculumVitae.write("InvalidEmail:Keine g\"ultige Email-Adresse");
				}
				catch(InvalidCVLine e){
					curriculumVitae.write("InvalidCVLine:Kein zweiter eintrag.");
				}
				catch(InvalidCVEntry e){
					curriculumVitae.write("InvalidCVEntry:Kein erster oder zweiter eintrag.");
				}
				catch(InvalidPicture e){
					curriculumVitae.write("InvalidPicture:Kein Bild gefunden.");
				}
				catch(InvalidName e){
					curriculumVitae.write("InvalidName:Kein Vor oder Nachnahme eingegeben.");
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
