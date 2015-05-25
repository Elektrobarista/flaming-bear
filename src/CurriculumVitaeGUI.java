import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class CurriculumVitaeGUI extends JFrame {
	
	JTabbedPane tabbedPane;
	JPanel buttonPanel;
	JButton saveButton;
	JButton loadButton;
	
	// general tab
	JPanel generalTab;
	JPanel image;
	JLabel firstNameLabel;
	JTextField firstNameText;
	JLabel lastNameLabel;
	JTextField lastNameText;
	JLabel titleLabel;
	JTextField titleText;
	JLabel selectFileLabel;
	JButton selectFileButton;
	JFileChooser selectFileChooser;
	JLabel selectStyleLabel;
	JComboBox<CurriculumVitae.Style> selectStyleBox;
	JLabel selectColorLabel;
	JComboBox<CurriculumVitae.Color> selectColorBox;
	GridBagLayout gblGeneral;
	
	// sections tab
	JPanel sectionsTab;
	
	public CurriculumVitaeGUI() {
		super("Curriculum Vitae");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildComponents();
		buildLayout();
	}
	
	public void save() {
		
	}
	
	public void load() {
		
	}
	
	public void choose() {
		
	}
	
	public static void main(String[] args) {
		CurriculumVitaeGUI gui = new CurriculumVitaeGUI();
		gui.setVisible(true);
	}
	
	private void buildComponents() {
		final CurriculumVitaeGUI that = this;
		tabbedPane = new JTabbedPane();
		generalTab = new JPanel();
		tabbedPane.addTab("General", generalTab);
		tabbedPane.addTab("Sections", sectionsTab);
		add(tabbedPane);
		buttonPanel = new JPanel();
		saveButton = new JButton(new AbstractAction("Save") {
			@Override
			public void actionPerformed(ActionEvent e) {
				that.save();
			}
		});
		buttonPanel.add(saveButton);
		loadButton = new JButton(new AbstractAction("Load") {
			@Override
			public void actionPerformed(ActionEvent e) {
				that.load();
			}
		});
		buttonPanel.add(loadButton);
		add(buttonPanel);
		
		// general
		image = new JPanel();
		firstNameLabel = new JLabel("First name");
		firstNameText = new JTextField("Kermit");
		lastNameLabel = new JLabel("Family name");
		lastNameText = new JTextField("der Frosch");
		titleLabel = new JLabel("Title line");
		titleText = new JTextField("Erster Auftritt...");
		selectFileLabel = new JLabel("Photo");
		selectFileButton = new JButton(new AbstractAction("select file") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				that.choose();
			}
		});
		selectFileChooser = new JFileChooser();
		selectFileChooser.setFileFilter(new FileNameExtensionFilter("Images", ".jpg", ".png"));
		selectStyleLabel = new JLabel("Style");
		selectStyleBox = new JComboBox<CurriculumVitae.Style>(CurriculumVitae.Style.values());
		selectColorLabel = new JLabel("Color scheme");
		selectColorBox = new JComboBox<CurriculumVitae.Color>(CurriculumVitae.Color.values());
		
		// sections
	}
	
	private void buildLayout() {
		setLayout(new GridLayout(2, 0));
		buttonPanel.setLayout(new GridLayout(0, 2));
		buildGeneralLayout();
		buildSectionsLayout();
		pack();
	}
		
	private void buildGeneralLayout() {
		gblGeneral = new GridBagLayout();
		generalTab.setLayout(gblGeneral);
		generalTab.add(image, new GridBagConstraints(
				0, 0, // position
				1, 6, // size
				0.0, 0.0, 
				GridBagConstraints.CENTER, // anchor
				GridBagConstraints.NONE, // fill
				new Insets(0, 0, 0, 0), // insets 
				0, 0) // padding
		);
		generalTab.add(firstNameLabel, new GridBagConstraints(
				1, 0, // position
				1, 1, // size
				0.0, 0.0, 
				GridBagConstraints.CENTER, // anchor
				GridBagConstraints.NONE, // fill
				new Insets(0, 0, 0, 0), // insets 
				0, 0) // padding
		);
		generalTab.add(firstNameText, new GridBagConstraints(
				2, 0, // position
				1, 1, // size
				0.0, 0.0, 
				GridBagConstraints.CENTER, // anchor
				GridBagConstraints.HORIZONTAL, // fill
				new Insets(0, 0, 0, 0), // insets 
				0, 0) // padding
		);
		generalTab.add(lastNameLabel, new GridBagConstraints(
				1, 1, // position
				1, 1, // size
				0.0, 0.0, 
				GridBagConstraints.CENTER, // anchor
				GridBagConstraints.NONE, // fill
				new Insets(0, 0, 0, 0), // insets 
				0, 0) // padding
		);
		generalTab.add(lastNameText, new GridBagConstraints(
				2, 1, // position
				1, 1, // size
				0.0, 0.0, 
				GridBagConstraints.CENTER, // anchor
				GridBagConstraints.HORIZONTAL, // fill
				new Insets(0, 0, 0, 0), // insets 
				0, 0) // padding
		);
		generalTab.add(titleLabel, new GridBagConstraints(
				1, 2, // position
				1, 1, // size
				0.0, 0.0, 
				GridBagConstraints.CENTER, // anchor
				GridBagConstraints.NONE, // fill
				new Insets(0, 0, 0, 0), // insets 
				0, 0) // padding
		);
		generalTab.add(titleText, new GridBagConstraints(
				2, 2, // position
				1, 1, // size
				0.0, 0.0, 
				GridBagConstraints.CENTER, // anchor
				GridBagConstraints.HORIZONTAL, // fill
				new Insets(0, 0, 0, 0), // insets 
				0, 0) // padding
		);
		generalTab.add(selectFileLabel, new GridBagConstraints(
				1, 3, // position
				1, 1, // size
				0.0, 0.0, 
				GridBagConstraints.CENTER, // anchor
				GridBagConstraints.NONE, // fill
				new Insets(0, 0, 0, 0), // insets 
				0, 0) // padding
		);
		generalTab.add(selectFileButton, new GridBagConstraints(
				2, 3, // position
				1, 1, // size
				0.0, 0.0, 
				GridBagConstraints.CENTER, // anchor
				GridBagConstraints.HORIZONTAL, // fill
				new Insets(0, 0, 0, 0), // insets 
				0, 0) // padding
		);
		generalTab.add(selectStyleLabel, new GridBagConstraints(
				1, 4, // position
				1, 1, // size
				0.0, 0.0, 
				GridBagConstraints.CENTER, // anchor
				GridBagConstraints.NONE, // fill
				new Insets(0, 0, 0, 0), // insets 
				0, 0) // padding
		);
		generalTab.add(selectStyleBox, new GridBagConstraints(
				2, 4, // position
				1, 1, // size
				0.0, 0.0, 
				GridBagConstraints.CENTER, // anchor
				GridBagConstraints.HORIZONTAL, // fill
				new Insets(0, 0, 0, 0), // insets 
				0, 0) // padding
		);
		generalTab.add(selectColorLabel, new GridBagConstraints(
				1, 5, // position
				1, 1, // size
				0.0, 0.0, 
				GridBagConstraints.CENTER, // anchor
				GridBagConstraints.NONE, // fill
				new Insets(0, 0, 0, 0), // insets 
				0, 0) // padding
		);
		generalTab.add(selectColorBox, new GridBagConstraints(
				2, 5, // position
				1, 1, // size
				0.0, 0.0, 
				GridBagConstraints.CENTER, // anchor
				GridBagConstraints.HORIZONTAL, // fill
				new Insets(0, 0, 0, 0), // insets 
				0, 0) // padding
		);
		
	}
	
	private void buildSectionsLayout() {
		
	}

}
