class Solution {
public:
    vector<int> replaceElements(vector<int>& arr) {
//         int max=-1;
//        for(int i=arr.size()-1;i>=0;i--)
//           {
    
//             if(arr[i]<max){arr[i]=max;}
//             else{swap(arr[i],max);}
//           }
//         return arr;
        
//         int n=arr.size();
//         int max=-1;
//         for(int i=n-1;i>=0;i--){
//             int temp=arr[i];
//             arr[i]=max;
//             if(max<temp){
//                 max=temp;
//             }
            
            
//         }
//         return(arr);
        
        int n = arr.size();
        int maxv = arr[n-1];

        if(n == 0 || n==1)
            return {-1};

        for(int i=n-2; i>=0; i--){

            int temp = arr[i];

            arr[i] = maxv;
            
            if(maxv < temp)
                maxv = temp;
        }

    arr[n-1] = -1;
    return arr;
        
        
    }
};
