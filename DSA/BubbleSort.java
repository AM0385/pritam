import java.util.Arrays;
import java.util.Random;
class BubbleSort{
    static void sort(int[]arr){
        for(int i=0;i<arr.length-1;i++){
           for(int j=0;j<arr.length-1-i;j++){
             if(arr[j]>arr[j+1]){
                 int temp=arr[j];
                 arr[j]=arr[j+1];
                 arr[j+1]=temp;
             }
           }
        }

    }
    public static int generateRandomInteger(){
      Random rand = new Random();
      return rand.nextInt(1000);
    }
    public static void main(String args[]){
      int n=100000;
      int[]arr=new int[n];
      int i=0;
      long start = System.currentTimeMillis();
      while(i<n){
      arr[i]=generateRandomInteger();
      i++;
      }
     sort(arr);
     long end = System.currentTimeMillis();
     System.out.println(Arrays.toString(arr));
     System.out.println("That took " + (end-start) + " milliseconds");
     
    }
}