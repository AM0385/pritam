import java.util.Arrays;
import java.util.Random;
class QuickSort{

    public static int generateRandom(){
        Random rand=new Random();
        return rand.nextInt(1000);
    }
    public static void sort(int[]arr,int low,int high ){
     if(low>=high){
        return;
     }
     int start=low;
     int end=high;
     int mid=start+(end-start)/2;
     int  pivit=arr[mid];
     while(start<=end){
        while(arr[start]<pivit){
             start++;
        }
        while(arr[end]>pivit){
              end--;
        }
        if(start<=end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
       
     }
     sort(arr,low,end);
     sort(arr,start,high);
    }
    public static void main(String[] args) {
        int n=10000;
        int[]arr=new int[n];
        int i=0;
        long start=System.currentTimeMillis();
        while(i<n){
            arr[i]=generateRandom();
            i++;
        }
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        long end=System.currentTimeMillis();
        System.out.println((end-start)+" millisecond");
    }
}