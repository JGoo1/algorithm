import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int base = 64;
        int count = 0;
        int target = Integer.parseInt((br.readLine()));

        while(target>0 && base>0){
            if(base>target){
                base = base >> 1;
                continue;
            }else{
                count++;
                target -= base;
            }
        }
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();

    }
}
