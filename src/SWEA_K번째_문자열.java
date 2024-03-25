import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class SWEA_K번째_문자열 {

    static HashSet<String> set;
    static boolean[] visited;
    static String temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int K = Integer.parseInt(br.readLine());
            set = new HashSet<String>();
            temp = br.readLine();
            visited = new boolean[temp.length()];

            makePer();
            List<String> list = new ArrayList<String>(set);
            Collections.sort(list);
            bw.write(String.format("#%d %s\n", tc, list.get(K - 1)));
        }
        bw.flush();
    }

    static void makePer() {
        for (int i = 0; i < temp.length(); i++) {
            for (int j = i + 1; j <= temp.length(); j++) {
                set.add(temp.substring(i, j));
            }
        }
    }

}