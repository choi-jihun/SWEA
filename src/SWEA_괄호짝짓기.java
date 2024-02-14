import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class SWEA_괄호짝짓기 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int test = 1; test <= 10; test++) {
            int N = Integer.parseInt(br.readLine());
            Stack<Character> stack = new Stack();
            boolean isBalanced = true;
            String str = br.readLine();
            for (int i = 0; i < N; i++) {
                char ch = str.charAt(i);
                switch (ch) {
                    case '(':
                    case '{':
                    case '<':
                    case '[': {
                        stack.push(ch);
                        break;
                    }
                    case ')': {
                        if (stack.isEmpty() || stack.pop() != '(') {
                            isBalanced = false;
                        }
                        break;
                    }
                    case '}': {
                        if (stack.isEmpty() || stack.pop() != '{') {
                            isBalanced = false;
                        }
                        break;
                    }
                    case ']': {
                        if (stack.isEmpty() || stack.pop() != '[') {
                            isBalanced = false;
                        }
                        break;
                    }
                    case '>': {
                        if (stack.isEmpty() || stack.pop() != '<') {
                            isBalanced = false;
                        }
                        break;
                    }
                }
                if (!isBalanced) {
                    break;
                }
            }
            if (isBalanced && stack.isEmpty()) {
                sb.append("#").append(test).append(" 1\n");
            } else {
                sb.append("#").append(test).append(" 0\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
