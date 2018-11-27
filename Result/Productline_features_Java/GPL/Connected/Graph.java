
// *****************************************************************
   
public  class Graph {

    // Executes Connected Components
    public void run( Vertex s )
     {
        ConnectedComponents();
        original( s );
    }
     
    public void ConnectedComponents() {
        GraphSearch( new RegionWorkSpace() );
    }
}
