import java.io.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;


public class SecureOutputStream extends OutputStream {
	public static void main(String... args) {
	}
	OutputStream base;
	InputStream remote;
	Scanner in;
	PrintWriter out;
	BigInteger g, n, remotePublicKey, c, secret;
	Random m;
	
	public SecureOutputStream(OutputStream base, InputStream remote) {
		this.base = base;
		this.remote = remote;
		in = new Scanner(remote);
		out = new PrintWriter(base);
		g = in.nextBigInteger();
		n = in.nextBigInteger();
		c = new BigInteger(1024, new SecureRandom()).mod(n);
		out.println(g.modPow(c, n));
		remotePublicKey = in.nextBigInteger();
		flush();
		secret = remotePublicKey.modPow(c, n);
		m = new Random(secret.longValue());
	}

	@Override
	public void write(int b) throws IOException {
		base.write(b ^ m.nextInt(256));
	}
	
	@Override
	public void flush(){
		out.flush();
	}
	
	@Override
	public void close(){
		flush();
		in.close();
		out.close();
	}
}
