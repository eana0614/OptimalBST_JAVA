package optimalBST;

public class OptimalBST {

	int MAX = 100000;

	double[] key;
	double[] imaginaryKey;

	double[][] e;
	double[][] w;
	int[][] root;

	public OptimalBST(double[] p, double[] q) {
		this.key = p;
		this.imaginaryKey = q;
	}

	public void runOptimalBST() {
		int n = key.length;

		e = new double[n + 1][n];
		w = new double[n + 1][n];
		root = new int[n][n];

		for (int i = 0; i < n; i++) {
			e[i + 1][i] = imaginaryKey[i];
			w[i + 1][i] = imaginaryKey[i];
		}

		for (int l = 0; l < n + 1; l++) {
			for (int i = 1; i < n - l; i++) {
				int j = i + l;

				e[i][j] = MAX;
				w[i][j] = w[i][j - 1] + key[j] + imaginaryKey[j];

				for (int r = i; r < j + 1; r++) {
					double temp = e[i][r - 1] + e[r + 1][j] + w[i][j];

					if (temp < e[i][j]) {
						e[i][j] = temp;
						root[i][j] = r;
					}
				}
			}
		}
	}

	public void printExpectationKey() {
		System.out.println("!] E(x) ");

		for (int i = 1; i < e.length; i++) {
			for (int j = 0; j < e[0].length; j++) {
				System.out.printf("   %1.2f", e[i][j]);
			}
			System.out.println();
		}

		System.out.println("\n");
	}

	public void printSubtreeWeight() {

		System.out.println("!] Weight");

		for (int i = 1; i < w.length; i++) {
			for (int j = 0; j < w[0].length; j++) {
				System.out.printf("   %1.2f", w[i][j]);
			}
			System.out.println();
		}

		System.out.println("\n");
	}

	public void printRootArray() {
		
		System.out.println("!] Root ");

		for (int i = 1; i < root.length; i++) {
			for (int j = 1; j < root[0].length; j++) {
				System.out.printf("  %d", root[i][j]);
			}
			System.out.println();
		}

		System.out.println("\n");
	}

	public double minSearchCost(){
		return e[1][e[0].length-1];
	}
}
