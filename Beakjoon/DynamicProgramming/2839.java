import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int weight = Integer.parseInt(br.readLine());
        int num, ans = -1;
        int MAX = weight<5?5:weight;
        int[] memo = new int[MAX+1];

        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(3);
        pq.add(5);

        memo[3] = 1;
        memo[5] = 1;

        while(!pq.isEmpty()){
            num = pq.poll();
            if(num==weight) {
                ans = memo[num];
                break;
            }else if(num<weight){
                if (num+3<=MAX && memo[num+3]==0){
                    memo[num+3]=memo[num]+1;
                    pq.add(num+3);
                }

                if (num+5<=MAX && memo[num+5]==0){
                    memo[num+5]=memo[num]+1;
                    pq.add(num+5);
                }
            }
        }
        System.out.println(ans);
    }
}
