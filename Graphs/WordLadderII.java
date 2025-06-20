import java.util.*;
public class WordLadderII extends Solution{
    public static void main(String args[]){

    }
}
// User function Template for Java
class Solution {
    public ArrayList<ArrayList<String>> findSequences(String startWord,
                                                      String targetWord,
                                                      String[] wordList) {
        // Code here
        HashSet<String> set =new HashSet<>();
        int level=0;
        for(String word: wordList){
            set.add(word);
        }
        Queue<ArrayList<String>> queue=new LinkedList<>();
        queue.add(new ArrayList(Arrays.asList(startWord)));
        ArrayList<ArrayList<String>> ans =new ArrayList<ArrayList<String>>();
        ArrayList<String> usedlevel=new ArrayList<>();
        usedlevel.add(startWord);
        while(!queue.isEmpty()){
            ArrayList<String> topList=queue.poll();
            if(topList.size()>level){
                level++;
                for(String string:usedlevel){
                    set.remove(string);
                }
            }
            if(targetWord.equals(topList.get(topList.size()-1))){
                if(ans.size()==0 || ans.get(0).size()==topList.size()) ans.add(topList);
                else break;
            }
            for(int i=0;i<targetWord.length();i++){
                StringBuffer sb=new StringBuffer(topList.get(topList.size()-1));
                for(char j='a';j<='z';j++){
                    sb.setCharAt(i,j);
                    String temp=sb.toString();
                    if(set.contains(temp)){
                        ArrayList<String> updated=new ArrayList<String>(topList);
                        updated.add(temp);
                        queue.add(updated);
                        usedlevel.add(temp);
                    } 
                }
            }
        }
        return ans;
    }
}