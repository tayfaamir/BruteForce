
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;




public class hw {
    public  static class edge implements Comparable<edge>{
        int value;
        int v;
        int u;

        public edge(int value, int v, int u) {
            this.value = value;
            this.v = v;
            this.u = u;
        }

        @Override public int compareTo(edge s)
        {
            if (value > s.value) {
                return 1;
            }
            else if (value == s.value) {
                return 0;
            }
            else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        long[][] d = new long[310][310];
        boolean[][] mark = new boolean[310][310];
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();
        int N = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = scanner.nextLong();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                mark[i][j] = true;
            }
        }
        int ans = (n*(n-1))/2;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if(d[i][j] != d[j][i]){
                    System.out.println(-1);
                    System.exit(0);
                }
                for (int k = j+1; k < N; k++) {
                    if(d[i][j] + d[j][k] < d[i][k]) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                    if(d[i][k] + d[j][k] < d[i][j]) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                    if(d[i][k] + d[i][j] < d[j][k]) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                    if(d[i][j] + d[j][k] == d[i][k] && mark[i][k] == true) {
                        ans--;
                        mark[i][k] = false;
                    }
                    if(d[i][k] + d[k][j] == d[i][j] && mark[i][j] == true) {
                        ans--;
                        mark[i][j] = false;
                    }
                    if(d[k][i] + d[i][j] == d[k][j] && mark[j][k] == true) {
                        ans--;
                        mark[j][k] = false;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
