import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/*
 * Contains the sections and content of the Curriculum Vitae an provides the methods to fill the CV with content
 */
public class CurriculumVitae implements Serializable{
	
private static final long serialVersionUID = 1003450186326955000L;

private enum Color{Black,Grey,Orange,Purple,Red,Green,Blue};
private enum Style{Casual,Classic,Oldstyle,Banking};
private String firstName;
private String lastName;
private String style = new String( Style.Casual.toString().toLowerCase());
private String colorScheme = new String( Color.Black.toString().toLowerCase());;
private String layout = new String("geometry");
private String sectionCollection[];
private int sectionNumber;
private StringBuilder content = new StringBuilder("");


public CurriculumVitae(int sections){
	this.sectionNumber = sections;
	this.sectionCollection = new String[sections];
}


public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public void setStyle(String style) {
	this.style = style;
}

public void setColorScheme(String colorSheme) {
	this.colorScheme = colorSheme;
}

public void setLayout(String layout) {
	this.layout = layout;
}


public void setSection(int number, Section section){
	if(number <= sectionNumber && number  >= 0){
		this.sectionCollection[number] = section.toString();
	}
	
}
/**
 * Method to create CV
 * @return CV Content as String
 * @throws IncompleteCVException
 */
public String getCV() throws IncompleteCVException{
	if (!(style.equals("")) && !(colorScheme.equals("")) && !(layout.equals("")) ){
		content.append("\\documentclass[11pt, a4paper]{moderncv} \n\\moderncvtheme[" + colorScheme +"]" + "{" + style +"}");
		content.append("\n\\usepackage[german]{babel}\n\\usepackage[utf8]{inputenc}\n\\usepackage{" + layout + "}");
		content.append("\n\\firstname{" + firstName + "}" + "\n\\familyname{" + lastName + "}\n\\begin{document}\n\\makecvtitle");
		for(int i = 0; i <= sectionCollection.length - 1; i++){
			content.append(sectionCollection[i]);
		}
		content.append("\n\\end{document}");
		
	}
	else {
		throw new IncompleteCVException();
	}
	
	
	
	return content.toString();
}
/**
 * Saves the CV in compressed gzip-File
 * @param target takes a File 
 */
public void saveCV(File target){
	ObjectOutputStream out;
	try {
		out = new ObjectOutputStream(new GZIPOutputStream((new FileOutputStream(target))));	
		out.writeObject(this);	
		out.close();
	}
catch (FileNotFoundException e) {
	e.printStackTrace();
} catch (IOException e) {
	e.printStackTrace();
}
}
/**
 * Loads the CV out of an compressed .gz File
 * @param source takes a File
 * @return returns decompressed object of class CurriculumVitae
 */
public static CurriculumVitae loadCV(File source) {
	CurriculumVitae loaded = null;
	ObjectInputStream in;
	try {
		in= new ObjectInputStream(new GZIPInputStream((new FileInputStream(source))));
	    try {
			loaded = (CurriculumVitae)in.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    in.close();
		
	} catch (FileNotFoundException e) {	
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return loaded;
}
/**
 * writes the CV in a .tex-File an saves it
 * @param target takes file to save the CV in
 */
public void writeCV(File target){
	OutputStream output;
	try {
		output = new FileOutputStream(target);
		try {
			Writer out = new BufferedWriter(new OutputStreamWriter(output,"utf-8"));
			try {
				out.write(getCV());
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (IncompleteCVException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
}
}
