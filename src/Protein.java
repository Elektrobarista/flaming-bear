import java.util.Set;


public class Protein {
	private String id;
	private String name;
	private String sequence;
	
	public Protein(String id, String name, String sequence){
		this.id = id;
		this.name = name;
		this.sequence = sequence;
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}

	public String getSequence(){
		return this.sequence;
	}
	
	public Set<ProteinDomain> getProteinDomains(){
		
		return null;
	}
	
	public void addProteinDomain(ProteinDomain pd){
		
	}
	
	public void print(){
		
	}
}
