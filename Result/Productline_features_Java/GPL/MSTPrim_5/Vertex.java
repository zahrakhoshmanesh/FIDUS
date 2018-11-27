
import java.lang.Integer;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

 // of Graph

// ********************************************************************
   
public  class Vertex {
    public String pred; // the name of the predecessor if any
    public int key; // weight so far from s to it
      
    public void display() {
        Main.print( " Pred " + pred + " Key " + key + " " );
        original();
    }
      
}
