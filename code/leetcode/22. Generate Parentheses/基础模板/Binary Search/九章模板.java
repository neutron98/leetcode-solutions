
class BinarySearch{
    public int firstPosition(int[] nums, int target){
        if(nums==null || nums.length==0){
            return -1;
        }
        int start = 0, end=nums.length - 1;
        //相邻就退出循环
        //start = 1,end = 2就要退出
        while(start+1<end){
            //int mid = (start+end)/2，当start, end~ 2^31时会越界
            //装逼用
            int mid = (end - start)/2 + start;
            if(target==nums[mid]){
                end = mid;  //不能写成return mid
            }
            else if(target<nums[mid]){
                //end = mid -1一样，但是需要想得清楚
                end = mid;
            }
            else{
                //start = mid+1
                start = mid;
            } 
        }
        
        //double check
        if(nums[start] == target){
            return start;
        }
        if(nums[end]==target){
            return end;
        }
        return -1;
    }
   
}
