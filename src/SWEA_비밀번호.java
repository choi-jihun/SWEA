import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_비밀번호 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        for (int test = 1; test <= 10; test++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            Stack<Integer> stack = new Stack<Integer>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                int temp = str.charAt(i) - '0';
                if (stack.isEmpty()) {
                    stack.push(temp);
                } else {
                    if (stack.peek() == temp) {
                        stack.pop();
                    } else {
                        stack.push(temp);
                    }
                }
            }

            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            String output = sb.reverse().toString();

            bw.write("#" + test + " " + output + "\n");
            bw.flush();
        }
    }

}
