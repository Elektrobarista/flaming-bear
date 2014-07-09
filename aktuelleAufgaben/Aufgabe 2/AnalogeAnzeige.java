import java.util.Observable;
import java.util.Observer;

public class AnalogeAnzeige implements Observer{
  Time time=new Time();
  Zeitserver zs;
  public void displayValue(){
    this.time=zs.getState();
    System.out.println("(analog:)"+this.time.getHour()+":"+this.time.getMin());
  }
  public void changeTime(int hour, int min){
    Time timezs=new Time(hour,min);
    zs.setState(timezs);
  }
  @Override
  public void update(Observable o, Object arg) {
    this.time=zs.getState();
    
  } 
}