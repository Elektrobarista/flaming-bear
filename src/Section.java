public class Section {
	private StringBuilder content = new StringBuilder("");
	public Section(String name){
		content.append("\\section{" + name + "}");
	}
	
	public StringBuilder getContent() {
		return content;
	}
	
	public void setContent(StringBuilder content) {
		this.content = content;
	}
	
	public void addCVLine(String val1, String val2)throws IllegalArgumentException{
			if (!val2.equals("")){
				content.append("\n\\cvline{" + val1 + "}" + "{" + val2 + "}");
			}
			else{
				throw new IllegalArgumentException("Der zweite String ist leer");
			}
		
	}
	public void addCVEntry(String... vals){
		/* Wahrscheinlich mit einer for-each Schleife
		 * zu lösen. Erst prüfen ob leer, dann auf die
		 * ersten beiden Strings testen. Ist das alles
		 * ok, mit einer for-each Schleife dem StringBuilder
		 * hinzufügen.
		 */
		
	}
	

}
