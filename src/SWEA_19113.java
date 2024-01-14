import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_19113 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= TC; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[2 * N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 2 * N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            ArrayList<Integer> discount = new ArrayList<>();
            for (int i = 0; i < N * 2; i++) {
                if (arr[i] % 3 == 0) {
                    int discountPrice = arr[i];
                    discount.add(discountPrice);
                    int originalPrice = (discountPrice / 3) * 4;
                    for (int j = 0; j < 2 * N; j++) {
                        if (arr[j] == originalPrice) {
                            arr[j] = -1;
                            break;
                        }
                    }
                    arr[i] = -1;
                }
            }
            sb.append("#").append(t).append(" ");
            for (int val : discount) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
