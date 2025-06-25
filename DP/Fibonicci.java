package DP;
import java.util.*;

public class Fibonicci {
    public static void main(String[] args) {
        int n=7;
        ArrayList<Integer> dp = new ArrayList<>();
        for(int i=0;i<=n;i++){
            dp.add(i,-1);
        }
        System.out.println(fibonicci(n,dp));
        // Space = O(2N) Time=O(N)

        dp.add(0,0);
        dp.add(1,1);
        for(int i=2;i<=n;i++){
            dp.add(i,dp.get(i-1)+dp.get(i-2));
        }
        System.out.println(dp.get(n));
        // Space = O(N) Time=O(N)

        int prev2=0,prev=1;
        for(int i=2;i<=n;i++){
            int curr=prev2+prev;
            prev2=prev;
            prev=curr;
        }
        System.out.println(n==0?prev2:prev);
        // Space = O(1) Time=O(N)
    }
    private static int fibonicci(int n,ArrayList<Integer> dp){
        if(n<=1) return n;
        if(dp.get(n)!=-1) return dp.get(n);
        return fibonicci(n-1, dp) + fibonicci(n-2, dp);
    }
}

