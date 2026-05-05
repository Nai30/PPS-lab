package PSP;
import java.util.concurrent.*;
import java.util.*;

public class MatrixMultiplication {

    public static void main(String[] args) throws InterruptedException {
        int[] nValues = {1000, 5000}; // 10000 might be very slow/memory intensive
        for (int n : nValues) {
            runTest(n);
        }
    }

    public static void runTest(int n) throws InterruptedException {
        System.out.println("\nTesting for n = " + n);
        
        // Setup data: 1 vector and 5 matrices for comparison
        int[] v = new int[n];
        int[][][] matrices = new int[5][n][n]; 
        Arrays.fill(v, 1); // Simplified for testing

        // --- Sequential Timing ---
        long start = System.currentTimeMillis();
        for (int[][] A : matrices) {
            multiplySequential(A, v);
        }
        long end = System.currentTimeMillis();
        System.out.println("Sequential Time: " + (end - start) + "ms");

        // --- Parallel Timing ---
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(cores);
        
        start = System.currentTimeMillis();
        for (int[][] A : matrices) {
            pool.execute(() -> multiplySequential(A, v));
        }
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.HOURS);
        end = System.currentTimeMillis();
        System.out.println("Parallel Time (" + cores + " cores): " + (end - start) + "ms");
    }

    public static int[] multiplySequential(int[][] A, int[] v) {
        int n = v.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i] += A[i][j] * v[j];
            }
        }
        return result;
    }
}