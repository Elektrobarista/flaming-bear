import java.io.IOException;
import java.io.Reader;
/**
 * A reader to read encoded messages.
 * @author Nina
 *
 */
public class CaesarReader extends java.io.Reader{
	
	/**
	 * The reader this reader is wrapped around.
	 */
	private Reader base;
	
	/**
	 * The en-/decoder for this class.
	 */
	private CaesarCipher caesar;

	/**
	 * Creates a new CaesarReader.
	 * @param base The reader this new reader will be wrapped around.
	 * @param caesar The encoder/decoder to be used by this reader.
	 */
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
