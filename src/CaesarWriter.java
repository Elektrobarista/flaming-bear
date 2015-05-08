import java.io.IOException;
import java.io.Writer;

public class CaesarWriter extends java.io.Writer{
	private Writer base;
	private CaesarCipher caesar;
	
	public CaesarWriter(Writer base, CaesarCipher caesar){
		this.base = base;
		this.caesar = caesar;
	}
	
	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flush() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}	
}
