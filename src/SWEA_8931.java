import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_8931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int K = Integer.parseInt(br.readLine());
            Stack<Integer> st = new Stack<>();
            int sum = 0;
            for (int j = 0; j < K; j++) {
                int x = Integer.parseInt(br.readLine());
                if (x != 0) {
                    st.push(x);
                    sum += x;
                } else {
                    sum -= st.pop();
                }
            }
            sb.append("#").append(i).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
