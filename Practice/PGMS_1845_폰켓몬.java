package programmers;

import java.util.HashSet;
import java.util.Set;

public class PGMS_1845_폰켓몬 {

	public static void main(String[] args) {
		int [] nums1 = {3,1,2,3};
		System.out.println(solution(nums1));
		
		int [] nums2 = {3,3,3,2,2,4};
		System.out.println(solution(nums2));
		
		int [] nums3 = {3,3,3,2,2,2};
		System.out.println(solution(nums3));

	}
	public static int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++) {
        	set.add(nums[i]);
        }
        if(nums.length/2<=set.size()) {
        	answer = nums.length/2;
        }else {
        	answer = set.size();
        }
        return answer;
    }
}
