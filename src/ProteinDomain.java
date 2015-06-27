
public class ProteinDomain {
	private int start;
	private int end;
	
	public ProteinDomain(Protein protein, Domain domain, int start, int end){
		this.start = start;
		this.end = end;
	}
	
	public Protein getProtein(){
		return null;
	}
	
	public Domain getDomain(){
		return null;
	}
	
	public int getStart(){
		return this.start;
	}
	
	public int getEnd(){
		return this.end;
	}
}