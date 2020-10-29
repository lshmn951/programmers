package monthchallenge;

public class month10_2 {
	public static void main(String[] args) {
		
	}
	public int[] solution(int[][] arr) {
		int size = arr.length;
        int[] answer = sum(arr,0,0,size);
        
        return answer;
    }
	public int[] sum(int[][] arr,int x, int y, int size) {
		int [] a = new int [2];
		int start = arr[x][y];
		boolean flag = true;
		out: for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(arr[i][j]!=arr[x][y]) {
					flag = false;
					break out;
				}
			}
		}
		if(flag) {
			if(start==0) {
				a[0] = 1;
				a[1] = 0;
			}else {
				a[0] = 0;
				a[1] = 1;
			}
		}else {
			int [] a11 = sum(arr,x,y,size/2);
			int [] a21 = sum(arr,x+size/2,y,size/2);
			int [] a12 = sum(arr,x,y+size/2,size/2);
			int [] a22 = sum(arr,x+size/2,y+size/2,size/2);
			a[0] = a11[0]+a21[0]+a12[0]+a22[0];
			a[1] = a11[1]+a21[1]+a12[1]+a22[1];
		}
		return a;
	}
}
