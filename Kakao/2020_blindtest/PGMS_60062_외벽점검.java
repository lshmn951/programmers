package programmers;


public class PGMS_60062_외벽점검 {

	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		int [] weak1 = {1,5,6,10};
		int [] dist1 = {1,2,3,4};
		min = Integer.MAX_VALUE;
		System.out.println(solution(12, weak1, dist1));
		int [] weak2 = {1,3,4,9,10};
		int [] dist2 = {3,5,7};
		min = Integer.MAX_VALUE;
		System.out.println(solution(12, weak2, dist2));

	}
	public static int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        int size = weak.length;
        for(int i=0;i<size;i++) {
        	for(int j=1;j<=dist.length;j++) {
        		//dist 배열에서 1개 부터 dist길이 개수 만큼 숫자를 순열을 통해 뽑고 검사
        		per(j,0,new boolean[dist.length],weak,dist,new int[j]);
        	}
        	// 점검을 시작할 위치를 바꿔주는 작업
        	int up = weak[0];
        	for(int j=0;j<size-1;j++) {
        		weak[j] = weak[j+1];
        	}
        	weak[size-1] = up+n;
        }
        if(min==Integer.MAX_VALUE) {
        	// 점검이 불가능할 경우
        	answer = -1;
        }
        else {
        	// 점검 가능할 경우 최소 인원이 정답
        	answer = min;
        }
        return answer;
    }
	public static void per(int r,int k,boolean [] visit,int []weak,int []dist,int []temp) {
		if(r==k) {
			if(check(weak,temp)) {
				// 순열로 뽑아낸 인원들을 통해 점검을 완료할 수 있다면 min값을 최솟값으로 갱신
				min = Math.min(min, r);
			}
		}
		else {
			for(int i=0;i<dist.length;i++) {
				if(!visit[i]) {
					visit[i] = true;
					temp[k] = dist[i];
					per(r, k+1, visit, weak, dist, temp);
					visit[i] = false;
				}
			}
		}
	}
	public static boolean check(int []weak,int[] temp) {
		int size = temp.length;
		int idx = 0; // 점검을 진행중인 weak배열의 인덱스
		int st = weak[0]; // st는 한 인원이 점검을 시작한 위치
		for(int i=0;i<size;i++) {//뽑아낸 인원 수 만큼
			for(int j=idx;j<weak.length;j++) {
				if(st+temp[i]<weak[j]) { // 현재 점검 중인 인원이 1시간에 점검할 수 있는 위치를 벗어났을 경우
					st = weak[j]; // 다음 인원이 점검을 시작할 위치를 st에 대입 
					break;
				}
				else {
					// 점검할 weak 배열의 인덱스 이동
					idx++;
				}
			}
		}
		if(idx==weak.length) {// 점검을 완료한 경우
			return true;
		}
		return false;
	}
}
