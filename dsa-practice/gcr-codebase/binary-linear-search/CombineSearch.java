import java.util.*;

public class CombineSearch{
    public static int linearSearch(int[] arr){
        int n = arr.length;
        Set<Integer> set = new HashSet<>();

        for(int j = 0; j < n; j++){
            set.add(arr[j]);
        }

        for(int i = 1; i <= n+1; i++){
            if(!set.contains(i)){
                return i;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] arr, int target){
        Arrays.sort(arr);
        int n = arr.length;
        int left = 0, right = n-1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target) right = mid-1;
            else left = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.println("Linear Search: " + linearSearch(arr));
        System.out.println("Binary Search: " + binarySearch(arr, target));
    }
}