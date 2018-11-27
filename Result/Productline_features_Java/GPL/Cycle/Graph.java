
import java.lang.Integer;

// *************************************************************************
   
public  class Graph {
   
    // Executes Cycle Checking
    public void run( Vertex s )
     {
        Main.println( " Cycle? " + CycleCheck() );
        original( s );
    }
                   
    public boolean CycleCheck() {
        CycleWorkSpace c = new CycleWorkSpace( isDirected );
        GraphSearch( c );
        return c.AnyCycles;
    }
}
