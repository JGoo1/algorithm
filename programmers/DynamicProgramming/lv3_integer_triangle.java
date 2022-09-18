public class lv3_integer_triangle {
    public static int solution(int[][] triangle) {
        int answer = 0;
        for(int i=1;i<triangle.length;i++){
            for(int j=0;j<triangle[i].length;j++){
                int left = 0, right = 0;
                if(j>0) {
                    left = triangle[i - 1][j - 1];
                }
                if(j<triangle[i-1].length){
                    right=triangle[i-1][j];
                }

                triangle[i][j] += Math.max(left, right);
            }
        }
        int idx = triangle.length-1;
        for(int i=0;i<triangle[idx].length;i++){
            answer = Math.max(answer, triangle[idx][i]);
        }


        return answer;
    }
    public static void main(String[] args){
        int[][] triangle = {{7,},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
        int answer = solution(triangle);
        System.out.println(answer);
    }

}
