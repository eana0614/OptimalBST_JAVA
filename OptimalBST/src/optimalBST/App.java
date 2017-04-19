package optimalBST;

public class App {

	public static void main(String[] args) {
		
		double[] p = {0, 0.15, 0.10, 0.05, 0.10, 0.20};
		double[] q = {0.05, 0.10, 0.05, 0.05, 0.05, 0.10};
		
		OptimalBST obst = new OptimalBST(p, q);
		
		System.out.println("[ START ] Optimal BST");
		
		obst.runOptimalBST();
		
		System.out.printf("!] Min Search Cost = %2.2f\n",obst.minSearchCost());
		
		obst.printExpectationKey();
		obst.printSubtreeWeight();
		obst.printRootArray();
	}

}
