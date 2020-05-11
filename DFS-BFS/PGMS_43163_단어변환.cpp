#include <bits/stdc++.h>
using namespace std;

bool check(string str1,string str2){//알파벳 한 개만 달라서 변환이 가능한지 체크
    int cnt=0;
    for(int i=0;i<str1.length();i++){
        if(str1[i]!=str2[i]){
            cnt++;
        }
    }
    return cnt==1;
}

int solution(string begin, string target, vector<string> words) {
    bool b = false;
    int size = words.size();
    for(int i=0;i<size;i++){
        if(words[i].compare(target)==0){//words에 target이 있는지 확인
            b = true;
        }
    }
    if(b){//words에 target이 있다면
        bool visit[size];
        fill(visit,visit+size,false);
        queue<pair<string,int>> que;
        que.push({begin,0});
        while(!que.empty()){
            string temp = que.front().first;
            int cnt = que.front().second;
            que.pop();
            if(temp.compare(target)==0){//변환이 완료되면 몇 단계를 거쳤는지 반환하고 종료
                return cnt;
            }
            for(int i=0;i<size;i++){
                if(!visit[i] && check(temp,words[i])){
                    visit[i] = true;
                    que.push({words[i],cnt+1});
                }
            }
        }
    }
    return 0;//words에 target이 없거나 변환이 불가능한 경우 0을 리턴
}

int main(){
    cout << solution("hit","cog",{"hot", "dot", "dog", "lot", "log", "cog"});
    cout << "\n";
    cout << solution("hit","cog",{"hot", "dot", "dog", "lot", "log"});
}