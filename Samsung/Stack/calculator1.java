import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class calculator1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        exp = exp.replaceAll("\\s","");
        char[] charArr = exp.toCharArray();

        Stack<Character> stk = new Stack<>();
        String convertedExp = "";
        int result = 0;
        //후위표기법 변환
        for(int i=0;i<charArr.length;i++){
            char next = charArr[i];
            //System.out.println(next);
            if(next=='('){
                stk.add(next);
            }else if(next=='+'||next=='-'||next=='*'|| next=='/'){
                while(getLevel(stk.peek())>=getLevel(next)){
                    convertedExp += stk.pop();
                }
                stk.add(next);
            }else if(next==')'){
                while(stk.peek() != '('){
                    convertedExp += stk.pop();
                }
                stk.pop();
            }else{
                convertedExp += next;
            }
        }

        //System.out.println(convertedExp);
        //연산
        Stack<Integer> stkInt = new Stack<>();
        charArr = convertedExp.toCharArray();
        int val1, val2;
        for(int i=0;i<charArr.length;i++){
            char next = charArr[i];
            if(next=='+' || next=='-'|| next=='*'|| next=='/'){
                stkInt.add(calculate(stkInt.pop(),stkInt.pop(),next));
            }else{
                stkInt.add(Integer.parseInt(String.valueOf(next)));
            }
        }
        System.out.print(stkInt.pop());
    }

    public static int calculate(int val1, int val2, char operator){
        if(operator=='+'){
            return val2+val1;
        }else if(operator == '-'){
            return val2-val1;
        }else if(operator == '*'){
            return val2*val1;
        }else{
            return val2/val1;
        }
    }
    public static int getLevel(char s){
        if(s=='('){
            return 0;
        }else if(s=='+' || s=='-'){
            return 1;
        }else if(s=='*' || s=='/'){
            return 2;
        }else{
            return 3;
        }
    }
}
