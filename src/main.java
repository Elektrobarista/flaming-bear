public class main {

	public static void main(String[] args) {
		CurriculumVitae kermit = new CurriculumVitae();
		kermit.personalData[0] = "Kermit der";
		kermit.personalData[1] = "Frosch";
		kermit.personalData[2] = "C:\Users\Alex\Downloads\kermit.jpg";
		kermit.phoneNumber = "+78 787 8787";
		kermit.email = "kermit@frosch.de";
		kermit.adress[0] ="Sesamstraﬂe 1";
		kermit.adress[1] ="123 Irgendwo";
		kermit.education[0][0] = "2000-2001";
		kermit.education[0][1] = "Uni Mainz";
		kermit.education[0][2] = "Informatik";
		kermit.education[0][3] = "";
		kermit.education[0][4] = "";
		kermit.education[0][5] = "";
		kermit.education[1][0] = "Vorher";
		kermit.education[1][1] = "Schule";
		kermit.education[1][2] = "";
		kermit.education[1][3] = "";
		kermit.education[1][4] = "";
		kermit.education[1][5] = "";
		
		kermit.writeCV("C:\\Users\\Alex\\neu\\test3.tex");
	}

}

