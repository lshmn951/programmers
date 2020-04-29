package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class PGMS_42748_k번째수 {

	public static void main(String[] args) {
		int []array = {1,5,2,6,3,7,4};
		int [][]commands= {{2,5,3},{4,4,1},{1,7,3}};
		int [] answer = solution(array, commands);
		System.out.println(Arrays.toString(answer));
	}
	public static int[] solution(int[] array, int[][] commands) {
        int size = commands.length;
        int[] answer = new int [size];
        for(int q=0;q<commands.length;q++) {
        	List<Integer> list = new ArrayList<Integer>();
        	int i=commands[q][0];
        	int j=commands[q][1];
        	int k=commands[q][2];
        	for(int w=i-1;w<=j-1;w++) {
        		list.add(array[w]);
        	}
        	Collections.sort(list);
        	answer[q] = list.get(k-1);
        }
        return answer;
    }
}

/*
 * vector<int> answer;
    for(int q=0;q<commands.size();q++){
        vector<int> temp;
        int i = commands[q][0];
        int j = commands[q][1];
        int k = commands[q][2];
        for(int w=i-1;w<=j-1;w++){
            temp.push_back(array[w]);
        }
        sort(temp.begin(),temp.end());
        answer.push_back(temp[k-1]);
    }
    return answer;
 */
