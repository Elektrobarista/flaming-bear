public class Debugger{
  public static int test ( int start , int basis ) {
    int result=start ;
    int stopvalue=start ;
    int shift=0;
    int index=0;
    do {
      if( result%basis==0){
        result=result / basis ;
      } else {
        shift=basis - result % basis ;
        result=(basis+1)* result+shift ;
      }
      if ( index%2==1){
        if ( stopvalue%basis==0){
          stopvalue=stopvalue / basis ;
        } else {
          shift=basis - stopvalue % basis ;
          stopvalue=(basis+1)* stopvalue+shift ;
        }
      }
      index++;
    } while ( result !=stopvalue ) ;
    return index ;
  }
}