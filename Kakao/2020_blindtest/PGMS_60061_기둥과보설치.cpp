#include <bits/stdc++.h>
using namespace std;

bool arr[101][101][2];

bool compare(vector<int> a,vector<int> b){
    if(a[0]==b[0]){
        if(a[1]==b[1]){
            return a[2]<b[2];
        }
        else{
            return a[1]<b[1];
        }
    }
    else{
        return a[0]<b[0];
    }
}

bool ispillar(int y,int x,int arrsize){
    if(x<0||x>=arrsize||y<0||y>=arrsize||!arr[y][x][0]){
        return false;
    }
    return true;
}

bool isbeam(int y,int x,int arrsize){
    if(x<0||x>=arrsize||y<0||y>=arrsize||!arr[y][x][1]){
        return false;
    }
    return true;
}

vector<vector<int>> solution(int n, vector<vector<int>> build_frame) {
    vector<vector<int>> answer;
    n = n+1;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            arr[i][j][0] = false;
            arr[i][j][1] = false;
        }
    }
    for(int i=0;i<build_frame.size();i++){
        int x = build_frame[i][0];
        int y = build_frame[i][1];
        int a = build_frame[i][2];
        int b = build_frame[i][3];

        if(a==0){
            if(b==0){
                if(ispillar(y+1,x,n)){
                    if(!isbeam(y+1,x-1,n)&&!isbeam(y+1,x,n)){
                        continue;
                    }
                }
                if(isbeam(y+1,x-1,n)) {
					if(!ispillar(y,x-1,n) && (!isbeam(y+1,x,n) || !isbeam(y+1, x-2,n))){
						continue;
					}
				}
                
                if(isbeam(y+1,x,n)) {
					if(!ispillar(y,x+1,n) && (!isbeam(y+1,x-1,n) || !isbeam(y+1,x+1,n))) {
						continue;
					}
				}
                arr[y][x][0] = false;
            }else{
                if(y==0||ispillar(y-1,x,n)||isbeam(y,x-1,n)||isbeam(y,x,n)){
                    arr[y][x][0] = true;
                }
            }
        }else{
            if(b==0){
                if(ispillar(y,x,n)){
                    if(!isbeam(y,x-1,n)&&!ispillar(y-1,x,n)){
                        continue;
                    }
                }
                if(ispillar(y,x+1,n)){
                    if(!isbeam(y,x+1,n)&&!ispillar(y-1,x+1,n)){
                        continue;
                    }
                }
                if(isbeam(y,x-1,n)){
                    if(!ispillar(y-1,x-1,n)&&!ispillar(y-1,x,n)){
                        continue;
                    }
                }
                if(isbeam(y,x+1,n)){
                    if(!ispillar(y-1,x+1,n)&&!ispillar(y-1,x+2,n)){
                        continue;
                    }
                }
                arr[y][x][1] = false;
            }else{
                if(ispillar(y-1,x,n)||ispillar(y-1,x+1,n)||(isbeam(y,x-1,n)&&isbeam(y,x+1,n))){
                    arr[y][x][1] = true;
                }
            }
        }
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(arr[i][j][0]){
                answer.push_back({j,i,0});
            }
            if(arr[i][j][1]){
                answer.push_back({j,i,1});
            }
        }
    }
    sort(answer.begin(),answer.end(),compare);
    return answer;
}

int main(){
    int n = 5;
    vector<vector<int>> build_frame = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};
    vector<vector<int>> answer = solution(n,build_frame);
    for(int i=0;i<answer.size();i++){
        cout << answer[i][0] << " " << answer[i][1] << " " << answer[i][2];
        cout << "\n";
    }
    cout <<"\n";
    build_frame.clear();
    build_frame = {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}};
    answer = solution(n,build_frame);
    for(int i=0;i<answer.size();i++){
        cout << answer[i][0] << " " << answer[i][1] << " " << answer[i][2];
        cout << "\n";
    }
}