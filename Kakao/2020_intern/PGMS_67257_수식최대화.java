package kakao2020_internship;

public class PGMS_67257_수식최대화 {

	public static void main(String[] args) {
		String e = "100-200*300-500+20";
		System.out.println(solution(e));
		
		String e2 = "50*6-3*2";
		System.out.println(solution(e2));
	}
	static long max;
	static String str;
	public static long solution(String expression) {
		char [] oper = {'*','+','-'};
        max = 0;
        permutation(expression, 3, 0, new boolean [3], oper, new char [3]);
        return max;
    }
	public static void permutation(String expression,int n,int k,boolean [] visit,char[] oper,char [] temp) {
		if(n==k) {
			str = new String(expression);
			max = Math.max(max, Math.abs(calc(temp)));
		}else {
			for(int i=0;i<oper.length;i++) {
				if(!visit[i]) {
					visit[i] = true;
					temp[k] = oper[i];
					permutation(expression,n, k+1, visit, oper, temp);
					visit[i] = false;
				}
			}
		}
	}
	public static long calc(char[]temp) {
		for(int i=0;i<3;i++) {
			char c = temp[i];
			for(int j=0;j<str.length();j++) {
				char s = str.charAt(j);
				if(s==c) {
					String left="";
					int l;
					if(s=='-'&&str.charAt(j-1)=='(') {
						continue;
					}
					if(str.charAt(j-1)==')') {
						for(l=j-2;l>=0;l--) {
							if(str.charAt(l)=='(') {
								break;
							}else {
								left = str.charAt(l)+left;
							}
						}
					}else {
						for(l=j-1;l>=0;l--) {
							if(Character.isDigit(str.charAt(l))) {
								left = str.charAt(l)+left;
							}else {
								l++;
								break;
							}
						}
					}
					String right="";
					int r ;
					if(str.charAt(j+1)=='(') {
						for(r=j+2;r<str.length();r++) {
							if(str.charAt(r)==')') {
								r++;
								break;
							}else {
								right+=str.charAt(r);
							}
						}
					}else {
						for(r=j+1;r<str.length();r++) {
							if(Character.isDigit(str.charAt(r))) {
								right+=str.charAt(r);
							}else {
								break;
							}
						}
					}
					
					String o = operation(left, right, c);
					if(o.charAt(0)=='-') {
						o = "("+o+")";
					}
					if(l<0) {
						l=0;
					}
					str = str.substring(0,l)+o+str.substring(r);
					j=0;
				}
			}
		}
		if(str.charAt(0)=='(') {
			str = str.substring(1,str.length()-1);
		}
		return Long.parseLong(str);
	}
	public static String operation(String left,String right,char oper) {
		long l = Long.parseLong(left);
		long r = Long.parseLong(right);
		if(oper=='*') {
			long res = l*r;
			return Long.toString(res);
		}else if(oper=='+') {
			long res = l+r;
			return Long.toString(res);
		}else {
			long res = l-r;
			return Long.toString(res);
		}
	}
}
