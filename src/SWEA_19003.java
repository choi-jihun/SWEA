import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA_19003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            String[] str = new String[N];
            for (int j = 0; j < N; j++) {
                str[j] = br.readLine();
            }
            sb.append("#").append(i).append(" ").append(maxPalindromeLen(str, M)).append("\n");
        }
        System.out.println(sb);

    }

    static boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1))
                return false;
        }
        return true;
    }

    static int maxPalindromeLen(String[] str, int m) {
        HashSet<String> set = new HashSet<>();
        int length = 0;
        boolean hasOddPalindrome = false;

        for (String s : str) {
            String reverse = new StringBuilder(s).reverse().toString();
            if (isPalindrome(s)) {
                if (!hasOddPalindrome) {
                    hasOddPalindrome = true;
                    length += m;
                }
            } else if (set.contains(reverse)) {
                length += 2 * m;
                set.remove(reverse);
            } else {
                set.add(s);
            }
        }

        return length;
    }
}
