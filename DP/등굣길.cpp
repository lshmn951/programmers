#include <string>
#include <vector>
#include <algorithm>
const int MOD = 1000000007;
using namespace std;

int solution(int m, int n, vector<vector<int>> puddles) {
    int arr[101][101] = {};
    fill(&arr[0][0],&arr[100][100],0);
    arr[0][0]=1;
    for(int i=0;i<puddles.size();i++){
        arr[puddles[i][1]-1][puddles[i][0]-1]=-1;
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(arr[i][j]==-1){
                continue;
            }
            if(i==0 &&j==0){
                continue;
            }
            else if(i==0){
                arr[i][j] = arr[i][j-1];
            }
            else if(j==0){
                arr[i][j] = arr[i-1][j];
            }
            else {
                arr[i][j] = (max(arr[i-1][j],0) + max(arr[i][j-1],0))%MOD;
            }
        }
    }
    return arr[n-1][m-1];
}