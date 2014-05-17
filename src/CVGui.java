import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 */
public class CVGui extends JFrame {
	
	CurriculumVitae cv = new CurriculumVitae();
	
	public CVGui(){
		super("Curriculum Vitae");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(640, 480);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		this.setContentPane(mainPanel);
		
		JButton load =new JButton("load");
		JButton save =new JButton("save");
		JButton create =new JButton("create");
		
		JPanel lsc = new JPanel();
		lsc.add(load);
		lsc.add(save);
		lsc.add(create);
		mainPanel.add(lsc, BorderLayout.SOUTH);
	}
	

}
