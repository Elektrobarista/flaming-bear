import java.io.IOException;
import java.io.StringWriter;
import java.io.StringReader;
/**
 * This class tests the implemented cipher algorithm.
 * @author Nina
 *
 */
public class CaesarMain {
	public static void main(String[] args) throws IOException {
		String test = "Hallo Welt!";
		System.out.println("Message: "+ test);
		
		int len = test.length();
		CaesarCipher c = new CaesarCipher(2);
		StringWriter w = new StringWriter();
		CaesarWriter cw = new CaesarWriter(w,c);
		cw.write(test,0,len);
		String cipher = w.toString();
		cw.close();
		System.out.println("Cipher: "+ cipher);
		
		CaesarReader cr = new CaesarReader(new StringReader(cipher), c);
		char[] plain = new char[len];
		cr.read(plain, 0, len);
		cr.close();
		System.out.println("Plain: "+ new String(plain));
	}
}
