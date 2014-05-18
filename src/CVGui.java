import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * 
 */
public class CVGui extends JFrame {
  
  //create new CurriculumVitae object
  CurriculumVitae cv = new CurriculumVitae();
  ImageIcon addPicture;
  JButton addPic;
  JPanel contactdetails;
  
  
  // Setzt das Bild.
  public void getPicture(){
	  JFileChooser chooser = new JFileChooser();
      //only jpg-files selectable
      FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg", "JPG");
      chooser.setFileFilter(filter);
      
                      //Soll auf Gui zugreifen v
      int returnVal = chooser.showOpenDialog(this);
      if(returnVal == JFileChooser.APPROVE_OPTION) {
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
    
    //new Panel contact details
    this.contactdetails=new JPanel();
    jtp.addTab("Contact Details",contactdetails);
    JPanel cvPreferences=new JPanel();
    jtp.addTab("Contact Details",cvPreferences);
    JPanel cvContent=new JPanel();
    jtp.addTab("Contact Details",cvContent);
    
    
    
    
    //TextFields for name, address and email
    JTextField firstname=new JTextField("First name");
    JTextField lastname=new JTextField("Last name");
    JTextField street=new JTextField("Street");
    JTextField number=new JTextField("No");
    JTextField postcode=new JTextField("Post code");
    JTextField city=new JTextField("City");  
    JTextField phone=new JTextField("Phone"); 
    JTextField email=new JTextField("Email");
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
    addPic.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
    	  /*
        JFileChooser chooser = new JFileChooser();
        //only jpg-files selectable
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg", "JPG");
        chooser.setFileFilter(filter);
        
                        //Soll auf Gui zugreifen v
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
          System.out.println("You chose to open this file: " +
          chooser.getSelectedFile().getName());  
        }
        */
    	  getPicture();
      }
    })  ;
    
    
  }
}
