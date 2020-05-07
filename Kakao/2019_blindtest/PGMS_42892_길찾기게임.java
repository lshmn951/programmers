package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class PGMS_42892_길찾기게임 {

	public static void main(String[] args) {
		int [][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		int [][] answer = solution(nodeinfo);
		System.out.println(Arrays.toString(answer[0]));
		System.out.println(Arrays.toString(answer[1]));
	}
	static int idx=0;
	public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        int [][] arr = new int [nodeinfo.length][3];
        
        for(int i=0;i<nodeinfo.length;i++) {
        	arr[i][0] = nodeinfo[i][0];
        	arr[i][1] = nodeinfo[i][1];
        	arr[i][2] = i+1;
        }
        Arrays.sort(arr,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]<o2[1]) {
					return 1;
				}else if(o1[1]>o2[1]) {
					return -1;
				}else {
					return 0;
				}
			}
		});
        TreeNode tree = new TreeNode(arr[0][0],arr[0][2]);
        for(int i=1;i<arr.length;i++) {
        	insert(tree,arr[i][0],arr[i][2]);
        }
        idx = 0;
        preorder(tree,answer);
        idx = 0;
        postorder(tree,answer);
        return answer;
    }
	public static class TreeNode{
		int x;
		int idx;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x,int idx) {
			this.x = x;
			this.idx = idx;
			this.left = null;
			this.right = null;
		}
	}
	public static TreeNode insert(TreeNode p,int x,int idx) {
		TreeNode newNode = new TreeNode(x,idx);
		if(p==null) {
			return newNode;
		}else if(p.x>newNode.x) {
			p.left = insert(p.left,x,idx);
			return p;
		}else if(p.x<newNode.x) {
			p.right = insert(p.right,x,idx);
			return p;
		}else {
			return p;
		}
	}
	public static void preorder(TreeNode root,int [][] arr) {
		if(root!=null) {
			arr[0][idx++] = root.idx;
			preorder(root.left,arr);
			preorder(root.right,arr);
		}
	}
	public static void postorder(TreeNode root,int [][] arr) {
		if(root!=null) {
			postorder(root.left,arr);
			postorder(root.right,arr);
			arr[1][idx++] = root.idx;
		}
	}
}
