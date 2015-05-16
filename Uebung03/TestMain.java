
public class TestMain {

	public static void main(String[] args) {
		Section n = new Section("testname");
		n.addCVLine("test1","test2");
		//System.out.println(n.getContent());
		n.addCVEntry("t","g","h","q","j","k");
		//System.out.println(n.getContent());
		System.out.println(n.toString());
	}

}
