import java.io.IOException;
import java.io.Reader;
/**
 * 
 * @author Nina
 *
 */
public class CaesarReader extends java.io.Reader{
	private Reader base;
	private CaesarCipher caesar;

	public CaesarReader(Reader base, CaesarCipher caesar){
		this.base = base;
		this.caesar = caesar;	
	}
	
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		if(cbuf == null || off >= cbuf.length || off+len > cbuf.length){
			throw new IOException("IO-Error");
		}
		char[] inp = new char[len];
		int erg = base.read(inp, 0, len);
		for(int i=0; i<len; i++){
			cbuf[i+off] = caesar.decode(inp[i]);
		}
		return erg;
	}
	
	@Override
	public void close() throws IOException {
		base.close();	
	}
}
