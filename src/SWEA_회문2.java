import java.io.*;

public class SWEA_회문2 {

    static char[][] arr;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int tc = 1; tc <= 10; tc++) {
            int temp = Integer.parseInt(br.readLine());

            arr = new char[100][100];
            max = 0;
            for (int i = 0; i < 100; i++) {
                arr[i] = br.readLine().toCharArray();
            }
            findMax();
            bw.write(String.format("#%d %d\n", temp, max));
        }
        bw.flush();
    }

    static boolean isPalin(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }

        return true;
    }

    static void findMax() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = j; k < 100; k++) {
                    sb.append(arr[i][k]);
                    String horizontalStr = sb.toString();
                    if (isPalin(horizontalStr)) {
                        max = Math.max(max, horizontalStr.length());
                    }
                }
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = j; k < 100; k++) {
                    sb.append(arr[k][i]);
                    String verticalStr = sb.toString();
                    if (isPalin(verticalStr)) {
                        max = Math.max(max, verticalStr.length());
                    }
                }
            }
        }
    }
}