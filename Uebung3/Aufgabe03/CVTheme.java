/*
 * Group 61
 * Einfuehrung in die Softwareentwicklung
 * Uebung 3
 * class to set moderncvtheme
 *
*/

public class CVTheme {
  enum Color{YELLOW,ORANGE,RED,GREEN,BLUE};
  enum Style{CASUAL,CLASSIC,EMPTY,OLDSTYLE};
  private Color color;
  private Style style;
  public void setColor(String color){
    this.color=Color.valueOf(color.toUpperCase());
  }
  public String getColor(){
    return (this.color.toString()).toLowerCase();
  }
  public void setStyle(String style){
    this.style=Style.valueOf(style.toUpperCase());
  }
  public String getStyle(){
    return (this.style.toString()).toLowerCase();
  }  
}