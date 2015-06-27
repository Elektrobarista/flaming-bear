import java.util.Set;


public class Domain {
	private String id;
	private String name;
	
	public Domain(String id, String name){
		this.id = id;
		this.name = name;
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Set<ProteinDomain> getProteinDomain(){
		
		return null;		
	}
	
	public void addProteinDomain(ProteinDomain pd){
		
	}
	
	public void print(){
		
	}

}
