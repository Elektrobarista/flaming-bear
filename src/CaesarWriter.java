import java.io.IOException;
import java.io.Writer;
/**
 * A Writer to write encoded messages.
 * @author Nina
 *
 */
public class CaesarWriter extends java.io.Writer{
	
	/**
	 * The writer this writer is wrapped around.
	 */
	private Writer base;
	
	/**
	 * The en-/decoder for this class.
	 */
	private CaesarCipher caesar;
	
	/**
	 * Creates a new CaesarWriter.
	 * @param base The writer this new writer will be wrapped around.
	 * @param caesar The encoder/decoder to be used by this writer.
	 */
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