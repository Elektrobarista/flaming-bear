
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * 
 */
public class CVGui extends JFrame implements ActionListener{
  
  //create new CurriculumVitae object
  CurriculumVitae cv = new CurriculumVitae();
  
//TextFields for name, address and email
  JTextField firstname;
  JTextField lastname;
  JTextField street;
  JTextField number;
  JTextField postcode;
  JTextField city;  
  JTextField phone; 
  JTextField email;
  
  //Klassenvariablen
  ImageIcon addPicture;
  JButton addPic;
  JButton addSection;
  JButton cvProperty;
  JButton load;
  JButton create;
  JPanel contactdetails;
  JRadioButton radioButtonRed;
  JTextField sectionName;
  JComboBox sections;
  JRadioButton cvEntry;
  JRadioButton cvLine;
  JTextField[] cvSectionContent = new JTextField[6];
  JTextArea sectionEntry;
  Boolean cvLineChoosen;
  String picture;
  
  //
  public void writeCV(){
	  	/*this.cv.setFirstName(this.firstname.getText());
	  	this.cv.setLastName(this.lastname.getText());
	  	this.cv.setStreet(this.street.getText());
	  	this.cv.setStreetNumber(this.number.getText());
	  	this.cv.setPostalCode(this.postcode.getText());
	  	this.cv.setCity(this.city.getText());
	  	this.cv.setPhone(this.phone.getText());
	  	this.cv.setMobile(this.email.getText());
	  	this.cv.setPicture(this.picture);
	  	this.cv.writeCV("c:\\users\\lars\\test123.tex");
	  	*/
  }
  
  // Setzt das Bild.
  public void getPicture(){
	  JFileChooser chooser = new JFileChooser();
      //only jpg-files selectable
      FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg", "JPG");
      chooser.setFileFilter(filter);
      
                      //Soll auf Gui zugreifen v
      int returnVal = chooser.showOpenDialog(this);
      if(returnVal == JFileChooser.APPROVE_OPTION) {
    	  this.picture = chooser.getSelectedFile().toString();
    	  ImageIcon newIcon = new ImageIcon(chooser.getSelectedFile().toString());
    	  Image img = newIcon.getImage().getScaledInstance(137,177,java.awt.Image.SCALE_SMOOTH);
    	  this.addPicture=new ImageIcon(img); 
    	  this.addPic.setText("");
    	  this.addPic.setIcon(this.addPicture);
    	  
      }
     
  }
  
