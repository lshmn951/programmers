#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> heights) {
    vector<int> answer;
    stack<pair<int,int>> tower;
    answer.push_back(0);
    tower.push({heights[0],1});
    for(int i=1;i<heights.size();i++){
        int h = tower.top().first;
        int idx = tower.top().second;
        if(h>heights[i]){
            answer.push_back(idx);
            tower.push({heights[i],i+1});
        }
        else{
            while(!tower.empty()){
                h = tower.top().first;
                idx = tower.top().second;
                if(h>heights[i]){
                    break;
                }
                else{
                    tower.pop();
                }
            }
            if(tower.empty()){
                answer.push_back(0);
            }
            else{
                answer.push_back(idx);
            }
            tower.push({heights[i],i+1});
        }

    }
    return answer;
}
vector<int> solution2(vector<int> heights) {
    // dp
    vector<int> answer;
    int max=0;
    for(int i=0;i<heights.size();i++){
        if(heights[i]>=max){
            max = heights[i];
            answer.push_back(0);
        }
        else{
            for(int j=i-1;j>=0;j--){
                if(heights[j]>heights[i]){
                    answer.push_back(j+1);
                    break;
                }else{
                    j = answer[j];
                }
            }
        }
    }
    return answer;
}

int main(){
    vector<int> heights = {6,9,5,7,4};
    vector<int> answer = solution(heights);
    for(int i=0;i<answer.size();i++){
        cout << answer[i] << " ";
    }
    cout << "\n";
    
    heights = {3,9,9,3,5,7,2};
    answer = solution(heights);
    for(int i=0;i<answer.size();i++){
        cout << answer[i] << " ";
    }
    cout << "\n";

    
    heights = {1,5,3,6,7,6,5};
    answer = solution(heights);
    for(int i=0;i<answer.size();i++){
        cout << answer[i] << " ";
    }
    cout << "\n";
}