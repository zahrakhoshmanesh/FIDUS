
import java.util.LinkedList;

// *************************************************************************
   
public  class Graph
{
	public void nodeSearch(Vertex v, WorkSpace w)
	{
		original(v, w);
		v.dftNodeSearch( w );
	}
}

