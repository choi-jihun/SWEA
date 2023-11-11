import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            String str = br.readLine();
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < str.length(); j++) {
                String s1 = str.substring(0, j);
                String s2 = str.substring(j);
                min = Math.min(min, getMin(s1, s2));
            }

            sb.append("#").append(i).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }

    static int getMin(String str1, String str2) {
        if (str1.isEmpty()) {
            str1 = "0";
        }
        if (str2.isEmpty()) {
            str2 = "0";
        }
        return Integer.parseInt(str1) + Integer.parseInt(str2);
    }
}
