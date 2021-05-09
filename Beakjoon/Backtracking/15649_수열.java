import java.io.*;
import java.util.StringTokenizer;

public class test011 {

    public static BufferedWriter bw;
    public static int[] used;
    public static int N,M;
    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        used = new int[N+1];
        findCombination(1);
        bw.flush();
        bw.close();
    }

    public static void findCombination(int level) throws IOException {
        if(level>M){
            for(int val=1;val<=M;val++){
                for(int i=1;i<=N;i++){
                    if(used[i]==val) bw.write(i+" ");
                }
            }
            bw.write("\n");
        }else{
            for(int i=1;i<=N;i++){
                if(used[i]>0){
                    continue;
                }else{
                    used[i] = level;
                    findCombination(level+1);
                    used[i] = 0;
                }
            }
        }
    }
}
