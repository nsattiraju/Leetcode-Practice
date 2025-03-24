package org.mavendemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationSolution {
/*BackTracking*/

    public static List<String> letterCombinations(String Digits){
        List<String> ans=new ArrayList<>();
        HashMap<Character,char[]> map=new HashMap<>();
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});
        char[] input=Digits.toCharArray();
        int inputLen=input.length;
        //ArrayList<Character> values=new ArrayList<>();
//        for(char i:input){
//            char[] letters=map.get(i);
//            for(char l:letters){
//                values.add(l);
//            }
//        }
        StringBuilder sb=new StringBuilder();
        backtracking(sb,input,map,0, ans,inputLen);
        return ans;

    }
    public static void backtracking(StringBuilder sb,char[] input,HashMap<Character,char[]> map, int i, List<String> ans, int inputLength){
        if(sb.length()==inputLength){
            ans.add(sb.toString());
            return;
        }
        char[] possibleValues=map.get(input[i]);
        for(char c:possibleValues){
            sb.append(c);
            backtracking(sb,input,map,i+1,ans,inputLength);
            sb.deleteCharAt(sb.length()-1);

        }
    }
    public static void main(String[] args){
        List<String> answer= letterCombinations("23");
        for(String s:answer){
            System.out.println(s);
        }
    }
}