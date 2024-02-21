import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_숫자만들기 {

    static int[] operator = new int[4];
    static int[] number;
    static int N, maxResult, minResult;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int idx = 1;

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            number = new int[N];
            maxResult = Integer.MIN_VALUE;
            minResult = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                operator[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                number[i] = Integer.parseInt(st.nextToken());
            }

            backTracking(1, number[0]);
            bw.write("#" + idx + " " + (maxResult - minResult) + "\n");
            idx++;
        }
        bw.flush();
    }

    static void backTracking(int idx, int currentMax) {
        if (idx == N) {
            maxResult = Math.max(maxResult, currentMax);
            minResult = Math.min(minResult, currentMax);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                int calResult = calculate(currentMax, number[idx], i);
                backTracking(idx + 1, calResult);
                operator[i]++;
            }
        }
    }

    static int calculate(int num1, int num2, int op) {
        switch (op) {
            case 0:
                return num1 + num2;
            case 1:
                return num1 - num2;
            case 2:
                return num1 * num2;
            case 3:
                return num1 / num2;
        }
        return 1;
    }

}
