
public class main {

	public static void main(String[] args) {
		CurriculumVitae test = new CurriculumVitae();
		System.out.println (test.writeEMailLine("larsporth@gmail.com"));
		System.out.println (test.writeEMailLine("larsporthgmailcom")  );
		System.out.println (test.writeMobileLine("larsporth@gmail.com"));
		System.out.println (test.writeMobileLine("+49 143 229"));
		System.out.println (test.writeCVLine("larsporth@gmail.com",""));
		System.out.println (test.writeCVLine("larsporth@gmail.com","123"));
		System.out.println (test.writeCVLine("","123"));
		
		
	}

}
