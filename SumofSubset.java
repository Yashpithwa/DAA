import java.util.*;

public class SumOfSubsetsSimple {

    static int[] set = {10, 7, 5, 18, 12, 20, 15};
    static int target = 35;

    public static void main(String[] args) {
        findSubsets(0, 0, new ArrayList<>());
    }

    static void findSubsets(int index, int currentSum, List<Integer> subset) {
        if (currentSum == target) {
            System.out.println(subset);
            return;
        }

        if (index == set.length || currentSum > target) {
            return;
        }

        // Include current element
        subset.add(set[index]);
        findSubsets(index + 1, currentSum + set[index], subset);

        // Exclude current element (backtrack)
        subset.remove(subset.size() - 1);
        findSubsets(index + 1, currentSum, subset);
    }
}
