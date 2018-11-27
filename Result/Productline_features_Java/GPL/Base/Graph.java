
import java.util.LinkedList;

// ************************************************************
   
public class Graph {
    public LinkedList vertices;
    public static boolean isDirected = false;

	static
	{
		staticInitialization();	
	}

	public static void staticInitialization()
	{
	}
   
    public Graph() {
        vertices = new LinkedList();
    }
 
    // Fall back method that stops the execution of programs
    public void run( Vertex s ) {}

    // Adds an edge without weights if Weighted layer is not present
    public void addAnEdge( Vertex start,  Vertex end, int weight )
      {
        addEdge( start,end );
    }
        
    public void addVertex( Vertex v ) {
        vertices.add( v );
    }
   
    // Adds and edge by setting end as adjacent to start vertices   
    public void addEdge( Vertex start,  Vertex end ) {
        start.addAdjacent( end );
    }
      
    // Finds a vertex given its name in the vertices list
    public  Vertex findsVertex( String theName )
      {
        int i=0;
        Vertex theVertex;
        
        // if we are dealing with the root
        if ( theName==null )
            return null;
            
        for( i=0; i<vertices.size(); i++ )
            {
            theVertex = ( Vertex )vertices.get( i );
            if ( theName.equals( theVertex.name ) )
                return theVertex;
        }
        return null;
    }
    
    public void display() {
        int s = vertices.size();
        int i;
 
        Main.println( "******************************************" );
        Main.println( "Vertices " );
        for ( i=0; i<s; i++ )
            ( ( Vertex ) vertices.get( i ) ).display();
        Main.println( "******************************************" );

    }
}

