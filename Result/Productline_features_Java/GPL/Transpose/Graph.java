
import java.util.LinkedList;

// ************************************************************
   
public  class Graph {
 
    public  Graph ComputeTranspose( Graph the_graph )
   {
        int i=0,j=0;
        int num_vertices = ( the_graph.vertices ).size();
        Vertex the_vertex, the_adjacent, 
                 the_new_vertex, the_new_adjacent;
        int num_adjacents =0;
        String theName;
                
        // Creating the new Graph
        Graph newGraph = new  Graph();
                
        // Creates and adds the vertices with the same name
        for ( i=0; i<num_vertices; i++ )
    {
            theName = ( ( Vertex ) ( the_graph.vertices ).get( i ) ).name;
            newGraph.addVertex( new  Vertex().assignName( theName ) );
        }
    
        // In the old graph, traverse all the vertices
        for ( i=0; i<num_vertices; i++ )
    {
            the_vertex = ( Vertex ) ( the_graph.vertices ).get( i );
            num_adjacents = ( the_vertex.adjacentVertices ).size();




            // finds the object reference of the_vertex in new list
            the_new_vertex = newGraph.findsVertex( the_vertex.name );
      
            // In each vertex traverse its adjacentVertices list
            for( j=0; j< num_adjacents; j++ )
      {
                // for each of the vertices in the list find out its vertex 
                the_adjacent = ( Vertex ) the_vertex.adjacentVertices.get( j );
        



                // finds the object reference of the_adjacent in new list
                the_new_adjacent = newGraph.findsVertex( the_adjacent.name );
                
                // adds to the_new_adjacent the_new_vertex
                // switches the direction of the arrow head
                ( the_new_adjacent.adjacentVertices ).add( the_new_vertex );
                  
                // Passes the vertex where to take the information from,
                // the index number in that list, and the reference where
                // to put the adorn value
                the_new_adjacent.adjustAdorns( the_vertex,j );
         
            } // for j all adjacentVertices
        } // for i all vertices
            
        return newGraph;
    } // of ComputeTranspose
         
}
