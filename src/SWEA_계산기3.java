import java.io.*;
import java.util.Stack;

public class SWEA_계산기3 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int test = 1; test <= 10; test++) {
            br.readLine();
            String str = br.readLine();
            bw.write("#" + test + " " + calculate(StringToPostfix(str)) + "\n");
            bw.flush();
        }
    }

    static String StringToPostfix(String str) {
        Stack<Character> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                sb.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && operator(ch) <= operator(stack.peek()) && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    static int calculate(String str) {
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ans = 0;
            if (ch >= '0' && ch <= '9') {
                stack.push(ch - '0');
            } else {
                if (ch == '+') {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    ans = num1 + num2;
                } else {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    ans = num1 * num2;
                }
                stack.push(ans);
            }
        }

        return stack.pop();
    }

    static int operator(char op) {
        if (op == '+') {
            return 1;
        } else {
            return 2;
        }
    }

}
