import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Database {	
	Scanner sc;
	TreeMap<String, Protein> prots;
	TreeMap<String, Domain> doms;
	TreeMap<String, String> nameToId;
	
	public Database() throws FileNotFoundException{
		prots = new TreeMap<String, Protein>();
		doms = new TreeMap<String, Domain>();
		nameToId = new TreeMap<String, String>();
		
		sc = new Scanner(new BufferedReader(new FileReader("proteins.tsv")));
		sc.nextLine();
		String tid;
		String tname;
		while( sc.hasNext()){
			tid = sc.next();
			tname = sc.next();
			prots.put(tid, new Protein(tid, tname, sc.next()));
			nameToId.put(tname, tid);
		}
		
		sc = new Scanner(new BufferedReader(new FileReader("domains.tsv")));
		sc.nextLine();
		while( sc.hasNext()){
			tid = sc.next();
			doms.put(tid, new Domain(tid, sc.next()));
		}
		
		sc = new Scanner(new BufferedReader(new FileReader("proteindomains.tsv")));
		sc.nextLine();
		Protein tPro;
		Domain tDom;
		ProteinDomain temp;
		while( sc.hasNext()){
			tPro = prots.get(sc.next());
			tDom = doms.get(sc.next());
			temp = new ProteinDomain(tPro, tDom, sc.nextInt(), sc.nextInt());
			tPro.domains.add(temp);
			tDom.proteins.add(temp);
		}
	}
	
	public Protein getProteinById(String id){
		return prots.get(id);
	}
	
	public Protein getProteinByName(String name){
		return prots.get(name);
	}
	
	public Domain getDomainById(String id){
		return doms.get(id);
	}
	
	public Set<Protein> getProteinsByDomainId(String domainId){
		return null;
	}	
}
