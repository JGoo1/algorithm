import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();


        int[] words2_to_arr = new int[26];

        ArrayList<Integer>[] word2_to_arr_list = new ArrayList[words2.length];
        for(int i=0;i<words2.length;i++){
            int[] word_to_arr =  word_to_int_arr(words2[i]);
            for(int j=0;j<26;j++){
                if(words2_to_arr[j]<word_to_arr[j]){
                    words2_to_arr[j] = word_to_arr[j];
                }
            }
        }



//        for(int i=0;i<words2_to_int.length;i++){
//            System.out.println(Arrays.toString(words2_to_int[i]));
//        }

        for(int i=0;i< words1.length;i++){
            boolean is_universal = true;
            int[] word1_int_arr = word_to_int_arr(words1[i]);

            for(int idx=0;idx<26;idx++){
                if(word1_int_arr[idx]<words2_to_arr[idx]) {
                    is_universal = false;
                    break;
                }
            }
            if(is_universal){
                res.add(words1[i]);
            }
        }


        return res;
    }

    public static int[] word_to_int_arr(String word){
        int[] word_to_int_arr = new int[26];
        char[] word_to_char = word.toCharArray();
        for(int i=0;i<word_to_char.length;i++){
            int idx = ((int)word_to_char[i])-97;
            word_to_int_arr[idx]++;
        }
        return word_to_int_arr;
    }

    public static void main(String[] args){
        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"ec","oc","ceo"};
        List<String> res = wordSubsets(words1,words2);
        System.out.println(res);
        //97~122
        //System.out.println((int)'z');
    }
}