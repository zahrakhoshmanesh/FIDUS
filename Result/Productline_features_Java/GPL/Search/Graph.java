
import java.util.LinkedList;

// *************************************************************************
   
public  class Graph {
    public void GraphSearch( WorkSpace w ) {
        int           s, c;
        Vertex  v;
  
        // Step 1: initialize visited member of all nodes

        s = vertices.size();
        if ( s == 0 )
            return;
         
        // Showing the initialization process
        for ( c = 0; c < s; c++ ) {
            v = ( Vertex ) vertices.get( c );
            v.init_vertex( w );
        }

        // Step 2: traverse adjacentVertices of each node
         
        for ( c = 0; c < s; c++ ) {
            v = ( Vertex ) vertices.get( c );
            if ( !v.visited ) {
                w.nextRegionAction( v );
		nodeSearch(v, w);
            }
        } //end for
         
    } // GraphSearch

   	public void nodeSearch(Vertex v, WorkSpace w)
	{

	}
}
