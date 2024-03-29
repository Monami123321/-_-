import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[n][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = map[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]) + map[i][0];
            dp[i][1] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]),dp[i-1][2]) + map[i][1];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]) + map[i][2];
        }
        int ans = Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
        sb.append(ans).append(" ");
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + map[i][0];
            dp[i][1] = Math.min(Math.min(dp[i - 1][0], dp[i - 1][1]),dp[i-1][2]) + map[i][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + map[i][2];
        }
        ans = Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
        sb.append(ans);
        System.out.print(sb);
        br.close();
    }
}
