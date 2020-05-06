package programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class PGMS_64061_크레인인형뽑기게임 {

	public static void main(String[] args) {
		int [][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int [] moves = {1,5,3,5,1,2,1,4};
		System.out.println(solution(board, moves));

	}
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int col = board[0].length;
        Queue<Integer> [] que = new Queue[col];// 인형을 꺼낼때 사용할 큐
        Stack<Integer> st = new Stack<Integer>();// 인형을 바구니에 담을 때 사용할 스택
        for(int i=0;i<col;i++) {
        	que[i] = new LinkedList<Integer>();
        }
        for(int i=0;i<board.length;i++) {
        	for(int j=0;j<col;j++) {
        		if(board[i][j]>0) {
        			// 각 열 마다 인형들을 위에서부터 차례대로 큐에 저장
        			que[j].add(board[i][j]);
        		}
        	}
        }
        for(int i=0;i<moves.length;i++) {
        	int c = moves[i]-1;
        	if(que[c].isEmpty()) {
        		// 한 줄(열)에서 인형을 전부 뽑아냈을 경우 아무일도 하지 않는다. 
        		continue;
        	}else {
        		int doll = que[c].poll();
        		if(st.isEmpty()) {
        			//바구니에 아무것도 없을 경우 그냥 인형을 담는다.
        			st.push(doll);
        		}else {
        			int top = st.peek();
        			// 바구니에 인형이 있을 경우 새로 뽑은 인형과 비교 
        			if(top!=doll) {
        				// 같지 않다면 인형을 담는다.
        				st.push(doll);
        			}else {
        				// 같다면 2개의 인형이 터진다.
        				answer+=2;
        				st.pop();
        			}
        		}
        	}
        }
        return answer;
    }
}
