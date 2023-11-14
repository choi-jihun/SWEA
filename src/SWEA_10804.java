import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_10804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringBuilder sb1 = new StringBuilder(br.readLine());
            sb1.reverse();

            for (int j = 0; j < sb1.length(); j++) {
                if (sb1.charAt(j) == 'b') {
                    sb1.setCharAt(j, 'd');
                } else if (sb1.charAt(j) == 'd') {
                    sb1.setCharAt(j, 'b');
                } else if (sb1.charAt(j) == 'p') {
                    sb1.setCharAt(j, 'q');
                } else {
                    sb1.setCharAt(j, 'p');
                }
            }
            sb.append("#").append(i).append(" ").append(sb1).append("\n");
        }
        System.out.println(sb);
    }
}