  public CVGui(){
    
    super("Curriculum Vitae"); //set name for GUI-Window
    
    this.setSize(640, 480); // set frame size
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel mainPanel = new JPanel();  // create new JPanel
    mainPanel.setLayout(new BorderLayout());  // mainPanel uses Borderlayout
    this.setContentPane(mainPanel);  //mainPanel set as ContentPane
    
    //create buttons
    this.load = new JButton("load");
    this.load.addActionListener(this);
    JButton save = new JButton("save");
    this.create = new JButton("create");
    this.create.addActionListener(this);
    
    //new Panel with 3 buttons
    JPanel lsc = new JPanel();
    lsc.add(load);
    lsc.add(save);
    lsc.add(create);
    mainPanel.add(lsc, BorderLayout.SOUTH); // Panel "lsc" at the bottom of mainPanel
    
    //new Panel for tabs
    JTabbedPane jtp = new JTabbedPane();
    mainPanel.add(jtp, BorderLayout.CENTER); //locate "jtp" in center of mainPanel
    
    //new Panel contact details
    this.contactdetails=new JPanel();
    jtp.addTab("Contact Details",contactdetails);
    JPanel cvPreferences=new JPanel();
    jtp.addTab("Preferences",cvPreferences);
    JPanel cvContent=new JPanel();
    jtp.addTab("Content",cvContent);
    
    
    
    //ContactDetails
    //TextFields for name, address and email
    this.firstname=new JTextField("First name");
    this.lastname=new JTextField("Last name");
    this.street=new JTextField("Street");
    this.number=new JTextField("No");
    this.postcode=new JTextField("Post code");
    this.city=new JTextField("City");  
    this.phone=new JTextField("Phone"); 
    this.email=new JTextField("Email");
    contactdetails.add(firstname);
    contactdetails.add(lastname);
    contactdetails.add(email);
    contactdetails.add(street);
    contactdetails.add(number);
    contactdetails.add(postcode);
    contactdetails.add(city);
    contactdetails.add(phone);
    contactdetails.add(email);
    // add Button to load picture
    this.addPic=new JButton("Add Picture",this.addPicture);
    //??
    this.addPic.setSize(137,177);
    contactdetails.add(this.addPic);
    this.addPic.addActionListener(this);
    
    //CvPreferences
    
    //Color
    JLabel color = new JLabel("CV Modern Color:");
    JRadioButton orange = new JRadioButton("Orange");
    Color colorOrange = new Color((float)0.95,(float)0.55,(float)0.15);
    orange.setForeground(colorOrange);
    JRadioButton green = new JRadioButton("Green");
    Color colorGreen = new Color((float)0.35,(float)0.70,(float)0.30);
    green.setForeground(colorGreen);
    JRadioButton blue = new JRadioButton("Blue");
    Color colorBlue = new Color((float)0.22,(float)0.45,(float)0.70);
    blue.setForeground(colorBlue);
    this.radioButtonRed = new JRadioButton("Red");
    Color colorRed = new Color((float)0.95,(float)0.20,(float)0.20);
    this.radioButtonRed.setForeground(colorRed);
    
    //Theme
    JLabel theme = new JLabel("CV Modern Theme:");
    JRadioButton classic = new JRadioButton ("Classic");
    JRadioButton casual = new JRadioButton ("Casual");
    JRadioButton oldstyle = new JRadioButton ("Oldstyle");
    JRadioButton empty = new JRadioButton ("Empty");
    
    ButtonGroup colorGroup = new ButtonGroup();
    colorGroup.add(green);
    colorGroup.add(blue);
    colorGroup.add(this.radioButtonRed);
    colorGroup.add(orange);
    
    ButtonGroup themeGroup = new ButtonGroup();
    themeGroup.add(classic);
    themeGroup.add(casual);
    themeGroup.add(oldstyle);
    themeGroup.add(empty);
    
    cvPreferences.add(color);
    cvPreferences.add(orange);
    cvPreferences.add(green);
    cvPreferences.add(blue);
    cvPreferences.add(this.radioButtonRed);
    cvPreferences.add(theme);
    cvPreferences.add(classic);
    cvPreferences.add(casual);
    cvPreferences.add(oldstyle);
    cvPreferences.add(empty);
   
   //CvContent
   this.sectionName = new JTextField("New Section Name");
   this.addSection = new JButton("AddSection");
   this.addSection.addActionListener(this);
   this.sections = new JComboBox();
   this.sections.addActionListener(this);
   this.cvLine = new JRadioButton("CVLine");
   this.cvEntry = new JRadioButton("CVEntry");
   this.sectionEntry = new JTextArea("");
   
   
   cvContent.add(this.sectionName);
   cvContent.add(this.addSection);
   cvContent.add(this.sections); 
   cvContent.add(this.cvLine); 
   ButtonGroup entry = new ButtonGroup();
   entry.add(this.cvLine);
   entry.add(this.cvEntry);
   this.cvLine.addActionListener(this);
   this.cvEntry.addActionListener(this);
   cvContent.add(this.cvEntry); 
  for (int i = 0 ; i<6; i++){
	   this.cvSectionContent[i] = new JTextField((i+1)+".Entry");
	   cvContent.add(cvSectionContent[i]);
   }
  this.cvProperty = new JButton("CVProperty");
  this.cvProperty.addActionListener(this);
  cvContent.add(this.cvProperty);
  cvContent.add(this.sectionEntry);

  }
    	
