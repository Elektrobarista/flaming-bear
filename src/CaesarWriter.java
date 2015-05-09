import java.io.IOException;
import java.io.Writer;
/**
 * 
 * @author Nina
 *
 */
public class CaesarWriter extends java.io.Writer{
	private Writer base;
	private CaesarCipher caesar;
	
	public CaesarWriter(Writer base, CaesarCipher caesar){
		this.base = base;
		this.caesar = caesar;
	}
	
	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		if (cbuf==null || off >=cbuf.length || off+len>cbuf.length){
			throw new IOException("IO-Error");
		}
		char[] cipher = new char[len];
		for (int i=0; i<len; i++){
			cipher[i] = caesar.encode(cbuf[i+off]);
		}
		base.write(cipher);
	}

	@Override
	public void flush() throws IOException {
		base.flush();
	}

	@Override
	public void close() throws IOException {
		base.close();
	}	
}