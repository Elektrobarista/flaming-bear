
public class main {

	public static void main(String[] args) {
		CurriculumVitae test = new CurriculumVitae();
		System.out.println (test.writeEMailLine("lars.porth@gmail.com"));
		System.out.println (test.writeEMailLine("larsporthgmailcom")  );
		System.out.println (test.writeMobileLine("lars.porth@gmail.com"));
		System.out.println (test.writeMobileLine("+49 143 229"));
		System.out.println (test.writeCVLine("lars.porth@gmail.com",""));
		System.out.println (test.writeCVLine("lars.porth@gmail.com","123"));
		System.out.println (test.writeCVLine("","123"));
		System.out.println (test.createCVEntry("lol","123","as","","",""));
		System.out.println (test.convertUmlaut("123äwdsö323ü442ß"));
		test.writeCV("C:\\Users\\Lars\\test.tex");
	}

}
