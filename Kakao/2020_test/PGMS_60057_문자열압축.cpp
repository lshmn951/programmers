#include <bits/stdc++.h>
using namespace std;

string res = "";

void check(string cur,string temp,int cnt,int size){ 
    if(cur.compare(temp.substr(0,size))!=0){
        if(cnt>1){
            res+=to_string(cnt);
        }
        res+= cur;
        cur=temp.substr(0,size);
        cnt=0;
        if(temp.size()<size){
            res+=temp;
            return ;
        }
    }
    check(cur,temp.substr(size,temp.size()-size),cnt+1,size);
}

int solution(string s){// 200309 풀이 check()함수와 묶음
                       //함수 반복적으로 호출해서 시간 오래걸림
    int answer = INT32_MAX;
    if(s.length()==1){
        return 1;
    }
    for(int i=1;i<=s.length()/2;i++){
        res = "";
        check(s.substr(0,i),s.substr(i,s.size()),1,i);
        int tmp = res.size();
        answer = min(answer,tmp);
    }
    return answer;
}


int solution2(string s) { // 이전에 풀어둔 풀이
    if(s.length()==1){
        return 1;
    }
    int answer = 10000;
    int currentcnt;
    string len;
    string current;
    for(int i=1;i<=s.length()/2;i++){
        current="";
        currentcnt = 1;
        len ="";
        for(int j=0;j<s.length();j=j+i){
            
            string temp = s.substr(j,i);
            
            if(current.empty()){
                current = temp;
                continue;
            }
            if(current != temp){
                if(i+j>=s.length()){
                    len+=temp;
                }
                if(currentcnt>1){
                    len += current + to_string(currentcnt); 
                }
                else{
                    len += current;
                }
                current = temp;
                currentcnt = 1;
            }
            else{
                currentcnt++;
                if(i+j>=s.length()){
                    len += temp + to_string(currentcnt);
                }
            }
        }
        if(answer>len.length()){
            answer = len.length();
        }
    }
    return answer;
}

int main(void){
    cout << solution("aabbaccc") << "\n";
    cout << solution("ababcdcdababcdcd") << "\n";
    cout << solution("abcabcdede") << "\n";
    cout << solution("abcabcabcabcdededededede") << "\n";
    cout << solution("xababcdcdababcdcd") << "\n";

    cout << solution2("aabbaccc") << "\n";
    cout << solution2("ababcdcdababcdcd") << "\n";
    cout << solution2("abcabcdede") << "\n";
    cout << solution2("abcabcabcabcdededededede") << "\n";
    cout << solution2("xababcdcdababcdcd") << "\n";
}
