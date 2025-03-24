package ImplicitGraphsGeneMutation_LC;
/*A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is defined as one single character changed in the gene string.

- For example, "AACCGGTT" --> "AACCGGTA" is one mutation.

There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.

Given the two gene strings startGene and endGene and the gene bank bank, return *the minimum number of mutations needed to mutate from* startGene *to* endGene. If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, so it might not be included in the bank.

Example 1:

Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]

Output: 1

Example 2:

Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]

Output: 2

Constraints:

- 0 <= bank.length <= 10
- startGene.length == endGene.length == bank[i].length == 8
- startGene, endGene, and bank[i] consist of only the characters ['A', 'C', 'G', 'T']. */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class geneMutationSolution{
    static HashSet<String> bankSet=new HashSet<String>();
	static HashMap<String,Boolean> seen=new HashMap<>();
    static char[] chars1= new char[]{'A','C','G','T'};
    public static void main(String[] args){
        String startGene="AACCGGTT";
        String endGene="AACCGGTA";
        String[] bank=new String[]{"AACCGGTA"};
        int answer=minMutation(startGene,endGene,bank);
        System.out.println(answer);
    }
    public  static int minMutation(String startGene, String endGene, String[] bank){
        if(startGene.equals(endGene)){
			return 0;
		}
        //build bankSet
		for(int i=0;i<bank.length;i++){
			bankSet.add(bank[i]);
		}
        Queue<State> queue= new LinkedList<>();
		queue.add(new State(startGene,0));
        seen.put(startGene,true);
		while(!queue.isEmpty()){
            State state=queue.remove();
			String gene=state.geneStr;
			int steps=state.steps;
			if(gene.equals(endGene)){
				return steps;
			}
            for(String neighbor:nextNeighbors(gene,endGene,steps)){
				if(!seen.containsKey(neighbor)){
					seen.put(gene,true);
					queue.add(new State(neighbor,steps+1));
				}
			}
        }
        return -1;
    }
    public static boolean isValid(String gene){
		return bankSet.contains(gene);
	}
    public static List<String> nextNeighbors(String gene,String endGene,int steps){
        List<String> neighbors=new ArrayList<>();
        for(int i=0;i<8;i++){
            //i is the position in given gene
			char x=gene.charAt(i);
            for(int j=0;j<4;j++){
                // locate the postion of x in chars1
				// j is the position in our chars1
				// we use all the other characters in chars1 to replace that ith position. 
				// we need to construct a new string, use substring
				if(x!=chars1[j]){
					 String newGeneStr=gene.substring(0,i)+(""+chars1[j])+ gene.substring(i+1);
					 if(isValid(newGeneStr)){
						 neighbors.add(newGeneStr);
					 }
				}
            }
         }
        return neighbors;
    }

}