import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    
    //new Panel contact details
    JPanel contactdetails=new JPanel();
    jtp.addTab("Contact Details",contactdetails);
    
    
    
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
    JButton addPic=new JButton("add Picture");
    //??
    addPic.setSize(137,177);
    contactdetails.add(addPic);
    addPic.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        JFileChooser chooser = new JFileChooser();
        //only jpg-files selectable
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg", "JPG");
        chooser.setFileFilter(filter);
        /*
                        //Soll auf Gui zugreifen v
        int returnVal = chooser.showOpenDialog(CVGui);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
          System.out.println("You chose to open this file: " +
          chooser.getSelectedFile().getName());  
        }*/
      }  
    })  ;
    
    
  }
}
