import java.io.*;

public class test4811 {
    public static long[][] memo;
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N, result;
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N==0){
                break;
            }

            memo = new long[N+1][N+1];
            visited = new boolean[N+1][N+1];
            bw.write(findMaxVal(N,0) + "\n");

        }
        bw.flush();
    }

    public static long findMaxVal(int W, int H){
        if(visited[W][H]){
            return memo[W][H];
        }

        if(W==0){
            memo[W][H]=1L;
        }else{
            if(H==0){
                memo[W][H] = findMaxVal(W-1,H+1);
            }else{
                memo[W][H] = findMaxVal(W-1,H+1) + findMaxVal(W,H-1);
            }
        }

        visited[W][H] = true;
        return memo[W][H];
    }
}
