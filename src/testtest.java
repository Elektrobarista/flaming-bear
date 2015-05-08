
public class testtest {
	static char[] Gross = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	static char[] Klein = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};


	public static void main(String[] args) {
		CaesarCipher c = new CaesarCipher(2);
		for (int i=0; i<26; i++){
//		System.out.println(c.encode(Gross[i]));
//		System.out.println(c.encode(Klein[i]));
		System.out.println(c.decode(Gross[i]));
		System.out.println(c.decode(Klein[i]));
		}
	}

		
}
