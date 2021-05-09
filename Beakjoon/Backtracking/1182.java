import java.io.*;
import java.util.*;

public class Main {

    public static int[] arr;
    public static boolean[] used;
    public static int N,S,totCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        totCount = 0;
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        used = new boolean[N];
        for(int n=0;n<N;n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        backtrack(0);
        System.out.print(totCount);

    }

    public static void backtrack(int level){
        if(level == N){
            int sum = 0;
            int count =0;
            for(int i=0;i<N;i++){
                if(used[i]){
                    sum+=arr[i];
                    count++;
                }
            }
            if(count>0 && sum==S){
                totCount+=1;
            }
        }else{
            used[level] = false;
            backtrack(level+1);
            used[level] = true;
            backtrack(level+1);
        }
    }
}

