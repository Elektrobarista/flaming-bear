import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * 
 */
public class CVGui extends JFrame {
	
	//create new CurriculumVitae object
	CurriculumVitae cv = new CurriculumVitae();
	
	public CVGui(){
		
		super("Curriculum Vitae"); //set name for GUI-Window
		
		this.setSize(640, 480); // set frame size
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = new JPanel();  // create new JPanel
		mainPanel.setLayout(new BorderLayout());  // mainPanel uses Borderlayout
		this.setContentPane(mainPanel);  //mainPanel set as ContentPane
		
		//create buttons
		JButton load = new JButton("load");
		JButton save = new JButton("save");
		JButton create = new JButton("create");
		
		//new Panel with 3 buttons
		JPanel lsc = new JPanel();
		lsc.add(load);
		lsc.add(save);
		lsc.add(create);
		mainPanel.add(lsc, BorderLayout.SOUTH); // Panel "lsc" at the bottom of mainPanel
		
		//new Panel for tabs
		JTabbedPane jtp = new JTabbedPane();
		mainPanel.add(jtp, BorderLayout.CENTER); //locate "jtp" in center of mainPanel
	}
	

}
