class MCM{
    public static void main(String args[]){
     int[]dim={10,20,5,10,2};
     int n=dim.length;
     int dp[][]=new int [n][n];
     int ar[][]=new int [n][n];
     for(int d=1;d<n-1;d++){
        for(int i=1;i<n-d;i++){
           int j=i+d;
           int min=Integer.MAX_VALUE;
           for(int k=i;k<j;k++){
            int  q=dp[i][k]+dp[k+1][j]+dim[i-1]*dim[k]*dim[j];
             if(q<min){
                min=q;
                ar[i][j]=k;
             }
           }
           dp[i][j]=min;
        }
      } 
       System.out.println("COST MATRIX");
      for(int i=1 ; i <dp.length;i++){
         for(int j=1;j<dp[i].length;j++){
            System.out.print(dp[i][j]+" ");
         }
         System.out.println();
      }
      System.out.println("PARENTHESIS MATRIX");
      for(int i=1 ; i <ar.length;i++){
        for(int j=1;j<ar[i].length;j++){
           System.out.print(ar[i][j]+" ");
        }
        System.out.println();
     }
     }
}