
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
			throw new NoPhoneNumberException();
		}
		// Die Exception wird aufgefangen und eine Fehlermeldung wird als String zur�ckgegeben.
		catch (NoPhoneNumberException ex){
			return "NoPhoneNumberException:Keine gueltige Telephonnummer";
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
			throw new NoEmailException() ;
		}
		// F�ngt die Excetion auf und gibt einen String zur�ck
		catch (NoEmailException ex) {
			return "NoEmailException:Keine gueltige Email eingegeben";
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
