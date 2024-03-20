import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_20019 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            String str = br.readLine();
            if (isPalindromeOfPalindrome(str)) {
                sb.append("#" + tc + " YES\n");
            } else {
                sb.append("#" + tc + " NO\n");
            }
        }

        System.out.print(sb.toString());
        br.close();
    }

    static boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    static boolean isPalindromeOfPalindrome(String str) {
        if (!isPalindrome(str)) {
            return false;
        }

        int len = str.length();
        if (len % 2 == 0) {
            return false;
        }

        String firstHalf = str.substring(0, (len - 1) / 2);
        String secondHalf = str.substring((len + 1) / 2);

        return isPalindrome(firstHalf) && isPalindrome(secondHalf);
    }
}
