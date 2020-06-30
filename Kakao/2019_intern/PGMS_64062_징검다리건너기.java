package programmers;

public class PGMS_64062_징검다리건너기 {

	public static void main(String[] args) {
		int [] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		System.out.println(solution(stones, 3));

	}
	public static int solution(int[] stones,int k) {
		int size = stones.length;
	    int left = 0;
	    int right = 200000000;
	    int mid;
	    while(left<right){
	        mid = (left+right)/2;
	        if(check(mid,stones,k,size)){
	            left = mid+1;
	        }
	        else{
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
	        if(cnt>=k){
	            return false;
	        }
	    }
	    return true;
	}
}
