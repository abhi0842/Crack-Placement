package Graph;
import java.util.*;
public class WordLadder {
    public int ladderLength(String beginWord, String endword, List<String> wordList) {
        if(!wordList.contains(endword)){
            return 0;
        }
        HashSet<String> set=new HashSet<>();
        for(String word:wordList){
          set.add(word);
        }
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        int res=1;



        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String curr=q.poll();
                char[] temp=curr.toCharArray();
                for(int j=0;j<curr.length();j++){
                  char ori=temp[j];
                    for(char c='a';c<='z';c++){
                       if(temp[j]==c)continue;
                       temp[j]=c;
                       String newword=String.valueOf(temp);
                       if(newword.equals(endword)){
                            return res+1;
                        }
                        if(set.contains(newword)){
                            q.offer(newword);
                            set.remove(newword);
                        }
                    }
                    temp[j]=ori;
                }
            }
            res++;

        }
        return 0;
    }

}
