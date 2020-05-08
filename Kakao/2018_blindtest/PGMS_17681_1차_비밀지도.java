package programmers;

import java.util.Arrays;

public class PGMS_17681_1차_비밀지도 {

	public static void main(String[] args) {
		int [] arr1 = {9,20,28,18,11};
		int [] arr2 = {30,1,21,17,28};
		String[] answer = solution(5, arr1, arr2);
		System.out.println(Arrays.toString(answer));
		
		arr1 = new int [] {46,33,33,22,31,50};
		arr2 = new int [] {27,56,19,14,14,10};
		answer = solution(6, arr1, arr2);
		System.out.println(Arrays.toString(answer));
	}
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		   
	      String[] answer = new String[n];
	      String spacebar = " ";
	      for(int i=0; i<n;i++){
	          answer[i] = Integer.toBinaryString(arr1[i]|arr2[i])
	              .replace("0"," ").replace("1","#");
	          int num = n-answer[i].length();
	          for(int j =0; j<num;j++){
	              answer[i] = spacebar + answer[i];
	          }
	          
	      }
	      return answer;
	  }
}
