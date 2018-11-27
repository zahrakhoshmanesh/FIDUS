
import java.lang.Integer;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

 // of Graph

// ****************************************************************************
   
public  class Vertex {
    public String predecessor; // the name of the predecessor if any
    public int dweight; // weight so far from s to it
      
    public void display() {
        Main.print( " Pred " + predecessor +" DWeight " + dweight + " " );
        original();
    }
      
}
