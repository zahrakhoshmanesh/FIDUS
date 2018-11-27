
// *************************************************************************
   
public  class Graph {

    // Executes Number Vertices
    public void run( Vertex s )
     {
        NumberVertices();
        original( s );
    }
     
    public void NumberVertices() {
        GraphSearch( new NumberWorkSpace() );
    }
}
