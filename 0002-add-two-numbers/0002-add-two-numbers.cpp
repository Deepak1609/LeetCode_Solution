/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode * ptr = new ListNode();
        ListNode *temp = ptr;
        int carry  = 0;
        
        //traverse both the list then anyone of them will not get null
        
        while(l1 != NULL || l2 != NULL || carry)
        {
            int sum  = 0;
            
            // if l1  is not null
			// add l1-> value to sum
            if(l1 != NULL)
            {
                sum += l1->val;
                l1 = l1->next;
            }
            
            // if l2  is not null
			// add l2-> value to sum
            
            if(l2 != NULL)
            {
                sum += l2->val;
                l2 = l2->next;
            }
            
            // carry to the sum
            
            sum += carry;
            
            carry = sum/10;
            
            ListNode *node = new ListNode(sum%10);
            temp->next = node;
            temp = temp->next;
        }
        return ptr->next;
        
    }
};