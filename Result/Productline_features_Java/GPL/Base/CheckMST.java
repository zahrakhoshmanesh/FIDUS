import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CheckMST {

	static int inputFileID = 0;

	static int getExpectedMSTSize(int inputFileID) {
		if (inputFileID == 8) return 8;
		else if (inputFileID==9) return 10;
		else throw new RuntimeException("unknown inputFileID");
	}
	static int getEdgeWeight(Vertex v, int edgeId) {
		return 1;
	}

	private static class myEdge {
		Vertex a,b;
		int weight;
		public myEdge(Vertex a, Vertex b, int weight) {
			this.a = a; this.b = b;
			this.weight = weight;
		}
		@Override
		public int hashCode() {
			return (a.hashCode() + b.hashCode()) * weight;
		}
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof myEdge ))
				return super.equals(obj);
			else {
				myEdge other = (myEdge) obj;
				return ((this.a == other.a && this.b == other.b) || (this.a == other.b && this.b == other.a)) && this.weight==other.weight;
			}
		}
	}

	// returns a list with all edges that connect node v. The edges are removed from the set.
	// the filtered edges are directed from v to the other node.
	public static List<myEdge> filterEdgesOfVertex(Vertex v, HashSet<myEdge> set) {
		LinkedList<myEdge> lst = new LinkedList<myEdge>();
		Iterator<myEdge> iter = set.iterator();
		while(iter.hasNext()) {
			myEdge e = iter.next();
			if (e.a==v) {
				iter.remove();
				lst.add(e);
			} else if (e.b==v) {
				iter.remove();
				lst.add(new myEdge(v, e.a, e.weight));
			}
		}
		return lst;
	}

	public static void checkMinimalSpanningTreeProperties(Graph g) {
		//select one node as root
		Vertex rootNode = (Vertex) g.vertices.getFirst();
		HashSet<myEdge> allEdges = new HashSet<myEdge>();
		for(Object vo: g.vertices) {
			Vertex v = (Vertex)vo;
			int numNeighbors = v.adjacentVertices.size();
			for (int i = 0; i < numNeighbors; i++) {
				allEdges.add(new myEdge(v, (Vertex)v.adjacentVertices.get(i), getEdgeWeight(v,i)));
			}
		}
		int edgeSum=0;
		Stack<myEdge> todo = new Stack<myEdge>();
		todo.addAll(filterEdgesOfVertex(rootNode, allEdges));
		HashSet<Vertex> seen = new HashSet<Vertex>();
		seen.add(rootNode);
		while (! todo.isEmpty()) {
			myEdge e = todo.pop();
			edgeSum+=e.weight;
			if (seen.contains(e.b))
				throw new RuntimeException("No Tree: found cycle with vertex: " + e.b.name);
			else
				seen.add(e.b);
			todo.addAll(filterEdgesOfVertex(e.b, allEdges));
		}
		if (seen.size() != g.vertices.size()) {
			throw new RuntimeException("No Tree: The graph is not connected or has multiple roots!");
		}
		Main.println("EdgeSum of MST: " + edgeSum);
		if (edgeSum != getExpectedMSTSize(inputFileID))
			throw new RuntimeException("No Tree: Wrong MST size: " + edgeSum + " != " + getExpectedMSTSize(inputFileID) + " !");
		System.out.println("MST check ok");
	}
}
