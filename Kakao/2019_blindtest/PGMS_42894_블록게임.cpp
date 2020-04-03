#include <bits/stdc++.h>
using namespace std;

bool deleteblock(vector<vector<int>> &board,int x,int y,int i,int j){
    int color= -1;
    int cnt = 0;
    for(int r=x;r<x+i;r++){
        for(int c=y;c<y+j;c++){
            if(board[r][c]==0){
                int up = r;
                while(up--){
                    if(board[up][c]!=0){
                        return false;
                    }
                }
                cnt++;
            }
            else{
                if(color==-1){
                    color = board[r][c];
                }
                else{
                    if(color!=board[r][c]){
                        return false;
                    }
                }
            }
        }
    }
    if(cnt!=2){
        return false;
    }
    for(int r=x;r<x+i;r++){
        for(int c=y;c<y+j;c++){
            board[r][c] = 0;
        }
    }
    return true;
}


int solution(vector<vector<int>> board) {
    int answer = 0;
    int n = board.size();
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(i+2<=n&&j+3<=n&&deleteblock(board,i,j,2,3)){
                answer++;
                i=-1;
                break;
            }
            if(i+3<=n&&j+2<=n&&deleteblock(board,i,j,3,2)){
                answer++;
                i=-1;
                break;
            }
        }
    }
    return answer;
}

int main(){
    vector<vector<int>> board = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 4, 0, 0, 0}, {0, 0, 0, 0, 0, 4, 4, 0, 0, 0}, {0, 0, 0, 0, 3, 0, 4, 0, 0, 0}, {0, 0, 0, 2, 3, 0, 0, 0, 5, 5}, {1, 2, 2, 2, 3, 3, 0, 0, 0, 5}, {1, 1, 1, 0, 0, 0, 0, 0, 0, 5}};
    cout << solution(board);
}