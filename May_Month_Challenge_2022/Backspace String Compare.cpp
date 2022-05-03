class Solution {
public:
    bool backspaceCompare(string s, string t) {
     string    a = finalString(s);
     string    b = finalString(t);
     return a == b;
    }
     string finalString(string d)
    {
        string temporary;
        for(char i: d)
        {
            if(temporary.size() && i == '#')
                temporary.pop_back();
            else if(i == '#');
            else
                temporary.push_back(i);
        }
        return temporary;
    }
};

// bool backspaceCompare(string s, string t) {
// stack<char> s1;
// stack<char>s2;
// int n=s.size();
// int m=t.size();
// for(int i=0;i<n;i++)
// {
// if(s[i]=='#' and !s1.empty())s1.pop();
// else if(s[i]!='#')s1.push(s[i]);
// }
// for(int i=0;i<m;i++)
// {
// if(t[i]=='#' and !s2.empty())s2.pop();
// else if(t[i]!='#')s2.push(t[i]);
// }
// return s1==s2;
// }
// };

