//package exerciseSheet04.exercise01;

import java.awt.Graphics;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PolygonViewer extends JPanel{
	
	PolygonReader pr;
	ArrayList<Point> points;
	
	/**
	 * Initializes the polygon viewer and reads out all polygons from the given file.
	 * @param polyFile
	 * @throws FileNotFoundException
	 */
	public PolygonViewer(String polyFile) throws FileNotFoundException{
		pr = new PolygonReader(polyFile);
		points = new ArrayList<Point>();
		while(pr.next() == true) {
			points.add(pr.get());
		}
		
		
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		Point point = null;
		Point oldPoint = null;
		for(int i = 0; i < points.size(); i++) {
			oldPoint = point;
			point = points.get(i);
			if (oldPoint!= null && point!= null) 
				g.drawLine(oldPoint.x, oldPoint.y, point.x, point.y);
		}	
	}
	
	/**
	 * Tests the PolygonViewer.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		JFrame f = new JFrame("Polygon Viewer");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300, 300);
		PolygonViewer pv = new PolygonViewer("src/shape1.pol");
//		PolygonViewer pv = new PolygonViewer(args[0]);
		f.add(pv);
		f.setVisible(true);
	}
	

}
