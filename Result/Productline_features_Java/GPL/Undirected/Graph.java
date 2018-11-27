
import java.util.LinkedList;

// ************************************************************
   
 class Graph
{
	public static void staticInitialization()
	{
		original();
		isDirected = false;
	}

   
    // Adds and edge by setting start as adjacent to end and
    // viceversa
    public void addEdge( Vertex start,  Vertex end )
    {
        original(start, end);
	end.addAdjacent( start );
    }
}
