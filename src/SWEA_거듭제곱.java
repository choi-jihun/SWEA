import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_거듭제곱 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int test = 1; test <= 10; test++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            Stack<Integer> stack = new Stack<Integer>();
            int ans = 1;
            int num = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            for (int i = 0; i < count; i++) {
                stack.push(num);
            }
            while (!stack.isEmpty()) {
                ans *= stack.pop();
            }
            sb.append("#").append(test).append(" ").append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
