import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_15758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            int lcm = getLCM(s1.length(), s2.length());

            String extentS1 = repeatString(s1, lcm / s1.length());
            String extentS2 = repeatString(s2, lcm / s2.length());

            if (extentS1.equals(extentS2))
                sb.append("#").append(i).append(" ").append("yes").append("\n");
            else
                sb.append("#").append(i).append(" ").append("no").append("\n");
        }

        System.out.println(sb);
    }

    static String repeatString(String s, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    static int getLCM(int num1, int num2) {
        int gcd = 0;
        for (int i = 1; i <= num1 && i <= num2; i++) {
            if (num1 % i == 0 && num2 % i == 0)
                gcd = i;
        }
        return (num1 * num2) / gcd;
    }
}
