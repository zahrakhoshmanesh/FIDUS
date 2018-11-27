import gov.nasa.jpf.annotation.FilterField;
import gov.nasa.jpf.jvm.Verify;
//import gov.nasa.jpf.symbc.Symbolic;

import java.util.List;
import java.util.ArrayList;
import java.lang.Throwable;

public class PL_Interface_impl implements PL_Interface {

	@FilterField
	//@Symbolic("false")
	public static boolean executedUnimplementedAction = false;
	@FilterField
	//@Symbolic("false")
	public static List<String> actionHistory = new ArrayList<String>();
	public static boolean verbose = false;
	@FilterField
	//@Symbolic("false")
	private static boolean isAbortedRun = false;

	public static void main(String[] args) {
		try {
			PL_Interface_impl impl = new PL_Interface_impl();
			args = new String[1];
			impl.start(8,1);
			Main.println("no Exception");
		} catch (Throwable e) {
			Main.println("Caught Exception: " + e.getClass() + " "
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	public void start(int specification, int variation) throws Throwable {
		try {
			if (verbose) 
				Main.print("Started with Specification " + specification +  ", Variation: " +variation);
			test(specification, variation);
		} catch (Throwable e) {
			throw e;
		}finally {
		}
	}
	public void checkOnlySpecification(int specID) {
		Main.println("Specifications not implemented");
	}

	public List<String> getExecutedActions() {
		return actionHistory;
	}
	
	public boolean isAbortedRun() {
		return isAbortedRun;
	}

	// this method is used as hook for the liveness properties.
	public void test(int specification, int variation) throws Throwable {
		String file = "";
		CheckMST.inputFileID = specification;
		switch (specification) {
		case 1: file ="CC_small.bench"     ;break;
		case 2: file ="CC_large.bench"     ;break;
		case 3: file ="CC_weighted.bench"  ;break;
		case 4: file ="SCC_small.bench"    ;break;
		case 5: file ="SCC_large.bench"    ;break;
		case 6: file ="SCC_weighted.bench" ;break;
		case 7: file ="SSSP"               ;break;
		
		case 8: file ="MST_small.bench"    ;break;
		case 9: file ="MST_large.bench"    ;break;
		case 10: file ="Number.bench"      ;break;
		
		case 11: file ="CycleExample1.bench" ;break;
		case 12: file ="CycleExample2.bench" ;break;
		case 13: file ="CycleExample3.bench" ;break;
		case 14: file ="CycleExample4.bench" ;break;
		case 15: file ="hamiltonian.bench"   ;break;
		
		case 16: file ="MinEdges-Dir.bench"   ;break;
		case 17: file ="MinEdges-Undir.bench" ;break;
		case 18: file ="InvalidGraph.bench"   ;break;
		}
		Main.println("using file " + file + " for benchmark");
		//(new Graph()).runBenchmark("/home/rhein/workspace/JavaSPLVerifier/ProductLines/GPLCohen/GPL-Inputs/" + file);
		String[] args = {"/home/rhein/workspace/JavaSPLVerifier/ProductLines/GPLCohen/GPL-Inputs/" + file, "v1"};
		try {
			Main.main(args);
		} catch (Throwable e) {
			Main.println("Caught Exception: " + e.getClass() + " "
					+ e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	public static int getIntegerMinMax(int min, int max) {
		return Verify.getInt(min, max);
	}
	public static boolean getBoolean() {
		return Verify.getBoolean();// verify true first
	}
	
	static String listToString(List<String> list) {
		String ret = "";
		for (String s : list) {
			ret = ret + " " + s;
		}
		return ret;
	}

}
