import java.util.Arrays;
import java.util.Random;
class MergeSort{
    public static int[] merge(int[] arr1,int[] arr2){
       int i=0;
       int j=0;
       int k=0;
       int[] result=new int[arr1.length+arr2.length];
       while(i<arr1.length && j<arr2.length){
          if(arr1[i]<arr2[j]){
             result[k]=arr1[i];
             k++;
             i++;
          }
          else{
            result[k]=arr2[j];
            k++;
            j++;
          }
       }
       while(i<arr1.length){
         result[k]=arr1[i];
         i++;
         k++;
       }
       while(j<arr2.length){
        result[k]=arr2[j];
        j++;
        k++;
      }
      return result;
    }

    public static int randomNumber(){
        Random rand=new Random();
        return rand.nextInt(1000);
    }

    public static int[] sort(int[]arr){
    if(arr.length==1){
       return arr;
    }
    int mid=arr.length/2;
    int[]left=sort(Arrays.copyOfRange(arr,0,mid));
    int[]right=sort(Arrays.copyOfRange(arr,mid,arr.length));
    return merge(left,right);
    }

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
    int n=100000;
    int[]arr=new int[n];
    int i=0;
    while(i<n){
        arr[i]=randomNumber();
        i++;
      }
     arr=sort(arr);
     System.out.println(Arrays.toString(arr)); 
     long end=System.currentTimeMillis();
     System.out.println("That took " + (end-start) + " milliseconds");  
    }
}