
import java.lang.Integer;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

// of Graph

  // *************************************************************************
   
public  class Vertex {
    public  Vertex representative;
    public LinkedList members;
      
    public void display() {
        if ( representative==null )
            Main.print( "Rep null " );
        else
            Main.print( " Rep " + representative.name + " " );
        original();
    }
}
