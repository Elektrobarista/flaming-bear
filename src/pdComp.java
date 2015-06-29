import java.util.Comparator;

public class pdComp implements Comparator<ProteinDomain>{
	public int compare(ProteinDomain a, ProteinDomain b){
		if(a.getStart() != b.getStart()){
			return b.getStart()-a.getStart();
		} else {
			return b.getEnd()-a.getEnd();
		}
	}
}
