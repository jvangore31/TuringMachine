/** stores an integer array to represent a tape, includes the tape array, 
current index, and length  
    @author     Jacob Vangore
    @id         jbvangore
    @course     CSIS 252: Programming II
    @assignment Turing Machine
    @related    n/a
*/

public class Tape
{
  // MEMBER DATA, INSTANCE VARIABLES
  /*The tape*/
  int[] tape;
  /*The currentIndex*/
  int currentIndex;
  /*The length*/
  int length;
  
 // MEMBER BEHAVIOR, METHODS
 
  /** Constructor
        @param values to represent the tape 
  */

  public Tape(int[] values)
  {
     tape = values; 
     currentIndex = 0;
     length = tape.length; 
  }
 /* return value of "currentIndex" in the tape array for this tape
        @return int
 */ 
  public int read()
  {
    return tape[currentIndex];
  }
 /* changes the value of "currentIndex" in the tape array for this tape */ 
  public void write(int output)
  {
    tape[currentIndex] = output; 
  }
 /* return value of "currentIndex" for this tape */ 
  public void changeIndex(int direction)
  {
     if(direction == 1 && getCurrentIndex() < getLength())
     {
       currentIndex++;
     }
     if(direction == -1 && getCurrentIndex() <= 0)
     {
       currentIndex--;
     }  
  }
 /* return value of "currentIndex" for this tape
        @return int
 */
  public int getCurrentIndex()
  {
     return currentIndex;
  }
  /* return value of "length" for this tape
        @return int
 */
  public int getLength()
  {
    return length;
  }
 /** return String labelled representation for this tape
      @return String */
  public String toString()
  {
    String out;
    out = "";
    for(int i = 0; i < tape.length; i++)
    {
       out += tape[i];
    }
    
     return out;
  }
}