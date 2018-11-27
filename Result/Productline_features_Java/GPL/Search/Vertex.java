
import java.util.LinkedList;

// class Graph
 
// *************************************************************************  
   
public  class Vertex {
    public boolean visited;
 
    public void VertexConstructor() {
        original();
        visited = false;
    }
    
    public void init_vertex( WorkSpace w ) {
        visited = false;
        w.init_vertex( ( Vertex ) this );
    }
   
    public void display() {
        if ( visited )
            Main.print( "  visited " );
        else
            Main.println( " !visited " );
        original();
    }
}
