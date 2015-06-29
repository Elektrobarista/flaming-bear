
public class ProteinDomain {
	private int start;
	private int end;
	Protein pro;
	Domain dom;
	
	public ProteinDomain(Protein protein, Domain domain, int start, int end){
		this.start = start;
		this.end = end;
		this.pro = protein;
		this.dom = domain;
	}
	
	public Protein getProtein(){
		return pro;
	}
	
	public Domain getDomain(){
		return dom;
	}
	
	public int getStart(){
		return this.start;
	}
	
	public int getEnd(){
		return this.end;
	}
}