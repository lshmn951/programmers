#include <bits/stdc++.h>
using namespace std;

int dirs[4][2] = {{-1,0},{0,1},{1,0},{0,-1}};
int N;
struct Robot{
    int x,y;
    int state;
    int cnt;
    Robot(int x,int y,int state,int cnt){
        this->x = x;
        this->y = y;
        this->state = state;
        this->cnt = cnt;
    }
};
bool isin(int x,int y,int s){
    //로봇이 보드안에 있는지 검사
    if(x<0||y<0||x>=N||y>=N){
        return false;
    }
    x += dirs[s][0];
    y += dirs[s][1];
    if(x<0||y<0||x>=N||y>=N){
        return false;
    }
    return true;
}

bool check(int x,int y,int d1,int d2,vector<vector<int>> &board){
    //로봇이 90도 회전할 때 대각선 방향 검사
    int r = x+dirs[d1][0]+dirs[d2][0];
    int c = y+dirs[d1][1]+dirs[d2][1];
    return board[r][c]==0;
}

int solution(vector<vector<int>> board) {
    int answer = 0;
    N = board.size();
    bool visit[N][N][4];
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            for(int s=0;s<4;s++){
                visit[i][j][s] = false;
            }
        }
    }
    queue<Robot> q;
    q.push(Robot(0,0,1,0));
    q.push(Robot(0,1,3,0));
    visit[0][0][1] = true;
    visit[0][1][3] = true;
    while(!q.empty()){
        Robot temp = q.front();
        q.pop();
        int x2 = temp.x+dirs[temp.state][0];
        int y2 = temp.y+dirs[temp.state][1];
        if((temp.x==N-1&&temp.y==N-1)||(x2==N-1&&y2==N-1)){//도착
            answer = temp.cnt;
            break;
        }
        for(int i=0;i<4;i++){//상하좌우 이동
            int r = temp.x+dirs[i][0];
            int c = temp.y+dirs[i][1];
            int r2 = x2+dirs[i][0];
            int c2 = y2+dirs[i][1];
            if(isin(r,c,temp.state)&&board[r][c]==0&&board[r2][c2]==0&&!visit[r][c][temp.state]){
                visit[r][c][temp.state] = true;
                q.push(Robot(r,c,temp.state,temp.cnt+1));
            }

        }
        int dir2 = (temp.state+2)%4;
        //로봇의 두 축에서 각각 90도(시계,반시계)로 회전
        for(int i=0;i<2;i++){
            int d1 = temp.state+dirs[0][i]+i;
            int d2 = dir2+dirs[0][i]+i;
            if(d1<0){
                d1 = 3;
            }
            if(d2<0){
                d2 = 3;
            }
            d1 %= 4;
            d2 %= 4;
            if(isin(temp.x,temp.y,d1)){
                int r = temp.x+dirs[d1][0];
                int c = temp.y+dirs[d1][1];
                if(check(temp.x,temp.y,temp.state,d1,board)&&board[r][c]==0&&!visit[temp.x][temp.y][d1]){
                    visit[temp.x][temp.y][d1] = true;
                    q.push(Robot(temp.x,temp.y,d1,temp.cnt+1));
                }
            }
            if(isin(x2,y2,d2)){
                int r = x2+dirs[d2][0];
                int c = y2+dirs[d2][1];
                if(check(x2,y2,dir2,d2,board)&& board[r][c]==0&&!visit[x2][y2][d2]){
                    visit[x2][y2][d2] = true;
                    q.push(Robot(x2,y2,d2,temp.cnt+1));
                }
            }
        }
    }
    return answer;
}

int main(void){

    vector<vector<int>> board = {{0,0,0,1,1},
                                {0,0,0,1,0},
                                {0,1,0,1,1},
                                {1,1,0,0,1},
                                {0,0,0,0,0}};
    cout << solution(board);
}