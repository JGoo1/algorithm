import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<NodeInfo>[] arrLists = new ArrayList[N+1];
        long[] minCost = new long[N+1];
        for(int i=0;i<=N;i++){
            arrLists[i] = new ArrayList<>();
            minCost[i] = Long.MAX_VALUE;
        }

        int from,to,val;
        for(int m=0;m<M;m++){
            st =new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            val = Integer.parseInt(st.nextToken());

            arrLists[from].add(new NodeInfo(to,val));
        }

        NodeInfo next;

        minCost[1] =0;

        for(int count=1;count<N;count++){
            for(int current=1;current<=N;current++){
                for(int i=0;i<arrLists[current].size();i++){
                    next = arrLists[current].get(i);
                    if(minCost[current] != Long.MAX_VALUE && minCost[next.idx]>minCost[current]+next.val){
                        minCost[next.idx] = minCost[current]+next.val;
                    }
                }
            }
        }


        boolean isFail = false;

        for(int current=1;current<=N;current++){
            if(isFail) break;
            for(int i=0;i<arrLists[current].size();i++){
                next = arrLists[current].get(i);
                if(minCost[current] != Long.MAX_VALUE && minCost[next.idx]>minCost[current]+next.val){
                    isFail = true;
                    break;
                }
            }
        }

        if(isFail){
            bw.write("-1");
        }else{
            for(int i=2;i<=N;i++){
                if(minCost[i]==Long.MAX_VALUE){
                    bw.write("-1");
                }else{
                    bw.write(minCost[i]+"");
                }
                if(i!=N) bw.write("\n");
            }
        }

        bw.flush();
        bw.close();

    }
    public static class NodeInfo implements Comparable<NodeInfo>{
        int idx, val;
        NodeInfo(int idx, int val){
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(NodeInfo nodeInfo) {
            return this.val-nodeInfo.val;
        }
    }
}
