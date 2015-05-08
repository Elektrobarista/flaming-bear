
public class CaesarCipher {
	private int offset;
	public CaesarCipher(int offset){
		this.offset= offset;
	}
	public char encode(char c){
		char cipher = c;
		if ((int)c>64 && (int)c<91){
			cipher = (char) (((c-65+offset)%26)+65);
		}
		if ((int)c>96 && (int)c<123){
			cipher = (char) (((c-97+offset)%26)+97);
		}
		return cipher;
	}
	public char decode(char c){
		char text = c;
		if ((int)c>64 && (int)c<91){
			if ((int) c - 65 - offset < 0){
				text = (char) (((c-65-offset)%26)+65+26);
			} else {
				text = (char) (((c-65-offset)%26)+65);
			}
		}
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
