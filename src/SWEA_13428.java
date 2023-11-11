import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_13428 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            String str = br.readLine();
            char[] ch = str.toCharArray();
            int min = Integer.parseInt(str);
            int max = Integer.parseInt(str);
            for (int j = 0; j < ch.length; j++) {
                for (int k = j + 1; k < ch.length; k++) {
                    swap(ch, j, k);
                    if (ch[0] != '0' && Integer.parseInt(String.valueOf(ch)) < min) {
                        min = Integer.parseInt(String.valueOf(ch));
                    }
                    if (ch[0] != '0' && Integer.parseInt(String.valueOf(ch)) > max) {
                        max = Integer.parseInt(String.valueOf(ch));
                    }
                    swap(ch, j, k);
                }
            }
            sb.append("#").append(i).append(" ").append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    static void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
