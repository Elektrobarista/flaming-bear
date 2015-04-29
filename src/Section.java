public class Section {
	private StringBuilder content = new StringBuilder("");
	public Section(String name){
		content.append("\\section{" + name + "}");
	}
	
	public StringBuilder getContent() {
		return content;
	}
	
	public void setContent(StringBuilder content) {							//Keine Ahnung, ob man das braucht. habe mal gelernt, dass man Getter und Setter 
		this.content = content;                                            //automatisch anlegen soll, sobald die Variable "privat ist. Der Getter wird mit der Methode
	}                                                                     //toString aber sowieso mehr oder weniger ersetzt und wie sinnvoll hier ein Setter ist, ist auch fraglich
	
	public void addCVLine(String val1, String val2)throws IllegalArgumentException{
			if (!val2.equals("")){
				content.append("\n\\cvline{" + val1 + "}" + "{" + val2 + "}");
			}
			else{
				throw new IllegalArgumentException("Der zweite String ist leer");
			}
		
	}
	public void addCVEntry(String... vals)throws IllegalArgumentException{
		if (vals.length <= 6 && (!vals[0].equals("") && !vals[1].equals(""))){ //Überprüfung, ob weniger als 6 Argumente vorhanden sind und die ersten beiden NICHT leer sind
			content.append("\n\\cventry");
			for (String s: vals) {		    								  //For-Each Schleife, die alle Elemente der Reihe nach iteriert und dem String "content" anfügt
				content.append("{" + s + "}"); 
			}
		}
		else{
			throw new IllegalArgumentException("Erste zwei Argumente sind leer, oder mehr als 6 Argumente");
		}		
	}
	public String toString(){
		return content.toString();
	}
	

}
