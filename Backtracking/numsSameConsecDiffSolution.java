package Numbers_With_Same_Consecutive_Difference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class numsSameConsecDiffSolution {
    public static int[] numsSameConsecDiff(int n,int k) {
        List<Integer> ans=new ArrayList<>();

        for(int i=1;i<=9;i++){
            backtrack(ans,i,k,1,n);
        }

        int[] arr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }
    public static void backtrack(List<Integer> ans,int num, int k, int count,int n){
        if(count==n){
            ans.add(num);
            return;
        }
        // take the units digit and add k to it.
            int uDigit=num%10;
            if(uDigit+k<10){
                int newDigit=num*10 + (uDigit+k);
                backtrack(ans,newDigit,k,count+1,n);
            }else if(k!=0 && uDigit-k>=0){
                int newDigit=num*10+(uDigit-k);
                backtrack(ans,newDigit,k,count+1,n);
            }
    }


    public static void main(String[] args){
        int n=3;
        int k=7;
        int[] answer=numsSameConsecDiff(n,k);
        System.out.println(answer);
    }
}
