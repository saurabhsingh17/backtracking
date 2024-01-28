import java.util.*;

public class PermutationsOfString {
    static void solve(String input,String output, Set<String> v){

        if(input.isEmpty()) {
            v.add(output);
            return;
        }
        Set<Character> mp = new HashSet<>();
        for( int i = 0; i < input.length(); i++){
            if(!mp.contains(input.charAt(i))) {
                mp.add(input.charAt(i));
                String newInp = input.substring(0,i)+input.substring(i+1);
                String newOp = output + input.charAt(i);
                solve(newInp, newOp,v);
            }

        }
    }

    public static void main(String[] args) {
        String input = "abcABC";
        Set<String> result = new TreeSet<>();
        solve(input,"",result);
        System.out.println(result);
        //List<String> finalResult = new ArrayList<>(result);
        // finalResult;
    }
}
