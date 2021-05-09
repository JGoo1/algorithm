import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class test004 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int stNode = Integer.parseInt(br.readLine());

        ArrayList<NodeInfo>[] arrLists = new ArrayList[V + 1];
        int[] minCosts = new int[V+1];

        for (int i = 0; i <= V; i++){
            arrLists[i] = new ArrayList<>();
            minCosts[i] = Integer.MAX_VALUE;
        }

        int from,to,val;
        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            val = Integer.parseInt(st.nextToken());

            arrLists[from].add(new NodeInfo(to,val));
            //arrLists[to].add(new NodeInfo(from,val));
        }

        PriorityQueue<NodeInfo> pq = new PriorityQueue<>();
        pq.add(new NodeInfo(stNode,0));

        NodeInfo current,next;
        while(!pq.isEmpty()){
            current = pq.poll();
            for(int i=0;i<arrLists[current.idx].size();i++){
                next = arrLists[current.idx].get(i);
                if(minCosts[next.idx]>current.val+next.val){
                    minCosts[next.idx]=current.val+next.val;
                    pq.add(new NodeInfo(next.idx,minCosts[next.idx]));
                }
            }
        }
        for(int i=1;i<=V;i++){
            if(i==stNode){
                bw.write("0\n");
            }else if(minCosts[i]==Integer.MAX_VALUE){
                bw.write("INF\n");
            }else{
                bw.write(minCosts[i]+"\n");
            }
        }

        bw.flush();
        bw.close();

    }

    public static class NodeInfo implements Comparable<NodeInfo>  {
        int idx,val;
        NodeInfo(int idx, int val){
            this.idx=idx;
            this.val=val;
        }

        @Override
        public int compareTo(NodeInfo nodeInfo) {
            return this.val - nodeInfo.val;
        }
    }
}


