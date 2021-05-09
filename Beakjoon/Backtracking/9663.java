import java.io.*;

public class Main {

    public static int totCount = 0;
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        arr = new int[T][T];
        checknode(0);

        bw.write(""+totCount);
        bw.flush();
        bw.close();
    }

    public static void checknode(int level){
        for(int i=0;i<arr.length;i++){
            arr[level][i] = 1;
            if(checkPossibility(level,i)){
                if(level == arr.length-1){
                    totCount += 1;
                }else{
                    checknode(level+1);
                }
            }
            arr[level][i] = 0;
        }
    }

    public static boolean checkPossibility(int level, int idx){

        //열 체크
        for(int i=0;i<level;i++){
            if(arr[i][idx] == 1) return false;
        }

        //대각선 체크
        int nextLevel,nextLeft,nextRight;
        for(int i=1;i<=level;i++){
            nextLevel = level-i;
            nextLeft = idx-i;
            nextRight = idx+i;
            if(nextLevel>=0 && nextLeft>=0 && arr[nextLevel][nextLeft] == 1) return false;
            if(nextLevel>=0 && nextRight<arr.length && arr[nextLevel][nextRight] == 1) return false;
        }
        return true;
    }
}

