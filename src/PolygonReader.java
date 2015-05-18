//package exerciseSheet04.exercise01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.awt.Point;

/**
 * reads in polygon files and return the vertices
 * @author Chrisi#
 * 
 */
public class PolygonReader {
	
	StreamTokenizer st;
	
	int lastLine;
	
	/**
	 * Initializes the stream tokenizer.
	 * @param polyFile The file containing the polygons
	 * @throws FileNotFoundException
	 */
	public PolygonReader(String polyFile) throws FileNotFoundException{
		
		st = new StreamTokenizer(new FileReader(polyFile));
		st.parseNumbers();
		lastLine = 0;
		
	}
	
	/**
	 * Returns true if there are more vertices to come.
	 * Returns false if end of polygon file has been reached.
	 * @return
	 */
	public boolean next() {
		int val;
		try {
			val = st.nextToken();
		} catch (IOException e) {
			throw new InvalidPolygonException("Connection to file corrupted!", e);
		}
		st.pushBack(); // if not the end, we still want to get the next value correctly
		if (val == StreamTokenizer.TT_EOF)
			return false;
		return true;
	}
	
	/**
	 * Reads in the next vertex of the polygon and returns it.
	 * @return
	 */
	public Point get() {
		try {
			st.nextToken(); // see if we skipped a line
			if (lastLine + 1 < st.lineno()) {
				st.pushBack(); // don't take the next value
				lastLine = st.lineno();
				return null;
			}
			// get the coordinates
			int x = (int)st.nval;
			lastLine = st.lineno();
			st.nextToken();
			int y = (int)st.nval;
			if (lastLine != st.lineno()) // check that x and y were in the same line
				throw new InvalidPolygonException("Something's wrong with the polygon file!");
			return new Point(x,y);
		} catch (IOException e) {
			throw new InvalidPolygonException("Connection to file corrupted!", e);
		}
	}


}
