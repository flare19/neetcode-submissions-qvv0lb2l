class MyQueue {
    stack<int> s1;
    stack<int> s2;
public:
    MyQueue() {

    }

    void push(int x) {
        s1.push(x);
    }

    int pop() {
        if (s2.empty()) {
            while (!s1.empty()) {
                int elm = s1.top();
                s1.pop();
                s2.push(elm);
            }
        }
        int res = s2.top();
        s2.pop();
        return res;
    }

    int peek() {
        if (s2.empty()) {
            while (!s1.empty()) {
                int elm = s1.top();
                s1.pop();
                s2.push(elm);
            }
        }
        return s2.top();
    }

    bool empty() {
        return max(s1.size(), s2.size()) == 0;
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */