
 // Graph class

// *************************************************************************
   
public  class Vertex {
    public void dftNodeSearch( WorkSpace w ) {
        int           s, c;
        Vertex v;

        // Step 1: Do preVisitAction. 
        //                        If we've already visited this node return

        w.preVisitAction( ( Vertex ) this );
         
        if ( visited )
            return;

        // Step 2: else remember that we've visited and 
        //         visit all adjacentVertices

        visited = true;
         
        s = adjacentVertices.size();
        for ( c = 0; c < s; c++ ) 
                {
            v = ( Vertex ) adjacentVertices.get( c );
            w.checkNeighborAction( ( Vertex ) this, v );
            v.dftNodeSearch( w );
        }
        ;
     
        // Step 3: do postVisitAction now
        w.postVisitAction( ( Vertex ) this );
    } // dftNodeSearch
}
