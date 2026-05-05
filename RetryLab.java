package PSP;
import java.util.Random;

// The Functional Interface
@FunctionalInterface
interface DoNotGiveUp<T> {
    T execute();
}

public class RetryLab {
    public static void main(String[] args) {
        Random rand = new Random();

        // 1. TryThreeTimes Implementation
        DoNotGiveUp<String> tryThreeTimes = () -> {
            for (int i = 1; i <= 3; i++) {
                int num = rand.nextInt(100) + 1;
                System.out.println("Attempt " + i + ": Generated " + num);
                if (num > 50) return "You succeeded";
            }
            return "Failed";
        };

        // 2. TryForEver (1000 times) Implementation
        DoNotGiveUp<String> tryForEver = () -> {
            for (int i = 1; i <= 1000; i++) {
                double num = Math.random();
                if (num < 0.4) return "Success after " + i + " tries";
            }
            return "Failed after 1000 tries";
        };

        System.out.println("--- TryThreeTimes Result ---");
        System.out.println(tryThreeTimes.execute());

        System.out.println("\n--- TryForEver Result ---");
        System.out.println(tryForEver.execute());
    }
}