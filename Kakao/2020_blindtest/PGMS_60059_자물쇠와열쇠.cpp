#include <bits/stdc++.h>
using namespace std;

bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
    bool answer = false;
    int m = key.size();
    int n = lock.size();
    int bsize = 2*n+m-2;
    int arr [bsize][bsize];// key의 일부분을 lock과 비교해보기 위한 배열
    int copy [m][m];

    // arr 초기화
    for(int i=0;i<bsize;i++){
        for(int j=0;j<bsize;j++){
            arr[i][j] = 0;
        }
    }
    for(int cs=0;cs<4;cs++){// key 4방향으로 회전
        for(int i=n-1;i<n+m-1;i++){
            for(int j=n-1;j<n+m-1;j++){
                arr[i][j] = key[i-n+1][j-n+1];// arr의 가운데에 key 복사
            }
        }
        //key의 격자 한칸부터 전체까지 lock과 비교할 부분
        for(int r=0;r<=bsize-n;r++){
            for(int c=0;c<=bsize-n;c++){
                bool flag = true;
                //lock과 key의 일부분을 비교
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if(arr[i+r][j+c]^lock[i][j]==0){
                            // 홈이 겹치거나 홈을 채울수 없다면 맞지 않다.
                            flag = false;
                            break;
                        }
                    }
                    if(!flag){
                        break;
                    }
                }
                if(flag){
                    //자물쇠를 열 수 있는 경우
                    return flag;
                }
            }
        }
        //회전
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                copy[j][m-i-1] = key[i][j];
            }
        }
        //복사
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                key[i][j] = copy[i][j];
            }
        }
    }
    return answer;
}

int main(){
    vector<vector<int>> key = {{0,0,0},{1,0,0},{0,1,1}};
    vector<vector<int>> lock = {{1,1,1},{1,1,0},{1,0,1}};
    cout << solution(key,lock);
}