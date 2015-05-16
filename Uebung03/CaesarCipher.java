/**
 * A class to encode and decode single characters. *
 */
public class CaesarCipher {
	
	/**
	 * The offset for encryption.
	 */
	private int offset; 
	
	/**
	 * Creates a new CaesarCipher instance.
	 * @param offset The offset for encryption.
	 */
	public CaesarCipher(int offset){
		this.offset= offset;
	}
	
	/**
	 * Encrypts a character.
	 * @param c The character to encrypt. 
	 * @return The encrypted character.
	 */
	public char encode(char c){
		char cipher = c;
		// uppercase letters
		if ((int)c>64 && (int)c<91){
			cipher = (char) (((c-65+offset)%26)+65);
		}
		// lowercase letters
		if ((int)c>96 && (int)c<123){
			cipher = (char) (((c-97+offset)%26)+97);
		}
		return cipher;
	}
	/**
	 * decrypts a character.
	 * @param c The character to encrypt. 
	 * @return The decrypted character.
	 */
	public char decode(char c){
		char text = c;
		// uppercase letters
		if ((int)c>64 && (int)c<91){
			if ((int) c - 65 - offset < 0){
				text = (char) (((c-65-offset)%26)+65+26);
			} else {
				text = (char) (((c-65-offset)%26)+65);
			}
		}
		// lowercase letters
		if ((int)c>96 && (int)c<123){
			if ((int) c - 97 - offset < 0){
				text = (char) (((c-97-offset)%26)+97+26);
			} else {
				text = (char) (((c-97-offset)%26)+97);
			}
		}
		return text;
	}

}
