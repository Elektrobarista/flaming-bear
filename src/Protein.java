import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Protein {
	String id;
	String name;
	String sequence;
	Set<ProteinDomain> domains;
	
	public Protein(String id, String name, String sequence){
		this.id = id;
		this.name = name;
		this.sequence = sequence;
		this.domains = new TreeSet<ProteinDomain>(new pdComp());
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
		return domains;
	}
	
	public void addProteinDomain(ProteinDomain pd){
		domains.add(pd);
	}
	
	public void print(){
		System.out.println("=== " + name + " ===");
		System.out.println("* ID: " + id);
		System.out.println("* Sequence length: " + sequence.length());
		System.out.println("* Associated domains: " + domains.size());
		
		Iterator<ProteinDomain> it = domains.iterator();
		ProteinDomain temp;
		while (it.hasNext()){
			temp = it.next();
			System.out.println("\t" + temp.getStart() + "\t" + temp.getEnd() + "\t" + temp.getDomain().id + "\t" + temp.getDomain().name);
		}
	}
}
