class AllOne {
public:

    unordered_map<string,int> count;  // stores the count of each key
    set<pair<int,string>> sep;  // sorted set to keep counts and keys

    AllOne() {
        count.clear();  // initialize the count map
    }
    
    //Increment the count of the key
    void inc(string key) {
        int n = count[key]; // get current count
        count[key]++;       // increment the count
        sep.erase({n,key}); // remove the old pair from the set
        sep.insert({n+1, key}); // insert the new pair with updated count        
    }
    
    void dec(string key) {
        int n = count[key];  // get current count
        count[key]--;          // Decrement the count
        sep.erase({n, key});    // Remove the old pair from set
        if(count[key]>0)        // if count > 0, insert updated pair
            sep.insert({n-1, key});
        else
            count.erase(key);       // if count reaches 0, remove the key from map
        
    }
    
    string getMaxKey() {
        if(!sep.empty()) 
            return sep.rbegin()->second;   // last element gives the maximum
        return "";     
    }
    
    string getMinKey() {
        if(!sep.empty())
            return sep.begin()->second;     // first element gives the minimum
        return "";
    }
};

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne* obj = new AllOne();
 * obj->inc(key);
 * obj->dec(key);
 * string param_3 = obj->getMaxKey();
 * string param_4 = obj->getMinKey();
 */