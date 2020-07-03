package programmers;

public class PGMS_64062_징검다리건너기 {

	public static void main(String[] args) {
		int [] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		System.out.println(solution(stones, 3));

	}
	public static int solution(int[] stones,int k) {
		int size = stones.length;
	    int left = 0;
	    int right = 200000000; // stones 배열 각 원소들의 최대값 (니니즈 친구들은 무제한이므로)
	    int mid;
	    while(left<right){// 이분탐색을 통해 징검다리를 건널 수 있는 니니즈 친구들의 수를 찾는다
	        mid = (left+right)/2;
	        if(check(mid,stones,k,size)){ // 징검다리를 건널 수 있다면 더 큰 수를 탐색
	            left = mid+1;
	        }
	        else{ // 징검다리를 못 건너면 작은 수를 탐색
	            right = mid;
	        }
	    }
	    return --left;
	}
	public static boolean check(int mid,int [] stones,int k, int size) {
		int cnt=0;
	    for(int i=0;i<size;i++){
	        if(stones[i]-mid+1<=0){
	            cnt++;
	        }
	        else{
	            cnt=0;
	        }
	        if(cnt>=k){ // 한번에 건너뛸 수 있는 디딤돌의 최대 칸 수를 넘으면 못건넌다
	            return false;
	        }
	    }
	    return true;
	}
}
