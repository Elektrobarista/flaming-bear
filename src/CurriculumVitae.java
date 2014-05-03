
public class CurriculumVitae {
	// Tauscht alle umlaute gegen Latexkonforme COdierung um
	String convertUmlaut(){
		return null;
	}
	// Erzeugt einen String in dem Latex-Code für persönliche Daten steht. ( Name, Vorname, Bild)
	String createPersonalData(){
		return null;
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
			throw new NoPhoneNumberException();
		}
		// Die Exception wird aufgefangen und eine Fehlermeldung wird als String zurückgegeben.
		catch (NoPhoneNumberException ex){
			return "NoPhoneNumberException:Keine gueltige Telephonnummer";
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
			throw new NoEmailException() ;
		}
		// Fängt die Excetion auf und gibt einen String zurück
		catch (NoEmailException ex) {
			return "NoEmailException:Keine gueltige Email eingegeben";
		}
		// Ansonsten wird ein String der die Email Darstellung in Latex erzegen soll zurückgegeben.
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
