import java.util.Arrays;
class KnapSack01{
    public static void main(String args[]){
     int[]wt={2,4,3,1};
     int[]val={4,2,3,2};
     int W=6;
     int[][]dp=new int[wt.length+1][W+1];
    for(int i=0;i<dp.length;i++){
        for(int j=0;j<dp[i].length;j++){
          if(i==0 || j==0){
            dp[i][j]=0;
          }
          else if(wt[i-1]<=j){
             dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-wt[i-1]]+val[i-1]);
          }
          else{
            dp[i][j]=dp[i-1][j];
          }
        }
    }
    for (int i = 0; i <= wt.length; i++) {
        System.out.println(Arrays.toString(dp[i]));
    }

    }
}