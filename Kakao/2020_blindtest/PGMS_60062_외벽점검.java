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
        		per(j,0,new boolean[dist.length],weak,dist,new int[j]);
        	}
        	int up = weak[0];
        	for(int j=0;j<size-1;j++) {
        		weak[j] = weak[j+1];
        	}
        	weak[size-1] = up+n;
        }
        if(min==Integer.MAX_VALUE) {
        	answer = -1;
        }
        else {
        	answer = min;
        }
        return answer;
    }
	public static void per(int r,int k,boolean [] visit,int []weak,int []dist,int []temp) {
		if(r==k) {
			if(check(weak,temp)) {
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
		int idx = 0;
		int st = weak[0];
		for(int i=0;i<size;i++) {
			for(int j=idx;j<weak.length;j++) {
				if(st+temp[i]<weak[j]) {
					st = weak[j];
					break;
				}
				else {
					idx++;
				}
			}
		}
		if(idx==weak.length) {
			return true;
		}
		return false;
	}
}
