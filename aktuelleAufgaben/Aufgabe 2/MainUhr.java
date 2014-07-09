public class MainUhr {

  public static void main(String[] args) {
    int hour;
    int min;
    Time oldTime=new Time();
    Time newTime=new Time();
    Zeitserver zs=new Zeitserver();
    while (true){
      //wait(1000 msec);
      oldTime=zs.getState();
      if (oldTime.getMin()==59) {
        newTime.setHour(oldTime.getHour()+1);
        newTime.setMin(0);
      } else {
        newTime.setMin(oldTime.getMin()+1);
      }
      zs.setState(newTime);
      oldTime.setHour(newTime.getHour());
      oldTime.setMin(newTime.getMin());
    } 
  } 

}
