#include <bits/stdc++.h>
using namespace std;

bool pro(string p){
    stack<char> st;
    for(int i=0;i<p.length();i++){
        if(p[i]=='('){
            st.push('(');
        }
        else{
            if(st.empty()){
                return false;
            }
            else{
                st.pop();
            }
        }
    }
    return st.empty();
}
string solution(string p) {
    string answer = "";
    if(p.length()==0){
        return "";
    }
    if(pro(p)){
        return p;
    }
    string u,v;
    int o = 0;
    int c = 0;
    for(int i=0;i<p.length();i++){
        if(p[i]=='('){
            o++;
        }
        else if(p[i]==')'){
            c++;
        }
        if(o==c){
            u = p.substr(0,i+1);
            v = p.substr(i+1);
            break;
        }
    }
    if(pro(u)){
        answer = u + solution(v);
    }
    else{
        answer+="(";
        answer+=solution(v);
        answer+=")";
        u = u.substr(1,u.length()-2);
        for(int i=0;i<u.length();i++){
            if(u[i]=='('){
                answer+=")";
            }
            else{
                answer+="(";
            }
        }
    }
    return answer;
}

int main(){
    cout << solution("(()())()") << "\n";
    cout << solution(")(") << "\n";
    cout << solution("()))((()") << "\n";
}