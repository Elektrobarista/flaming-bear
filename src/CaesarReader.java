import java.io.IOException;
import java.io.Reader;

public class CaesarReader extends java.io.Reader{
	private Reader base;
	private CaesarCipher caesar;

	public CaesarReader(Reader base, CaesarCipher caesar){
		this.base = base;
		this.caesar = caesar;	
	}
	
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
