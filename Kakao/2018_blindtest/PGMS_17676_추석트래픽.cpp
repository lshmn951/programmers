#include <bits/stdc++.h>
using namespace std;

int solution(vector<string> lines) {
    int answer = 0;
    int size = lines.size();
    vector<int> end;
    vector<int> start;
    int h,m,s;
    int proc;
    for(int i=0;i<size;i++){
        h = stoi(lines[i].substr(11,2));
        m = stoi(lines[i].substr(14,2));
        string temp = lines[i].substr(17,2)+lines[i].substr(20,3);
        s = stoi(temp);
        temp = lines[i].substr(24);
        temp.pop_back();
        proc = stod(temp)*1000;
        int addtime = h*3600*1000+m*60*1000+s;
        end.push_back(addtime);
        start.push_back(addtime-proc+1);
    }
    sort(start.begin(),start.end());
    for(int i=0;i<size;i++){
        int cnt = 1;
        for(int j=i+1;j<size;j++){
            if(end[i]+1000>start[j]){
                cnt++;
            }
            else{
                break;
            }
        }
        answer = max(answer,cnt);
    }
    return answer;
}

int main(){
    vector<string> str = {"2016-09-15 00:00:00.000 3s"};
    cout << solution(str) << "\n";
    str = {"2016-09-15 23:59:59.999 0.001s"};
    cout << solution(str)<< "\n";
    str = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
    cout << solution(str)<< "\n";
    str = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
    cout << solution(str)<< "\n";
    str = {"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"};
    cout << solution(str)<< "\n";
    str = {"2016-09-15 00:00:00.000 2.3s", "2016-09-15 23:59:59.999 0.1s"};
    cout << solution(str)<< "\n";
}