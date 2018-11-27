
import java.lang.Integer;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

// KRUSKAL algorithm, Cormen's textbook 24.2

// *************************************************************************
   
public  class Graph {

    // Executes MSTKruskal
    public void run( Vertex s )
     {
        Graph gaux2 = Kruskal();
        Graph.stopProfile();
        gaux2.display();
        Graph.resumeProfile();
        original( s );
        CheckMST.checkMinimalSpanningTreeProperties(gaux2);
    }
                   
    public  Graph Kruskal() {
      
        // 1. A <- Empty set
        LinkedList A = new LinkedList();
        
        // 2. for each vertex v E V[G]
        // 3.    do Make-Set(v)
        int numvertices = vertices.size();
        int i;
        Vertex v;
                
        for ( i=0; i < numvertices; i++ )
        {
            v = ( Vertex )vertices.get( i );
            v.representative = v; // I am in my set
            v.members = new LinkedList(); // I have no members in my set
        }
                
        // 4. sort the edges of E by nondecreasing weight w        
        // Creates the edges objects
        int j;
        LinkedList Vneighbors = new LinkedList();
        Vertex u;
                
        LinkedList edges = new LinkedList();
        int k1=0,k2=0, sizeAV=0;
        for( k1=0; k1< numvertices; k1++ )
        {
            v = ( Vertex )vertices.get( k1 );
            sizeAV = v.adjacentVertices.size();
            for ( k2=0; k2<sizeAV; k2++ ) {
                edges.add( new  Edge( v,
                                 ( Vertex ) ( v.adjacentVertices ).get( k2 ),
                 ( ( Integer ) ( v.weightsList ).get( k2 ) ).intValue() ) );
            } // of k2
        } // of k1
                
        // Sort the Edges in non decreasing order
        Collections.sort( edges, 
                new Comparator() {
            public int compare( Object o1, Object o2 )
                          {
                Edge e1 = ( Edge )o1;
                Edge e2 = ( Edge )o2;
                if ( e1.weight < e2.weight )
                    return -1;
                if ( e1.weight == e2.weight )
                    return 0;
                return 1;
            }
        } );
       
        // 5. for each edge in the nondecresing order
        int numedges = edges.size();
        Edge e1;
        Vertex vaux, urep, vrep;
                
        for( i=0; i<numedges; i++ )
        {
            // 6. if Find-Set(u)!=Find-Set(v)
            e1 = ( Edge )edges.get( i );
            u = e1.start;
            v = e1.end;

            if ( ! ( v.representative.name ).equals( u.representative.name ) )
              {
                // 7. A <- A U {(u,v)}
                A.add( e1 );
                                                                
                // 8. Union(u,v)
                urep = u.representative;
                vrep = v.representative;
                                                                
                if ( ( urep.members ).size() > ( vrep.members ).size() )
                   { // we add elements of v to u
                    for( j=0; j< ( vrep.members ).size(); j++ )
                         {
                        vaux = ( Vertex ) ( vrep.members ).get( j );
                        vaux.representative = urep;
                        ( urep.members ).add( vaux );
                    }
                    v.representative = urep;
                    vrep.representative = urep;
                    ( urep.members ).add( v );
                    if ( !v.equals( vrep ) )
                        ( urep.members ).add( vrep );
                    ( vrep.members ).clear();
                }
                else
                   { // we add elements of u to v
                    for( j=0; j< ( urep.members ).size(); j++ )
                         {
                        vaux = ( Vertex ) ( urep.members ).get( j );
                        vaux.representative = vrep;
                        ( vrep.members ).add( vaux );
                    }
                    u.representative = vrep;
                    urep.representative = vrep;
                    ( vrep.members ).add( u );
                    if ( !u.equals( urep ) )
                        ( vrep.members ).add( urep );
                    ( urep.members ).clear();
                                                                                
                } // else
                                                
            } // of if
                        
        } // of for numedges
                
        // 9. return A
                
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
                                           
        // Creates the new adjacent vertices based on the edges
        Vertex theNeighbor,newNeighbor;
        Vertex theStartVertex, theEndVertex;
        boolean flag = false;
   
        // for all the edges
        for( i=0; i< A.size(); i++ )
        {
            // The current edge
            e1 = ( Edge ) A.get( i );
   
            // the starnt and end Vertex
            theStartVertex = newGraph.findsVertex( e1.start.name );
            theEndVertex = newGraph.findsVertex( e1.end.name );
                 
            // Creates the new neighbor  from startVertex -> endVertex in the new
            // Graph and adjusts the adorns based on the old edge
            ( theStartVertex.adjacentVertices ).add( theEndVertex );

            // theNeighbor corresponds to the neighbor formed with
            // theStartVertex -> theEndVertex
            // find the corresponding neighbor of the Vertex, that is,
            // predecessor
            j=0;
            flag=false;
            do
          {
                theNeighbor = ( Vertex ) ( e1.start.adjacentVertices ).get( j );
                if ( theNeighbor.name.equals( theEndVertex.name ) )
                    flag = true;
                else
                    j++;
            }
            while( flag==false && j < e1.start.adjacentVertices.size() );

            // What remains to be done is to adjust the adorns
            // by copying  the values that are embedded in 
            // theNeighbor object
            theStartVertex.adjustAdorns( e1.start,j );
     
        } // for all the edges
                
        return newGraph;
    } // kruskal
           
}
