import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1, 1, 3};
        Arrays.sort(nums);
        System.out.println(Approach1.permute(nums));
        System.out.println(Approach2.permute(nums));
    }

    //Uses additional frequency array
    static class Approach1 {

        static public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            boolean[] used = new boolean[nums.length];
            backtrack(res, new ArrayList<>(), nums, used);
            return res;
        }

        static void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums, boolean[] used) {
            if (tempList.size() == nums.length) {
                res.add(new ArrayList<>(tempList));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(res, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }

        }
    }

    //Uses swapping
    static class Approach2 {
        static List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            boolean[] used = new boolean[nums.length];
            backtrack(0, res, nums);
            return res;
        }

        static void backtrack(int index, List<List<Integer>> res, int[] nums) {
            if (index == nums.length) {
                ArrayList<Integer> curr = new ArrayList<>();
                for (int i : nums) {
                    curr.add(i);
                }
                res.add(curr);
                return;
            }

            for (int i = index; i < nums.length; i++) {
                if (i > 0 && nums[i - 1] == nums[i])
                    continue;
                swap(i, index, nums);
                backtrack(index + 1, res, nums);
                swap(index, i, nums);
            }

        }

        static void swap(int i, int j, int[] nums) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
