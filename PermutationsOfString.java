import java.util.*;

public class PermutationsOfString {
    static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    static void solveWithBacktracking(String input, int index, Set<String> v) {

        if (input.length() - 1 == index) {
            v.add(input);
            return;
        }
        Set<Character> mp = new HashSet<>();
        for (int i = index; i < input.length(); i++) {
            if (!mp.contains(input.charAt(i))) {
                mp.add(input.charAt(i));
                input = swap(input, index, i);
                solveWithBacktracking(input, index + 1, v);
                input = swap(input, index, i);
            }

        }
    }

    static void solveWithRecursion(String input, String output, Set<String> v) {

        if (input.isEmpty()) {
            v.add(output);
            return;
        }
        Set<Character> mp = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if (!mp.contains(input.charAt(i))) {
                mp.add(input.charAt(i));
                String newInp = input.substring(0, i) + input.substring(i + 1);
                String newOp = output + input.charAt(i);
                solveWithRecursion(newInp, newOp, v);
            }

        }
    }

    public static void main(String[] args) {
        String input = "abcABC";
        Set<String> result = new TreeSet<>();
        solveWithRecursion(input, "", result);
        solveWithBacktracking(input, 0, result);
        System.out.println(result);
        //List<String> finalResult = new ArrayList<>(result);
        // finalResult;
    }
}
