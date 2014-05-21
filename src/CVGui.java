
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

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

import sun.applet.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

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
  
  //Color and Theme
  String cvColor = "blue";
  String cvTheme = "classic";
  
  //class variables
  ImageIcon addPicture;
  JButton addPic;
  JButton addSection;
  JButton cvProperty;
  JButton load;
  JButton create;
  JButton save;
  JPanel contactdetails;
  JRadioButton radioButtonRed;
  JRadioButton radioButtonBlue;
  JRadioButton radioButtonGreen;
  JRadioButton radioButtonOrange;
  JRadioButton radioButtonClassic;
  JRadioButton radioButtonOldstyle;
  JRadioButton radioButtonCasual;
  JRadioButton radioButtonEmpty;
  JTextField sectionName;
  JComboBox sections;
  JRadioButton cvEntry;
  JRadioButton cvLine;
  JTextField[] cvSectionContent = new JTextField[6];
  JTextArea sectionEntry;
  Boolean cvLineChoosen;
  String picture = "";
  
  //Write Cv
  public void writeCV(){
	  	this.cv.personalData[0] = this.firstname.getText();
	  	this.cv.personalData[1] = this.lastname.getText();
	  	this.cv.personalData[2] = this.picture;
	  	this.cv.adress[0] = this.street.getText()+" "+this.number.getText();
	  	this.cv.adress[1] = this.postcode.getText()+" "+ this.city.getText();
	  	this.cv.phoneNumber = this.phone.getText();
	  	this.cv.email = this.email.getText();
	  	this.cv.theme.setColor(this.cvColor);
	  	this.cv.theme.setStyle(this.cvTheme);
	 
	  	JFileChooser chooser = new JFileChooser();
	  	 chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	       int returnVal = chooser.showSaveDialog(this);
	       if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	   this.cv.writeCV(chooser.getSelectedFile().toString()+"\\"+this.cv.personalData[1]+"_"+this.cv.personalData[0]+".tex"); 
	       }
	       File picture = new File(this.cv.personalData[2]);
	       File newpicture = new File(chooser.getSelectedFile().toString()+"\\"+picture.getName());
	       try {
			newpicture.createNewFile();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	       if (picture.exists()== true){
	    	   FileChannel inChannel = null; 
	           FileChannel outChannel = null; 
	           try { 
	               inChannel = new FileInputStream(picture).getChannel(); 
	               outChannel = new FileOutputStream(newpicture).getChannel(); 
	               inChannel.transferTo(0, inChannel.size(), outChannel); 
	           } catch (IOException e) { 
	               try {
					throw e;
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
	           } finally { 
	               try { 
	                   if (inChannel != null) 
	                       inChannel.close(); 
	                   if (outChannel != null) 
	                       outChannel.close(); 
	               } catch (IOException e) {} 
	           } 
	       }
	       try {
	           Runtime runtime = Runtime.getRuntime();
	   
	           // Erste Shell oeffnen...
	           // In dieser Instanz wird schon in das
	           // Laufwerk:\Verzeichnis gewechselt,
	           // jedoch kein neues Fenster geoeffnet.
	           // Daher wird aus dieser Instanz spaeter noch einmal
	           // eine weitere Shell mit "start" aufgerufen, die
	           // sich dann schon im richtigen Verzeichnis befindet.
	           Process process = runtime.exec("cmd.exe /K"); 
	           OutputStream os = process.getOutputStream();
	           OutputStreamWriter ow = new OutputStreamWriter(os);
	           BufferedWriter bw = new BufferedWriter(ow);
	   
	           // Wechel des Laufwerks
	           bw.write("c:");
	           bw.newLine();
	           // Verzeichnis wechseln
	           bw.write("cd "+chooser.getSelectedFile().toString());
	           bw.newLine();
	           System.out.println("pdflatex \""+this.cv.personalData[1]+"_"+this.cv.personalData[0]+".tex\"");
	           bw.write("pdflatex \""+chooser.getSelectedFile().toString()+"\\"+this.cv.personalData[1]+"_"+this.cv.personalData[0]+".tex\""); 
	           bw.newLine();
	           bw.write(chooser.getSelectedFile().toString()+"\\"+this.cv.personalData[1]+"_"+this.cv.personalData[0]+".pdf"); 
	           bw.newLine();
	   
	           // Hier machen weitere Anweisungen keinen Sinn, da diese in der
	           // ersten (unsichtbaren) Instanz der Shell ausgeführt werden wuerden.
	   
	           bw.flush();
	           bw.close();
	           ow.close();
	           os.close();
	   
	        } catch (IOException ex) {
	           Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	        }
	  	
  }
  public void loadCV(){
	  JFileChooser chooser = new JFileChooser();
	//only cv-files selectable
      FileNameExtensionFilter filter = new FileNameExtensionFilter("CV-Save", "cv");
      chooser.setFileFilter(filter);
      int returnVal = chooser.showOpenDialog(this);
      if(returnVal == JFileChooser.APPROVE_OPTION) {
    	  this.cv.loadCV(chooser.getSelectedFile().toString());  
      }
      this.firstname.setText(this.cv.personalData[0]);
	  this.lastname.setText(this.cv.personalData[1]);
	  this.picture=this.cv.personalData[2];
	  System.out.println(this.picture);
	  ImageIcon newIcon = new ImageIcon(this.picture);
	  Image img = newIcon.getImage().getScaledInstance(137,177,java.awt.Image.SCALE_SMOOTH);
	  this.addPicture=new ImageIcon(img); 
	  this.addPic.setText("");
	  this.addPic.setIcon(this.addPicture);
	  this.street.setText(this.cv.adress[0]);
	  this.number.setText(this.cv.adress[0]);
	  this.postcode.setText(this.cv.adress[1]);
	  this.city.setText(this.cv.adress[1]);
	  this.phone.setText(this.cv.phoneNumber);
	  this.email.setText(this.cv.email);
	  this.sections.removeAllItems();
	  for(int i = 0; i<this.cv.exsistingSections;i++){
		  this.sections.addItem(this.cv.sections.get(i).getName());
	  }
	  switch(this.cv.theme.getColor()){
	  	case "orange":
	  		this.radioButtonOrange.setSelected(true);
	  		this.cvColor="orange";
	  		break;
	  	case "blue":
	  		this.radioButtonBlue.setSelected(true);
	  		this.cvColor="blue";
	  		break;
	  	case "red":
	  		this.radioButtonRed.setSelected(true);
	  		this.cvColor="red";
	  		break;
	  	case "green":
	  		this.radioButtonGreen.setSelected(true);
	  		this.cvColor="green";
	  		break;
	  };
	  switch(this.cv.theme.getStyle()){
	  	case "classic":
	  		this.radioButtonClassic.setSelected(true);
	  		this.cvTheme="classic";
	  		break;
	  	case "casual":
	  		this.radioButtonCasual.setSelected(true);
	  		this.cvTheme="casual";
	  		break;
	  	case "oldstyle":
	  		this.radioButtonOldstyle.setSelected(true);
	  		this.cvTheme="oldstyle";
	  		break;
	  	case "empty":
	  		this.radioButtonEmpty.setSelected(true);
	  		this.cvTheme="empty";
	  		break;
	  };
	  
      
  }
  
  //SaveCV
  public void saveCV(){
	  	this.cv.personalData[0] = this.firstname.getText();
	  	this.cv.personalData[1] = this.lastname.getText();
	  	this.cv.personalData[2] = this.picture;
	  	this.cv.adress[0] = this.street.getText()+" "+this.number.getText();
	  	this.cv.adress[1] = this.postcode.getText()+" "+ this.city.getText();
	  	this.cv.phoneNumber = this.phone.getText();
	  	this.cv.email = this.email.getText();
	  	this.cv.theme.setColor(this.cvColor);
	  	this.cv.theme.setStyle(this.cvTheme);
	  	 JFileChooser chooser = new JFileChooser();
	  	 chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	       int returnVal = chooser.showSaveDialog(this);
	       if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	   this.cv.saveCV(chooser.getSelectedFile().toString()+"\\"+this.cv.personalData[1]+".cv"); 
	       }
  }
  
  // set picture
  public void getPicture(){
	  JFileChooser chooser = new JFileChooser();
      //only jpg-files selectable
      FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg", "JPG");
      chooser.setFileFilter(filter);
      
      

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
    this.save = new JButton("save");
    this.save.addActionListener(this);
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
    this.contactdetails.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints(); //container for GridBagLayout in tab contactdetails
    c.fill = GridBagConstraints.HORIZONTAL;
    jtp.addTab("Contact Details",contactdetails);
    JPanel cvPreferences=new JPanel(new GridLayout(2,2));
    jtp.addTab("Preferences",cvPreferences);
    JPanel cvContent=new JPanel(new GridBagLayout());
    GridBagConstraints d = new GridBagConstraints();
    jtp.addTab("Content",cvContent);
    d.fill = GridBagConstraints.ABOVE_BASELINE_LEADING;
//    d.insets =  new Insets(0,40,40,0);
    
    //ContactDetails
    //TextFields for name, address and email
    this.firstname=new JTextField("First name");
    c.weightx = 0.1;
    c.gridx = 0;
    c.gridy = 0;
    contactdetails.add(firstname, c);
    this.lastname=new JTextField("Last name");
    c.weightx = 0.1;
    c.gridx = 1;
    c.gridy = 0;
    contactdetails.add(lastname, c);
    this.street=new JTextField("Street");
    c.weightx = 0.1;
    c.gridx = 0;
    c.gridy = 1;
    contactdetails.add(street, c);
    this.number=new JTextField("No");
    c.weightx = 0.1;
    c.gridx = 1;
    c.gridy = 1;
    contactdetails.add(number, c);
    this.postcode=new JTextField("Post code");
    c.weightx = 0.1;
    c.gridx = 0;
    c.gridy = 2;
    contactdetails.add(postcode, c);
    this.city=new JTextField("City");
    c.weightx = 0.1;
    c.gridx = 1;
    c.gridy = 2;
    contactdetails.add(city, c);
    this.phone=new JTextField("Phone");
    c.weightx = 0.1;
    c.gridx = 0;
    c.gridy = 3;
    contactdetails.add(phone, c);
    this.email=new JTextField("Email");
    c.weightx = 0.1;
    c.gridx = 1;
    c.gridy = 3;
    contactdetails.add(email, c);
    // add Button to load picture
    this.addPic=new JButton("Add Picture",this.addPicture);
    this.addPic.setSize(137,177);
    c.weightx = 0.1;
    c.gridx = 1;
    c.gridy = 4;
    contactdetails.add(this.addPic,c);
    this.addPic.addActionListener(this);
    
    //CvPreferences
    
    //Color
    JLabel color = new JLabel("CV Modern Color:");
    this.radioButtonOrange = new JRadioButton("Orange");
    Color colorOrange = new Color((float)0.95,(float)0.55,(float)0.15);
    this.radioButtonOrange.setForeground(colorOrange);
    this.radioButtonGreen = new JRadioButton("Green");
    Color colorGreen = new Color((float)0.35,(float)0.70,(float)0.30);
    this.radioButtonGreen.setForeground(colorGreen);
    this.radioButtonBlue = new JRadioButton("Blue");
    Color colorBlue = new Color((float)0.22,(float)0.45,(float)0.70);
    this.radioButtonBlue.setSelected(true);
    this.radioButtonBlue.setForeground(colorBlue);
    this.radioButtonRed = new JRadioButton("Red");
    Color colorRed = new Color((float)0.95,(float)0.20,(float)0.20);
    this.radioButtonRed.setForeground(colorRed);
    //color Actionlistner
    this.radioButtonOrange.addActionListener(this);
    this.radioButtonBlue.addActionListener(this);
    this.radioButtonRed.addActionListener(this);
    this.radioButtonGreen.addActionListener(this);
    
    //Theme
    JLabel theme = new JLabel("CV Modern Theme:");
    this.radioButtonClassic = new JRadioButton ("Classic");
    this.radioButtonClassic.setSelected(true);
    this.radioButtonCasual = new JRadioButton ("Casual");
    this.radioButtonOldstyle = new JRadioButton ("Oldstyle");
    this.radioButtonEmpty = new JRadioButton ("Empty");
    //Actionlistener Theme
    
    this.radioButtonClassic.addActionListener(this);
    this.radioButtonCasual.addActionListener(this);
    this.radioButtonOldstyle.addActionListener(this);
    this.radioButtonEmpty.addActionListener(this);
    
    ButtonGroup colorGroup = new ButtonGroup();
    colorGroup.add(this.radioButtonGreen);
    colorGroup.add(this.radioButtonBlue);
    colorGroup.add(this.radioButtonRed);
    colorGroup.add(this.radioButtonOrange);
    
    ButtonGroup themeGroup = new ButtonGroup();
    themeGroup.add(this.radioButtonClassic);
    themeGroup.add(this.radioButtonCasual);
    themeGroup.add(this.radioButtonOldstyle);
    themeGroup.add(this.radioButtonEmpty);
    
    cvPreferences.add(color);
    cvPreferences.add(this.radioButtonOrange);
    cvPreferences.add(this.radioButtonGreen);
    cvPreferences.add(this.radioButtonBlue);
    cvPreferences.add(this.radioButtonRed);
    cvPreferences.add(theme);
    cvPreferences.add(this.radioButtonClassic);
    cvPreferences.add(this.radioButtonCasual);
    cvPreferences.add(this.radioButtonOldstyle);
    cvPreferences.add(this.radioButtonEmpty);
   
   //CvContent
   this.sectionName = new JTextField("New Section Name");
   this.addSection = new JButton("AddSection");
   this.addSection.addActionListener(this);
   this.sections = new JComboBox();
   this.sections.addActionListener(this);
   this.cvLine = new JRadioButton("CVLine");
   this.cvEntry = new JRadioButton("CVEntry");
   this.sectionEntry = new JTextArea("");
   
   
   d.gridx = 1;
   d.gridy = 0;
   d.gridwidth = 2;
   sectionName.setPreferredSize(new Dimension(180,30));
   cvContent.add(this.sectionName,d);
   d.gridx = 3;
   d.gridy = 0;
   d.gridwidth = 3;
   cvContent.add(this.addSection,d);
   d.gridx = 0;
   d.gridy = 0;
   d.gridwidth = 1;
   cvContent.add(this.sections,d); 
   ButtonGroup entry = new ButtonGroup();
   entry.add(this.cvLine);
   entry.add(this.cvEntry);
   this.cvLine.addActionListener(this);
   this.cvEntry.addActionListener(this);
   d.gridx = 0;
   d.gridy = 1;
   d.gridwidth = 3;
   cvContent.add(this.cvEntry,d); 
   d.gridx = 3;
   d.gridy = 1;
   d.gridwidth = 3;
   cvContent.add(this.cvLine,d); 
  for (int i = 0 ; i<6; i++){
	   this.cvSectionContent[i] = new JTextField((i+1)+".Entry");
	   d.gridx = i;
	   d.gridy = 2;
	   d.gridwidth = 1;
	   d.ipadx = 60;
	   cvContent.add(cvSectionContent[i],d);
   }
  this.cvProperty = new JButton("CVProperty");
  this.cvProperty.addActionListener(this);
  d.ipadx = 0;
  d.gridx = 4;
  d.gridy = 3;
  d.gridwidth = 2;
  cvContent.add(this.cvProperty,d);
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
			this.cv.exsistingSections++;
			
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
		//action from Button to add content.
		if (arg0.getSource() == this.cvProperty){
			//write CVLine in section
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
			//save CvEntry in section
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
			if (this.sections.getSelectedIndex()!= -1)
			if (this.cv.sections.get(this.sections.getSelectedIndex()) != null){
				
			
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
		if(arg0.getSource() == this.radioButtonOrange){
			this.cvColor = "orange";
		}
		if(arg0.getSource() == this.radioButtonRed){
			this.cvColor = "red";
		}
		if(arg0.getSource() == this.radioButtonGreen){
			this.cvColor = "green";
		}
		if(arg0.getSource() == this.radioButtonBlue){
			this.cvColor = "blue";
		}
		if(arg0.getSource() == this.radioButtonClassic){
			this.cvTheme = "classic";
		}
		if(arg0.getSource() == this.radioButtonCasual){
			this.cvTheme = "casual";
		}
		if(arg0.getSource() == this.radioButtonOldstyle){
			this.cvTheme = "oldstyle";
		}
		if(arg0.getSource() == this.radioButtonEmpty){
			this.cvTheme = "empty";
		}
		if(arg0.getSource()== this.load){
			this.loadCV();
		}
		if(arg0.getSource()==this.save){
			this.saveCV();
		}
	}	
  
  
}
