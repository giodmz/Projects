import java.util.ArrayList;

public class LeetQ2 {

    public int maxCount(int[] nums){

        int positiveCount = 0;
        int negativoCount = 0;
        
        for (int num : nums) {
            if (num > 0) {
                positiveCount++;
            } else if (num < 0) {
                negativoCount++;
            }
        }

        return Math.max(positiveCount, negativoCount);
    }
}
    


