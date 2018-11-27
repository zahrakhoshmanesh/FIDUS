import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class CheckMST {
	
	static int getExpectedMSTSize(int inputFileID) {
		if (inputFileID == 8) return 37;
		else if (inputFileID==9) return 48;
		else throw new RuntimeException("unknown inputFileID");
	}
	static int getEdgeWeight(Vertex v, int edgeId) {
		return (Integer) v.weightsList.get(edgeId);
	}
}
