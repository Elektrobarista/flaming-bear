public class main {

	public static void main(String[] args) {
		String s = "Test für außerordentliche Fehler, die ärgerlich enden können. Österreich, Überhaupt Ängste";
		CurriculumVitae test = new CurriculumVitae();
		System.out.println (test.writeEmailLine("lars.porth@gmail.com"));
		System.out.println (test.writeEmailLine("larsporthgmailcom")  );
		System.out.println (test.writeMobileLine("lars.porth@gmail.com"));
		System.out.println (test.writeMobileLine("+49 143 229"));
		System.out.println (test.writeCVLine("lars.porth@gmail.com",""));
		System.out.println (test.writeCVLine("lars.porth@gmail.com","123"));
		System.out.println (test.writeCVLine("","123"));
		System.out.println (test.createCVEntry("lol","123","as","","",""));
		System.out.println (test.convertUmlaut("123äwdsö323ü442ß"));
		test.writeCV("C:\\Users\\Lars\\test.tex");
		System.out.println(test.convertUmlaut(s));
		CurriculumVitae maxMustermann = new CurriculumVitae();
		maxMustermann.writeCV("C:\\Users\\Lars\\test.tex");
	}

}

