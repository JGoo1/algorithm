import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int from,to;
        long[][] busPrice = new long[N+1][N+1];

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                busPrice[i][j] = (i==j)?0:Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            busPrice[from][to] = Math.min(busPrice[from][to],Long.parseLong(st.nextToken()));
        }

        for(int k=1;k<=N;k++){
            for(from=1;from<=N;from++){
                for(to=1;to<=N;to++){
                    busPrice[from][to] = Math.min(busPrice[from][to], busPrice[from][k] + busPrice[k][to]);
                }
            }
        }

        for(from=1;from<=N;from++){
            for(to=1;to<=N;to++){
                bw.write(((busPrice[from][to]==Integer.MAX_VALUE)?0:busPrice[from][to]) + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}

