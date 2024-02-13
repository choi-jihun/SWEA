import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_View {

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int test = 1; test <= 10; test++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;
            for (int i = 2; i < N - 2; i++) {
                if (arr[i] > arr[i - 2] && arr[i] > arr[i + 2] && arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    sum += arr[i] - Math.max(arr[i - 2], Math.max(arr[i + 2], Math.max(arr[i - 1], arr[i + 1])));
                }
            }
            sb.append("#").append(test).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);

    }

}
