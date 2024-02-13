import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Flatten {
    static int maxDiff = 0;
    static int[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int test = 1; test <= 10; test++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr = new int[100];
            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                flatten();
            }

            sb.append("#").append(test).append(" ").append(maxDiff).append("\n");
        }
        System.out.println(sb);
    }

    static void flatten() {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxIdx = -1;
        int minIdx = -1;

        for (int i = 0; i < 100; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
            if (max == arr[i]) {
                maxIdx = i;
            }
            if (min == arr[i]) {
                minIdx = i;
            }
        }
        arr[maxIdx]--;
        arr[minIdx]++;

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        for(int i = 0; i <100; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        maxDiff = max - min;
    }

}
