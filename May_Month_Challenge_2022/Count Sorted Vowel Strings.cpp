class Solution {
public:
    int countVowelStrings(int n) {
//         int a=1, e=1, i=1, o=1, u=1;
        
//         while(--n){
//             o += u;
//             i += o;
//             e += i;
//             a += e;
//         }
        
//         return a+e+i+o+u;
         int ans = 1;
        for(int i=0; i<n; i++){
            ans *= (5 + i);
            ans/=(i + 1);
        }
        return ans;
        
    }
};
