
public class CurriculumVitae {
	// Tauscht alle umlaute gegen Latexkonforme COdierung um
	String convertUmlaut(){
		return null;
	}
	// Erzeugt einen String in dem Latex-Code f�r pers�nliche Daten steht. ( Name, Vorname, Bild)
	String createPersonalData(){
		return null;
	}
	// Wenn eine g�ltige Telefonnummer �bergeben wird konvertierung in Latex-Code
	String writeMobileLine(){
		return null;
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
			throw new NoEmailException() ;
		}
		// F�ngt die Excetion auf und gibt einen String zur�ck
		catch (NoEmailException ex) {
			return "Keine gueltige Email eingegeben";
		}
		// Ansonsten wird ein String der die Email Darstellung in Latex erzegen soll zur�ckgegeben.
		return "\\cvline{\\emailsymbol}{\\href{mailto:" + email +"}{" + email + "}}" ;
	}
	// 2 Strings werden zusammengefasst.
	String writeCVLine(){
		return null;
	}
	// 6 Strings werden zusammengefasst.
	String createCVEntry(){
		return null;
	}
}
