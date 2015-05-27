import java.io.*;
import java.math.*;
import java.security.SecureRandom;
import java.util.*;


public class SecureInputStream extends InputStream {
	
	InputStream base;
	OutputStream remote;
	Scanner in;
	PrintWriter out;
	BigInteger g, n, remotePublicKey, c, secret;
	Random m;
	
	public SecureInputStream(InputStream base, OutputStream remote){
		this.base = base;
		this.remote = remote;
		in = new Scanner(base);
		out = new PrintWriter(remote);
		while (g==null || g.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) < 0)
			g = BigInteger.probablePrime(1024, new SecureRandom());
		while (n==null || n.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) < 0 || n.equals(g))
			n = BigInteger.probablePrime(1024, new SecureRandom());
		if (g.compareTo(n) > 0) {
			BigInteger s = n;
			n = g;
			g = s;
		}
		out.println(g);
		out.println(n);
		out.flush();
		
		c = new BigInteger(1024, new SecureRandom()).mod(n);
		out.println(g.modPow(c, n));
		out.flush();
		remotePublicKey = in.nextBigInteger();
		secret = remotePublicKey.modPow(c, n);
		m = new Random(secret.longValue());
	}
	
	@Override
	public int read() throws IOException {
		int d = base.read();
		if (d==-1) return -1;
		return d ^ m.nextInt(256);
	}
	
	@Override
	public void close(){
		in.close();
		out.close();
	}

}
