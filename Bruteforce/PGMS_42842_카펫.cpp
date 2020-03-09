#include <bits/stdc++.h>
using namespace std;

vector<int> solution(int brown, int red) {
    vector<int> answer;
    int sum = brown+red; // 총 격자 수
    for(int i=1;i<=(int)sqrt(sum);i++){ // 격자 수 인수분해
        if(sum%i==0){ // 인수분해 가능하면
            int temp = sum/i;
            if(brown==(temp+i)*2-4){  // 테두리 격자 수가 brown과 같다면 정답
                answer.push_back(temp);
                answer.push_back(i);
                return answer;
            }
        }
    }
}

int main(void){
    vector<int> res = solution(10,2);
    cout << res[0] << " " << res[1] << "\n";
    res = solution(8,1);
    cout << res[0] << " " << res[1] << "\n";
    res = solution(24,24);
    cout << res[0] << " " << res[1] << "\n";
}