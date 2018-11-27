
import java.lang.Integer;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

// ***************************************************************************
   
public  class Graph {

    // Executes ShortestPath
    public void run( Vertex s )
     {
        Graph gaux3 = ShortestPath( s );
        Graph.stopProfile();
        gaux3.display();
        Graph.resumeProfile();
        original( s );
    }

    public  Graph ShortestPath( Vertex s ) {
        Vertex source;
                
        source = s;
        int numvertices = vertices.size();
        int i;
        Vertex x,n;
        int wuvn;
        int k1;
                                        
        // 1. Initializes the single source
        for ( i=0; i < numvertices; i++ )
        {
            x = ( Vertex )vertices.get( i );
            x.predecessor = null;
            x.dweight = Integer.MAX_VALUE;
        }
                        
        source.dweight = 0;
        source.predecessor = null;
                                
        // 2. S <- empty set
        LinkedList S = new LinkedList();
                
        // 3. Queue <- V[G], copy the vertex in the graph in the priority queue
        LinkedList Queue = new LinkedList();
        for( i=0; i < numvertices; i++ )
        {
            x = ( Vertex )vertices.get( i );
            if ( x.dweight != 0 ) // this means, if this is not the source
                Queue.add( x );
        }
                
        // Inserts the source at the head of the queue
        Queue.addFirst( source );
                
        // 4. while Q!=0
        Vertex ucurrent;
        int j,k,l;
        int pos;
        LinkedList Uneighbors;
        Vertex u,v;
        int wuv;
                
        while ( Queue.size()!=0 )
        {
            // 5. u <- Extract-Min(Q);
            u = ( Vertex )Queue.removeFirst();
                                                
            // 6. S <- S U {u} 
            S.add( u );
                                                                        
            // 7. for each vertex v adjacent to u
            Uneighbors = u.adjacentVertices;

            // For all the neighbors
            for( k=0; k < Uneighbors.size(); k++ )
              {
                v = ( Vertex ) Uneighbors.get( k );
                wuv = ( ( Integer )u.weightsList.get( k ) ).intValue();

                // 8. Relax (u,v w)
                if ( v.dweight > ( u.dweight +  wuv ) )
                    {
                    v.dweight = u.dweight +  wuv;
                    v.predecessor = u.name;
                    Uneighbors.set( k,v ); // adjust values in the neighbors
                                                                                                    
                    // update the values of v in the queue
                    int indexNeighbor = Queue.indexOf( v );
                    if ( indexNeighbor>=0 ) 
                          {
                        Object residue = Queue.remove( indexNeighbor );
                                                                                                                        
                        // Get the new position for v
                        int position = Collections.binarySearch( Queue,v, 
                                                  new Comparator() {
                            public int compare( Object o1, Object o2 )
                                                             {
                                Vertex v1 = ( Vertex )o1;
                                Vertex v2 = ( Vertex )o2;
                                    
                                if ( v1.dweight < v2.dweight )
                                    return -1;

                                if ( v1.dweight == v2.dweight )
                                    return 0;
                                return 1;
                            }
                        } );
                                                                                                                                
                        // Adds v in its new position in Queue                                                                          
                        if ( position < 0 )  // means it is not there
                                                  {
                            Queue.add( - ( position+1 ),v );
                        }
                        else      // means it is there
                                                  {
                            Queue.add( position,v );
                        }
                    } // if in queue
                } // if 8.
            } // for k
        } // of while
        
        // Creates a new graph from the original vertices and the pred
        // fields
        String theName;
        Graph newGraph = new  Graph();
                
        // Creates and adds the vertices with the same name
        for ( i=0; i<numvertices; i++ )
      {
            theName = ( ( Vertex )vertices.get( i ) ).name;
            newGraph.addVertex( new  Vertex().assignName( theName ) );
        }
                
        Vertex theVertex, thePred;
        Vertex theNewVertex, theNewPred;
        Vertex theNeighbor;
        boolean flag = false;
      
        // adds the adjacent Vertices based on the pred fields
        for ( i=0; i<numvertices; i++ )
      {
            // theVertex and its predecessor
            theVertex = ( Vertex )vertices.get( i );
            thePred = findsVertex( theVertex.predecessor );
            
            // if theVertex is the source then continue we dont need
            // to create a new neighbor
            if ( thePred==null )
                continue;
            
            // Find the references in the new Graph
            theNewVertex = newGraph.findsVertex( theVertex.name );
            theNewPred = newGraph.findsVertex( thePred.name );
 
            // Creates the new neighbor in predecessor -> vertex in the new
            // Graph and adjusts the adorns based on the old edge
            ( theNewPred.adjacentVertices ).add( theNewVertex );
            
            // the adjacent corresponds to the neighbor formed with
            // theVertex -> thePred
            // find the corresponding neighbor of the Vertex, that is,
            // predecessor
            j=0;
            flag=false;
            do
          {
                theNeighbor = ( Vertex ) ( thePred.adjacentVertices ).get( j );
                if ( theNeighbor.name.equals( theVertex.name ) )
                    flag = true;
                else
                    j++;
            }
            while( flag==false && j < thePred.adjacentVertices.size() );
           
            // What remains to be done is to adjust the adorns
            // by copying  the values that are embedded in 
            // theNeighbor object
            theNewPred.adjustAdorns( thePred, j );
               
        } // all the vertices
                                     
        return newGraph;
         
    } // shortest path
}
