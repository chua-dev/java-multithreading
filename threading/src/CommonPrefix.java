import java.util.Arrays;

public class CommonPrefix {

    public static String longestCommonPrefix(String[] arrays) {

        StringBuilder ans = new StringBuilder();
        Arrays.sort(arrays);
        String first = arrays[0];
        String last = arrays[arrays.length - 1];

        for (int i=0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
}
