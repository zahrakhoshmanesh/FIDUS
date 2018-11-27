
import java.lang.Integer;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

// of vertex
   
   // ************************************************************************
    
public class Edge {
    public  Vertex start;
    public  Vertex end;
    public int weight =0;
       
    public Edge( Vertex the_start,  Vertex the_end, 
               int the_weight ) {
        start = the_start;
        end = the_end;
        weight = the_weight;
    } // Edge constructor
   
}
