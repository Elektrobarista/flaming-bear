import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Domain {
	String id;
	String name;
	Set<ProteinDomain> proteins;
	
	public Domain(String id, String name){
		this.id = id;
		this.name = name;
		this.proteins = new TreeSet<ProteinDomain>(new pdComp());
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Set<ProteinDomain> getProteinDomain(){		
		return proteins;		
	}
	
	public void addProteinDomain(ProteinDomain pd){
		proteins.add(pd);
	}
	
	public void print(){
		System.out.println("=== " + id + " " + name + " ===");
		Iterator<ProteinDomain> it = proteins.iterator();
		ProteinDomain temp;
		while (it.hasNext()){
			temp = it.next();
			System.out.println( "\t" + temp.getProtein().id + "\t" + temp.getProtein().sequence);
		}
	}
}
