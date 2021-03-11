import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static int T;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        T = Integer.parseInt(br.readLine());
        char [][] map = new char[T][T];

        for(int i=0;i<T;i++){
            //StringTokenizer st = new StringTokenizer(br.readLine(),'');
            String input = br.readLine();
            for (int j=0;j<T;j++){
                map[i][j] = input.charAt(j);
            }
        }
        for (int i=0;i<T;i++){
            for(int j=0;j<T;j++){
                if(map[i][j]=='1'){
                    pq.add(searchArea(map,i,j));
                }
            }
        }
        bw.write(Integer.toString(pq.size()));
        while(!pq.isEmpty()){
            bw.write("\n");
            bw.write(Integer.toString(pq.poll()));
        }
        bw.flush();
        bw.close();
    }

    public static int searchArea(char[][] map, int i, int j){
        int result = 1;
        map[i][j]='0';

        if(i-1>=0 && map[i-1][j]=='1'){
            result += searchArea(map, i-1, j);
        }
        if(i+1<T && map[i+1][j]=='1'){
            result += searchArea(map, i+1, j);
        }
        if(j-1>=0 && map[i][j-1]=='1'){
            result += searchArea(map, i, j-1);
        }
        if(j+1<T && map[i][j+1]=='1'){
            result += searchArea(map, i, j+1);
        }
        return result;
    }
}
