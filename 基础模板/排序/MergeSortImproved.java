public class MergeSortImproved {

    public static void mergeSort(int[] from){
        int n = from.length;
        int[] to = new int[n];
        for (int len = 1; len < n; len = len + len){
            for (int i = 0; i < n - len; i += len + len){
                int left = i;
                int mid = i + len - 1;
                int right = Math.min(i + len + len - 1, n - 1);
                merge(from, to, left, mid, right);
            }
        }
    }

    private static void merge(int[] from, int[] to, int left, int mid, int right){
        for (int i = left; i <= right; i++){
            to[i] = from[i];
        }

        int k = left, j = mid + 1;
        for (int i = left; i <= right; i++){
            if (k > mid){
                from[i] = to[j++];
            } else if(j > right){
                from[i] = to[k++];
            } else if(to[k] > to[j]){
                from[i] = to[j++];
            } else{
                from[i] = to[k++];
            }
        }
    }
}
