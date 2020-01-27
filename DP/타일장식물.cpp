#include <string>
#include <vector>

using namespace std;

long long solution(int N) {
    long long answer = 0;
    long long tile[80]={0};
    tile[1] = 1;
    for(int i=2;i<=N+1;i++){
        tile[i] = tile[i-1] +tile[i-2];
    }
    return 2*(tile[N+1]+tile[N]);
}