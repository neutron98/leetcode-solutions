class FindNth 
{ 
    // Return n-th number in series made of 4 and 7 
    static int printNthElement(int n) 
    { 
        // create an array of size (n+1) 
        int arr[] = new int[n+1]; 
        arr[1] = 4; 
        arr[2] = 7; 
       
        for (int i=3; i<=n; i++) 
        { 
            // If i is odd 
            if (i%2 != 0) 
                arr[i] = arr[i/2]*10 + 4; 
            else
                arr[i] = arr[(i/2)-1]*10 + 7; 
        } 
        return arr[n]; 
    }     

} 
