import java.lang.Object;
import java.util.Observer;
import java.util.ArrayList;

public class Zeitserver implements Subject{
  Time time;
  private ArrayList<Observer> observers;
  
  public void notifyObservers(){
    for (int i=0;i<observers.size() ;i++ ) {
      Observer first = observers.get(i);
      first.update();
    } 
  }
  public void removeObserver(Observer observer){
    observers.remove(observer);
  }
  public void registerObserver(Observer observer){
    observers.add(observer);
  }
  public Time getState(){
    return time;
  }
  public void setState(Time time){
    this.time=time;
  }
}
