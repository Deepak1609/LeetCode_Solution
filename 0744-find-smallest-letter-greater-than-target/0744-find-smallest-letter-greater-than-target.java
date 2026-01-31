class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return letters[left % letters.length];
    }
}


// class Solution {
//     public char nextGreatestLetter(char[] letters, char target) {
//         char res = letters[0];
//         boolean flag = false;

//         for(char ch : letters){
//             if(!flag){
//                 if(ch > target){
//                     res = ch;
//                     flag = !flag;
//                 }
//             } else {
//                 if(ch > target && ch < res)res = ch;
//             }
//         }

//         return res;
//     }
// }