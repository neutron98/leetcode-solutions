import java.util.Arrays;

public class ReorderListString {
    public static String reorderList(String input){
        String[] arr = input.split("-");
        int n = arr.length;
        int mid = n/2;

        reverse(arr, mid, n - 1);

        int p1 = 0;
        int p2 = mid;

        StringBuilder builder = new StringBuilder();

        while (p1 < mid && p2 < n){
            builder.append(arr[p1]);
            builder.append('-');
            p1++;

            builder.append(arr[p2]);
            builder.append('-');
            p2++;
        }
        if (p2 < n){
            builder.append(arr[p2]);
            builder.append('-');
        }
        builder.setLength(builder.length() - 1);
        return builder.toString();
    }

    private static void reverse(String[] arr, int start, int end){
        int l = start, r = end;
        while (l < r){
            String temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args){
        System.out.println(reorderList("1-2-3-4"));
        System.out.println(reorderList("1-2-3-4-5"));
        System.out.println(reorderList("1-2-3-4-5-6"));
    }
}
