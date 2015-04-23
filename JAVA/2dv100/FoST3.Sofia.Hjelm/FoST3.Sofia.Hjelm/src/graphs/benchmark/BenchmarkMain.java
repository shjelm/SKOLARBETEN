/**
 * 
 */
package graphs.benchmark;

/**
 * @author jonasl
 *
 */
public class BenchmarkMain {

	public static void main(String[] args) {
		final int SIZE = 100; // 100 will be used the competition
		GraphBenchmark gbm = new GraphBenchmark(SIZE);
		
		
		double time = 0.0;
		
		time += gbm.runGraphPerformance();
		
	    time += gbm.runTransitiveClosure();
	    
	    time += gbm.runConnectedComponents();
	    
	    System.out.println("Total Time: "+time);
	}
}
