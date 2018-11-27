
import java.util.LinkedList;

// ************************************************************
   
public class Vertex {
    public LinkedList adjacentVertices;
    public String name;
   
    public Vertex() {
        VertexConstructor();
    }

    public void VertexConstructor() {
        name      = null;
        adjacentVertices = new LinkedList();
    }

    public  Vertex assignName( String name ) {
        this.name = name;
        return ( Vertex ) this;
    }
   
    public void addAdjacent( Vertex n ) {
        adjacentVertices.add( n );
    }

    public void adjustAdorns( Vertex the_vertex, int index )
      {}
      
    public void display() {
        int s = adjacentVertices.size();
        int i;

        Main.print( "Vertex " + name + " connected to: " );
        for ( i=0; i<s; i++ )
            Main.print( ( ( Vertex ) adjacentVertices.get( i ) ).name 
                                                + ", " );
        Main.println();
    }
}
