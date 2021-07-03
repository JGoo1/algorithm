import java.util.*;

class Solution {
    public static int count = 0;

    public static int numTilePossibilities(String tiles) {
        Map<Character, Integer>  titleMap = stringToMap(tiles);

        Character[] keys = titleMap.keySet().toArray(Character[]::new);
        int[] values = new int[keys.length];
        for(int i=0;i<keys.length;i++){
            values[i] = titleMap.get(keys[i]);
        }

        recursive(keys,values);

        return count;
    }

    public static Map<Character,Integer> stringToMap(String titles){
        Map<Character, Integer> map = new HashMap<>();
        char[] charArr = titles.toCharArray();
        for(int i=0;i<charArr.length;i++){

            if(!map.containsKey(charArr[i])){
                map.put(charArr[i],1);
            }else{
                map.replace(charArr[i],map.get(charArr[i])+1);
            }

        }

        return map;
    }
    public static void recursive(Character[] keys, int[] values){
        for(int i=0;i<keys.length;i++){
            if(values[i]>0){
                count++;
                values[i]--;
                recursive(keys,values);
                values[i]++;
            }
        }
    }

    public static void main(String[] args){
        String title = "V";
        int res = numTilePossibilities(title);
        System.out.println(res);
    }
}