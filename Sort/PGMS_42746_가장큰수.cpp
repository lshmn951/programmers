#include <bits/stdc++.h>
using namespace std;

bool compare(string str1, string str2){
    return str1+str2 > str2+str1;
}

string solution(vector<int> numbers) {
    string answer = "";
    vector<string> res;
    for(int i=0;i<numbers.size();i++){
        res.push_back(to_string(numbers[i]));
    }
    sort(res.begin(),res.end(),compare);
    for(int i=0;i<res.size();i++){
        answer+=res[i];
    }
    if(answer[0]=='0'){
        return "0";
    }
    return answer;
}

int main(){
    cout << solution({6,10,2}) << "\n";
    cout << solution({3,30,34,5,9});
}