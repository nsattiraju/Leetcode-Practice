package CombinationSum3;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3Solution {
    public static List<List<Integer>> CombinationSum3(int n,int k) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        backtrack(new ArrayList<Integer>(),ans,n,k,0,0,1);
        return ans;
    }
    public static void backtrack(List<Integer> currList,List<List<Integer>> ans,int n,int k, int currSum,int count, int i){
        if(currSum==n && count==k){
            ans.add(new ArrayList<>(currList));
            return;
        }else if(currSum!=n && count==k){
            return;
        }
        for(int j=i;j<10;j++){
            currSum=currSum+j;

            currList.add(j);
            backtrack(currList,ans,n,k,currSum,count+1,j+1);
            currSum=currSum-j;
            currList.remove(currList.size()-1);

        }
    }




    public static void main(String[] args){
        int n=7;
        int k=3;
        List<List<Integer>> answer=CombinationSum3(n,k);
        for(List<Integer> l:answer){
            System.out.println(l);
        }

    }
}
