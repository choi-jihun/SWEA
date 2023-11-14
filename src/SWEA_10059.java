import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_10059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            String str = br.readLine();
            String str1 = str.substring(0, 2);
            String str2 = str.substring(2);

            boolean isStr1ValidMonth = isValidMonth(str1);
            boolean isStr2ValidMonth = isValidMonth(str2);

            if (!isStr1ValidMonth && !isStr2ValidMonth) {
                sb.append("#").append(i).append(" NA\n");
            } else if (isStr1ValidMonth && !isStr2ValidMonth) {
                sb.append("#").append(i).append(" MMYY\n");
            } else if (!isStr1ValidMonth) {
                sb.append("#").append(i).append(" YYMM\n");
            } else {
                sb.append("#").append(i).append(" AMBIGUOUS\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean isValidMonth(String str) {
        int month = Integer.parseInt(str);
        return month >= 1 && month <= 12;
    }
}