  //ActionEvents
  public	void	actionPerformed(ActionEvent	arg0)	{	
		//AddPicture
		if (arg0.getSource() == this.addPic){
			this.getPicture();
		}
		if (arg0.getSource() == this.addSection){
			this.cv.addSection(this.sectionName.getText());
			this.sections.addItem(this.sectionName.getText());
			
		}
		if (arg0.getSource() == this.cvLine ){
			this.cvLineChoosen = true;
			for(int i = 2; i <6; i++){
				this.cvSectionContent[i].setEnabled(false);
				this.cvSectionContent[i].setText("");
			}
		}
		if (arg0.getSource() == this.cvEntry ){
			this.cvLineChoosen = false;
			for(int i = 2; i <6; i++){
				this.cvSectionContent[i].setEnabled(true);
				this.cvSectionContent[i].setText((i+1)+".Entry");
			}
		}
		if (arg0.getSource() == this.cvProperty){
			if(this.cvLineChoosen == true){
				String[] entry = {this.cvSectionContent[0].getText(),this.cvSectionContent[1].getText()};
				CVLine cvProperty = new CVLine(entry);
				this.cv.sections.get(this.sections.getSelectedIndex()).addEntry(cvProperty);;
				String entrys = "";
				for (int i = 0; i < this.cv.sections.get(this.sections.getSelectedIndex()).getEntries().length; i++){
					if(this.cv.sections.get(this.sections.getSelectedIndex()).getEntries()[i] == null){
						break;
					}
					for(int j = 0 ;j<this.cv.sections.get(this.sections.getSelectedIndex()).getEntries()[i].getValues().length;j++){
						entrys = entrys + this.cv.sections.get(this.sections.getSelectedIndex()).getEntries()[i].getValues()[j]+" ";	
					}
					entrys = entrys + "\n"; 
				}
				this.sectionEntry.setText(entrys);
			}
			else{
				String[] entry = {this.cvSectionContent[0].getText(),this.cvSectionContent[1].getText(),this.cvSectionContent[2].getText(),this.cvSectionContent[3].getText(),this.cvSectionContent[4].getText(),this.cvSectionContent[5].getText()};
				CVEntry cvProperty = new CVEntry(entry);
				this.cv.sections.get(this.sections.getSelectedIndex()).addEntry(cvProperty);
				String entrys = "";
				for (int i = 0; i < this.cv.sections.get(this.sections.getSelectedIndex()).getEntries().length; i++){
					if(this.cv.sections.get(this.sections.getSelectedIndex()).getEntries()[i] == null){
						break;
					}
					for(int j = 0 ;j<this.cv.sections.get(this.sections.getSelectedIndex()).getEntries()[i].getValues().length;j++){
						entrys = entrys + this.cv.sections.get(this.sections.getSelectedIndex()).getEntries()[i].getValues()[j]+" ";	
					}
					entrys = entrys + "\n"; 
				}
				this.sectionEntry.setText(entrys);
			}
		}
		if(arg0.getSource()== this.sections){
			String entrys = "";
			if (this.cv.sections.get(this.sections.getSelectedIndex())!= null){
				
			
				for (int i = 0; i < this.cv.sections.get(this.sections.getSelectedIndex()).getEntries().length; i++){
					if(this.cv.sections.get(this.sections.getSelectedIndex()).getEntries()[i] == null){
						break;
					}
					for(int j = 0 ;j<this.cv.sections.get(this.sections.getSelectedIndex()).getEntries()[i].getValues().length;j++){
						entrys = entrys + this.cv.sections.get(this.sections.getSelectedIndex()).getEntries()[i].getValues()[j]+" ";	
					}
					entrys = entrys + "\n"; 
				}
			}	
			this.sectionEntry.setText(entrys);
		}
		if(arg0.getSource() == this.create ){
			this.writeCV();
		}
	}	
  
  
}
