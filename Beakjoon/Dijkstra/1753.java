import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int u,v,w;

        ArrayList<Edge>[] arrList = new ArrayList[V+1];
        boolean[] visited = new boolean[V+1];
        int[] node = new int[V+1];

        int start = Integer.parseInt(br.readLine());

        for(v=1; v<=V;v++){
            arrList[v] = new ArrayList();
            if(v==start){
                pq.add(new Edge(v,0));
                node[v] = 0;
            }else{
                node[v] = Integer.MAX_VALUE;
            }
        };

        for(int e=0;e<E;e++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            arrList[u].add(new Edge(v,w));
        }

        while(!pq.isEmpty()){
            Edge current = pq.poll();

            if(visited[current.v]) continue;

            visited[current.v]=true;
            node[current.v] = current.weight;

            for(int i=0;i<arrList[current.v].size();i++){
                Edge next = arrList[current.v].get(i);
                if(!visited[next.v] && node[next.v]>current.weight + next.weight){
                    pq.add(new Edge(next.v,current.weight + next.weight));
                }
            }

        }

        for(int i=1;i<=V;i++){
            if(visited[i]){
                bw.write(node[i] + "\n");
            }else{
                bw.write("INF\n");
            }
        }

        bw.flush();
        bw.close();

    }
    static class Edge implements Comparable<Edge>{
        int v, weight;
        public Edge(int v, int weight){
            this.v = v;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.weight, o.weight);
        }
    }
}

