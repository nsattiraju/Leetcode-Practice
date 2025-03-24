package GenerateParenthesis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParenthesisSolution {
    public static List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        char[] openP=new char[n];
        Arrays.fill(openP, '(');
        char[] closeP=new char[n];
        Arrays.fill(closeP, ')');
        StringBuilder sb=new StringBuilder();
        sb.append('(');
        backtracking(ans,sb,openP,closeP,n,0);
        return ans;
    }
    public static void backtracking(List<String> ans,StringBuilder sb,char[] openP,char[] closeP,int n,int i){
        if(sb.length()==2*n){
            ans.add(sb.toString());
            return;
        }
        for(int j=i;j<n;j++){
            if(sb.charAt(sb.length()-1)=='('){
                sb.append(closeP[j]);
            }else{
                sb.append(openP[j]);
            }
            backtracking(ans,sb,openP,closeP,n,i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args){
        int n=3;
        List<String> answer=generateParenthesis(3);
        System.out.println(answer);
    }
}
