
import java.lang.Integer;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

// *************************************************************************
   
public  class Graph {

    // Executes MSTPrim
    public void run( Vertex s )
     {
        Graph gaux = Prim( s );
        Graph.stopProfile();
        gaux.display();
        Graph.resumeProfile();
        original( s );
        CheckMST.checkMinimalSpanningTreeProperties(gaux);
    }
     
    public  Graph Prim( Vertex r ) {
        Vertex root;
                
        root = r;
        int numvertices = vertices.size();
        int i;
        Vertex x;
        
        // 2. and 3. Initializes the vertices
        for ( i=0; i < numvertices; i++ )
        {
            x = ( Vertex )vertices.get( i );
            x.pred = null;
            x.key = Integer.MAX_VALUE;
        }
                
        // 4. and 5.        
        root.key = 0;
        root.pred = null;
                                
        // 2. S <- empty set
                
        // 1. Queue <- V[G], copy the vertex in the graph in the priority queue
        LinkedList Queue = new LinkedList();
                
        for( i=0; i < numvertices; i++ )
        {
            x = ( Vertex )vertices.get( i );
            if ( x.key != 0 ) // this means, if this is not the root
                Queue.add( x );
        }
                
        // Inserts the root at the head of the queue
        Queue.addFirst( root );
                
        // 6. while Q!=0
        Vertex ucurrent;
        int j,k,l;
        int pos;
        LinkedList Uneighbors;
        Vertex u,v;

        int wuv;
        boolean isNeighborInQueue = false;
                
        while ( Queue.size()!=0 )
        {
            // 7. u <- Extract-Min(Q);
                 // since this an ordered queue the first element is the min            
            u = ( Vertex )Queue.removeFirst();
                                                                        
            // 8. for each vertex v adjacent to u
            Uneighbors = u.adjacentVertices;

            for( k=0; k < Uneighbors.size(); k++ )
             {
                v = ( Vertex )Uneighbors.get( k );

                // Check to see if the neighbor is in the queue
                isNeighborInQueue = false;
                                                                
                // if the Neighor is in the queue
                int indexNeighbor = Queue.indexOf( v );
                if ( indexNeighbor>=0 )
                    isNeighborInQueue=true;
                                                                
                wuv = ( ( Integer )u.weightsList.get( k ) ).intValue();
                                                                
                // 9. Relax (u,v w)
                if ( isNeighborInQueue && ( wuv < v.key ) )
                   {
                    v.key = wuv;
                    v.pred = u.name;
                    Uneighbors.set( k,v ); // adjust values in the adjacentVertices
                                                                                                    
                    // update the values of v in the queue
                    // if (indexNeighbor>=0) Queue.set(indexNeighbor,v);
                                                                                                    
                      // update the values of v in the queue                    
                         // Remove v from the Queue so that we can reinsert it
                    // in a new place according to its new value to keep
                    // the Linked List ordered
                    Object residue = Queue.remove( indexNeighbor );
                                                                                                    
                    // Get the new position for v
                    int position = Collections.binarySearch( Queue,v, 
                           new Comparator() {
                        public int compare( Object o1, Object o2 )
                                                   {
                            Vertex v1 = ( Vertex )o1;
                            Vertex v2 = ( Vertex )o2;
                                  
                            if ( v1.key < v2.key )
                                return -1;

                            if ( v1.key == v2.key )
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
                } // if 9. Relax
                                    
            } // for all adjacentVertices
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
            thePred = findsVertex( theVertex.pred );
            
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
                theNeighbor = ( Vertex ) ( theVertex.adjacentVertices ).get( j );
                if ( theNeighbor.name.equals( thePred.name ) )
                    flag = true;
                else
                    i++;  // S.H. 8. DSR: j -> i
            }
            while( flag==false && j < theVertex.adjacentVertices.size() );
           
            // What remains to be done is to adjust the adorns
            // by copying  the values that are embedded in 
            // theNeighbor object 
            theNewPred.adjustAdorns( theVertex, j );
               
        } // all the vertices
                                                                 
        return newGraph;
    } // MST
      
}
