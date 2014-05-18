/*
 * Group 61
 * Einfuehrung in die Softwareentwicklung
 * Uebung 3
 * class to create a .tex-file
 *
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CurriculumVitae {
  // Klassenvariablen
  LanguageKnowledge mu = LanguageKnowledge.MUTTERSPRACHE;
  LanguageKnowledge fl = LanguageKnowledge.FLIESSEND;
  LanguageKnowledge gr = LanguageKnowledge.GRUNDKENNTNISSE;
  String lineSeparator = System.getProperty("line.separator");
  String phoneNumber = new String();
  String email = new String();
  String[] personalData = new String[3];
  String[][] education = new String[2][6];
  String[] adress = new String[2];
  String[][] language = new String[3][6];
  BufferedWriter curriculumVitae;
  CVTheme theme = new CVTheme();
  
  enum LanguageKnowledge {
    MUTTERSPRACHE("Muttersprache"), FLIESSEND(
    "fließend in Wort und Schrift"), GRUNDKENNTNISSE(
    "Grundkenntnisse");
    String knowledge;
    
    LanguageKnowledge(String lk) {
      this.knowledge = lk;
    }
    
    String getKnowledge() {
      return this.knowledge;
    }
  }
  
  
  public String[] langknowString = new String[6];
  public LanguageKnowledge[] langknow = new LanguageKnowledge[6];
  
  // Methode zum laden der Daten aus einer .cv Datei
  
  public void loadCV(){    
    Scanner scanner = new Scanner(System.in); 
    // Pfad der zu ladenden Datei wird durch Benutzer Eingabe eingelesen.
    System.out.println("In welcher Datei befinden sich ihre CV-Daten?(c:\\User\\ich.cv)");
    String path = scanner.nextLine(); scanner.close(); try{
      // EinBufferdReader zum lesen der Datei wird angelegt.
      BufferedReader readCv = new BufferedReader(new FileReader(new File(path))); 
      boolean moreDataExsists = true;
      String readLine; 
      //Solange witere Lines in der Datei sind werden diese ausgelesen. 
      while(moreDataExsists == true){
        readLine = readCv.readLine();
        if(readLine != null){ 
          switch (readLine){
            //Es wird je nachdem welches Schlüsselwort eingelesen wurde eine ander Klassenvariable gesetzt. 
            case "#PersonalData" :
            
            this.personalData[0]=readCv.readLine().toString().replaceAll("Vorname: ","");
            this.personalData[1]=readCv.readLine().toString().replaceAll("Nachname: ", "");
            this.personalData[2]=readCv.readLine().toString().replaceAll("Bild: ", "");
            break;
            
            case "#Kontaktdaten" :
            this.email=readCv.readLine().toString().replaceAll("Email: ", "");
            this.phoneNumber =readCv.readLine().toString().replaceAll("Telefonnummer: ", "");
            this.adress[0]=readCv.readLine().toString().replaceAll("Straße: ", "");
            this.adress[1]=readCv.readLine().toString().replaceAll("Wohnort: ", "");
            break;
            
            case "#Ausbildung" : 
            for (int i=0;i<(this.education.length) ;i++ ){ 
              for (int j=0;j<(this.education[0].length);j++ ) {
              this.education[i][j]=readCv.readLine().toString().replaceAll("--", ""); }
            } 
            break;
            
            case "#Sprache" : 
            for (int i=0;i<6 ;i++ ) {
              this.language[i][0]=readCv.readLine().toString().replaceAll("--", "");
              this.langknowString[i]=readCv.readLine().toString().replaceAll("--", "");
              if (this.langknowString[i].equals("Muttersprache")) {
                this.langknow[i]=LanguageKnowledge.MUTTERSPRACHE; 
              }else if(this.langknowString[i].equals("fließend in Wort und Schrift")){
                this.langknow[i]=LanguageKnowledge.FLIESSEND; 
              }else if(this.langknowString[i].equals("Grundkenntnisse")){
                this.langknow[i]=LanguageKnowledge.GRUNDKENNTNISSE; 
              } 
            }
            break;
            
            case "$":  
            readCv.close(); 
            moreDataExsists = false;
            break; 
          }
        System.out.println(readLine); } 
        else{ 
          moreDataExsists = false;
        }
        
      }
      
    readCv.close(); } catch(IOException e){
      
    } 
  }
  
  public void saveCV(String path) {
    Scanner scanner = new Scanner(System.in);
    // Pfad der zu ladenden Datei wird durch Benutzer Eingabe eingelesen.
    /*
    * System.out.println(
    * "In welche Datei sollen die CV-Daten gespeichert werden?(c:\\User\\ich.cv)"
    * ); String path = scanner.nextLine(); scanner.close();
    */
    File datei = new File(path);
    if (path.endsWith(".cv") == false)
    try {
      throw new InvalidFile();
    } catch (InvalidFile ex) {
      System.out
      .println("InvalidFile:Datei existiert nicht oder kann nicht geschrieben werden.");
    }
    // Öffnet und beschreibt die Datei.
    else
    try {
      File dateiPfad = new File(path.replaceAll(datei.getName(), ""));
      dateiPfad.mkdirs();
      datei.createNewFile();
      if (datei.exists() == false || datei.canWrite() == false)
      try {
        throw new InvalidFile();
      } catch (InvalidFile ex) {
        System.out
        .println("InvalidFile:Datei existiert nicht oder kann nicht geschrieben werden.");
      }
      else
      try {
        // Erzeugt einen BufferedWriter zum schreiben der Datei.
        BufferedWriter writeCv = new BufferedWriter(
        new FileWriter(datei));
        writeCv.write("#PersonalData" + this.lineSeparator);
        writeCv.write("Vorname: " + this.personalData[0]
        + this.lineSeparator);
        writeCv.write("Nachname: " + this.personalData[1]
        + this.lineSeparator);
        writeCv.write("Bild: " + this.personalData[2]
        + this.lineSeparator);
        writeCv.write("#Kontaktdaten" + this.lineSeparator);
        writeCv.write("Email: " + this.email
        + this.lineSeparator);
        writeCv.write("Telefonnummer: " + this.phoneNumber
        + this.lineSeparator);
        writeCv.write("Straße: " + this.adress[0]
        + this.lineSeparator);
        writeCv.write("Wohnort: " + this.adress[1]
        + this.lineSeparator);
        writeCv.write("#Ausbildung" + this.lineSeparator);
        for (int i = 0; i < (this.education.length); i++) {
          for (int j = 0; j < (this.education[0].length); j++) {
            writeCv.write(this.education[i][j]
            + this.lineSeparator);
          }
        }
        
        writeCv.write("#Sprachen" + this.lineSeparator);
        /*for (int i = 0; i < 6; i++) {
        writeCv.write(this.language[i] + this.lineSeparator);
        writeCv.write(this.langknow[i] + this.lineSeparator);
        }*/
        writeCv.write("$");
        writeCv.close();
      } catch (IOException eq) {
        // ///////////////
      }
    } catch (IOException e) {
      // ///////////////////
    }
  }
  
  // Tauscht alle Umlaute gegen Latexkonforme Codierung um
  String convertUmlaut(String convert) {
    convert = convert.replaceAll("ä", "\\\\\"a");
    convert = convert.replaceAll("ü", "\\\\\"u");
    convert = convert.replaceAll("ö", "\\\\\"o");
    convert = convert.replaceAll("Ä", "\\\\\"A");
    convert = convert.replaceAll("Ü", "\\\\\"U");
    convert = convert.replaceAll("Ö", "\\\\\"O");
    convert = convert.replaceAll("ß", "\\\\ss ");
    return convert;
  }
  
  // Erzeugt einen String in dem Latex-Code für persönliche Daten steht. (
  // Name, Vorname, Bild)
  String createPersonalData() throws InvalidName, InvalidPicture {
    // Liest Lineseperator aus.
    
    // Wurde ein Vorname eingegeben?
    if (personalData[0].equals("") == true) {
      throw new InvalidName();
    }
    // Wurde ein Nachname eingegeben?
    if (personalData[1].equals("") == true) {
      throw new InvalidName();
    }
    if (personalData[2].equals("") == true) {
      return "\\firstname{" + personalData[0] + "}" + this.lineSeparator + "\\familyname{" + personalData[1] + "}";
    }
    String latexPath = "";
    for (int i = 0; i < personalData[2].length(); i++) {
      // Umwandlung von '\' bei Windows in '\\'
      if (personalData[2].charAt(i) == '\\') {
        latexPath = latexPath + "\\\\";
      } else {
        latexPath = latexPath + personalData[2].charAt(i);
      }
    }
    File bild = new File(latexPath);
    // Gibt es eine Bilddatei?
    if (bild.exists() == false
    || (personalData[2].endsWith(".JPG") == false && personalData[2].endsWith(".jpg") == false)) {
      throw new InvalidPicture();
    }
    latexPath = "";
    for (int i = 0; i < personalData[2].length(); i++) {
      // Umwandlung von '\' für Latex
      if (personalData[2].charAt(i) == '\\') {
        latexPath = latexPath + "/";
      } else {
        latexPath = latexPath + personalData[2].charAt(i);
      }
    }
    return "\\firstname{" + personalData[0] + "}" + lineSeparator
    + "\\familyname{" + personalData[1] + "}" + lineSeparator
    + "\\photo[96pt]{" + latexPath + "}";
  }
  
  // Wenn eine gültige Telefonnummer übergeben wird konvertierung in
  // Latex-Code
  String writeMobileLine() throws InvalidMobileNumber,InvalidCVLine {
    char[] number = this.phoneNumber.toCharArray();
    boolean correctNumber = false;
    // Wenn kein "+" den String anführt ist es keien gültige Eingabe.
    if (number[0] == '+') {
      correctNumber = true;
    }
    // Überprüft ob alle restlichen Zeichen des Übergebenen Strings Ziffern
    // von 0-9 oder Leerzeichen sind.
    for (int i = 1; i < number.length; i++) {
      if (number[i] == '0' || number[i] == '1' || number[i] == '2'
      || number[i] == '3' || number[i] == '4' || number[i] == '5'
      || number[i] == '6' || number[i] == '7' || number[i] == '8'
      || number[i] == '9' || number[i] == ' ') {
      } else {
        correctNumber = false;
        break;
      }
    }
    // Wenn es sich um keine gültige Eingabe für die Telefonummer gehandelt
    // hat wird eine Exception geschmissen.
    if (correctNumber == false) {
      throw new InvalidMobileNumber();
    }
    // Die Telefonnummer mit dem Code für Latex als String zurückgegeben.
    return writeCVLine("\\mobilesymbol",this.phoneNumber);
  }
  
  // Wenn eine gültige Email-Adresse übergeben wird konvertierung in
  // Latex-Code
  // Wirft eine Exception wenn kein "@" vorhanden ist.
  String writeEmailLine() throws InvalidEmail {
    char[] mail = this.email.toCharArray();
    boolean atExist = false;
    // Geht den übergebenen String durch und schaut ob "@" vorhanden ist.
    for (int i = 0; i < mail.length; i++) {
      if (mail[i] == '@') {
        atExist = true;
      }
    }
    // Wenn kein "@" vorhanden ist wird eine Exception geworfen
    if (atExist == false) {
      throw new InvalidEmail();
    }
    // Ansonsten wird ein String der die Email Darstellung in Latex erzegen
    // soll zurückgegeben.
    return "\\cvline{\\emailsymbol}{\\href{mailto:" + this.email + "}{" + this.email + "}}";
  }
  
  // 2 Strings werden geschrieben.
  String writeCVLine(String firstString, String secondString)
  throws InvalidCVLine {
    if (secondString.equals("") == true) {
      throw new InvalidCVLine();
    }
    return "\\cvline{" + firstString + "}{" + secondString + "}";
  }
  
  // 6 Strings werden geschrieben.
  String createCVEntry(String[] cvEntry) throws InvalidCVEntry {
    if (cvEntry[0].equals("") == true || cvEntry[1].equals("") == true) {
      throw new InvalidCVEntry();
    }
    return "\\cventry{" + cvEntry[0] + "}{" + cvEntry[1] + "}{"
    + cvEntry[2] + "}{" + cvEntry[3] + "}{" + cvEntry[4] + "}{"
    + cvEntry[5] + "}";
  }
  
  // Schreibt die Datei falls vorhanden, schreibbar und vom Typ ".tex".
  public void writeCV(String path) {
    File datei = new File(path);
    // Überprüft ob es die Datei gibt sie schreibbar ist und der Typ ".tex"
    // ist.
    // Schmeißt eine Exception wenn nicht.
    if (path.endsWith(".tex") == false)
    try {
      throw new InvalidFile();
    } catch (InvalidFile ex) {
      System.out
      .println("InvalidFile:Datei existiert nicht oder kann nicht geschrieben werden.");
    }
    // Öffnet und beschreibt die Datei.
    else
    try {
      File dateiPfad = new File(path.replaceAll(datei.getName(), ""));
      dateiPfad.mkdirs();
      datei.createNewFile();
      if (datei.exists() == false || datei.canWrite() == false)
      try {
        throw new InvalidFile();
      } catch (InvalidFile ex) {
        System.out.println("InvalidFile:Datei existtiert nicht oder kann nicht geschrieben werden.");
      }
      else
      try {
        // Liest den Betriebssystemt line Seperator aus.
        String lineSeparator = System.getProperty("line.separator");
        this.curriculumVitae = new BufferedWriter(new FileWriter(datei));
        // Schreibt Anfang des Latex DOKUMENTS
        curriculumVitae.write("%use class moderncv" + lineSeparator);
        curriculumVitae.write("\\documentclass[11pt,a4paper]{moderncv}" + lineSeparator);
        curriculumVitae.write(lineSeparator + "%language package" + lineSeparator);
        curriculumVitae.write("\\usepackage[german]{babel}" + lineSeparator);
        curriculumVitae.write(lineSeparator + "%choosen theme" + lineSeparator);
        curriculumVitae.write("\\moderncvtheme["+theme.getColor()+"]{"+theme.getStyle()+"}");
        // Schreiben der Datei.
        curriculumVitae.write(lineSeparator+"%given personal data"+lineSeparator);
        curriculumVitae.write(this.convertUmlaut(this.createPersonalData()) + lineSeparator);
        curriculumVitae.write(lineSeparator+"%create a document"+lineSeparator);
        curriculumVitae.write("\\begin{document}"+ lineSeparator );
        curriculumVitae.write(lineSeparator+"%create title based on personal data"+lineSeparator);
        curriculumVitae.write("\\maketitle" + lineSeparator);
        curriculumVitae.write(lineSeparator+"%section for contact data"+lineSeparator);
        curriculumVitae.write("\\section{Komtaktdaten}" + lineSeparator);
        curriculumVitae.write(this.convertUmlaut(this.writeCVLine("", adress[0])) + lineSeparator);
        curriculumVitae.write(this.convertUmlaut(this.writeCVLine("", adress[1])) + lineSeparator);
        curriculumVitae.write(this.convertUmlaut(this.writeEmailLine()) + lineSeparator);
        curriculumVitae.write(this.writeMobileLine()+ lineSeparator);
        curriculumVitae.write(lineSeparator+"%section for education"+lineSeparator);
        curriculumVitae.write("\\section{Ausbildung}"+ lineSeparator);
        curriculumVitae.write(this.convertUmlaut(this.createCVEntry(education[0])) + lineSeparator);
        curriculumVitae.write(this.convertUmlaut(this.createCVEntry(education[1])) + lineSeparator);
        curriculumVitae.write(lineSeparator+"%section for language"+lineSeparator);
        curriculumVitae.write("\\section{Sprachen}" + lineSeparator);
        curriculumVitae.write(this.convertUmlaut(this.createCVEntry(language[0])) + lineSeparator);
        curriculumVitae.write(this.convertUmlaut(this.createCVEntry(language[1])) + lineSeparator);
        
        /*
        * for (int i=0;i<language.length ;i++ ) { if
        * (language[i]!="") {
        * curriculumVitae.write(this.convertUmlaut
        * (this.writeCVLine
        * (language[i],langknow[i].getKnowledge
        * ()))+lineSeparator); } }
        */
        curriculumVitae.write(lineSeparator+"\\end{document}");
        curriculumVitae.close();
      }
      // Exceptons werden abgefangen
      catch (InvalidMobileNumber e) {
        curriculumVitae.write("InvalidMobileNumber:Keine g\"ultige Telefonnummer.");
      } catch (InvalidEmail e) {
        curriculumVitae.write("InvalidEmail:Keine g\"ultige Email-Adresse");
      } catch (InvalidCVLine e) {
        curriculumVitae.write("InvalidCVLine:Kein zweiter eintrag.");
      } catch (InvalidCVEntry e) {
        curriculumVitae.write("InvalidCVEntry:Kein erster oder zweiter eintrag.");
      } catch (InvalidPicture e) {
        curriculumVitae.write("InvalidPicture:Kein Bild gefunden.");
      } catch (InvalidName e) {
        curriculumVitae.write("InvalidName:Kein Vor oder Nachnahme eingegeben.");
      } catch (IOException e) {
        System.out.println("IOException:Datei nicht gefunden.");
      }
      curriculumVitae.close();
      
    } catch (IOException e) {
      System.out.println("Fehler Datei kann nicht erstellt werde.");
    }
  }
  
  public void compressCV(String path) throws IOException {
    if (path.endsWith(".zip")) {
      File zipFile = new File(path);
      File cvTex = new File(path.replaceAll(zipFile.getName(), "") + "\\"
      + this.personalData[0] + "_" + this.personalData[1]
      + ".tex");
      File pfad = new File(cvTex.getPath().replaceAll(cvTex.getName(), ""));
      cvTex.createNewFile();
      this.writeCV(cvTex.getPath());
      FileInputStream fis = new FileInputStream(cvTex);
      ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));
      
      int read = fis.read();
      ZipEntry zipEntry = new ZipEntry(cvTex.getName());
      zos.putNextEntry(zipEntry);
      while (read != -1) {
        zos.write(read);
        read = fis.read();
      }
      cvTex.deleteOnExit();
      zos.closeEntry();
      fis.close();
      
      File cvCv = new File(path.replaceAll(zipFile.getName(), "") + "\\"
      + this.personalData[0] + "_" + this.personalData[1] + ".cv");
      
      cvCv.createNewFile();
      
      this.saveCV(cvCv.getPath());
      fis = new FileInputStream(cvCv);
      read = fis.read();
      zipEntry = new ZipEntry(cvCv.getName());
      zos.putNextEntry(zipEntry);
      while (read != -1) {
        zos.write(read);
        read = fis.read();
      }
      cvCv.deleteOnExit();
      zos.closeEntry();
      
      fis.close();
      File picture = new File(this.personalData[2]);
      
      fis = new FileInputStream(cvCv);
      read = fis.read();
      zipEntry = new ZipEntry(picture.getName());
      zos.putNextEntry(zipEntry);
      while (read != -1) {
        zos.write(read);
        read = fis.read();
      }
      zos.closeEntry();
      
      fis.close();
      zos.close();
    }
    else if (path.endsWith(".gzip")){
      
      File gzipFile = new File(path);
      
      File cvTex = new File(path.replaceAll(gzipFile.getName(), "") + "\\"
      + this.personalData[0] + "_" + this.personalData[1]
      + ".tex");
      File pfad = new File(cvTex.getPath()
      .replaceAll(cvTex.getName(), ""));
      pfad.mkdirs();
      cvTex.createNewFile();
      //this.writeCV(cvTex.getPath());
      FileInputStream fis = new FileInputStream(cvTex); 
      GZIPOutputStream zos  = new GZIPOutputStream(new FileOutputStream(gzipFile),2097152); 
      
      int read  = fis.read(); 
      while (read !=  -1) { 
        zos.write(read);  
        read  = fis.read(); 
      } 
      cvTex.deleteOnExit(); 
      fis.close();  
      zos.close();  
    }
  }
}
