package programmers;

public class PGMS_49993_스킬트리 {

	public static void main(String[] args) {
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(solution("CBD", skill_trees));
	}
	public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        out:for(int i=0;i<skill_trees.length;i++) {
        	StringBuilder sb = new StringBuilder();
        	for(int j=0;j<skill_trees[i].length();j++) {
        		char c = skill_trees[i].charAt(j);
        		if(skill.indexOf(c)!=-1) {// 스킬트리에 포함되어 있는 스킬들을 순서대로 저장
        			sb.append(c);
        		}
        	}
        	for(int j=0;j<sb.length();j++) {
        		if(sb.charAt(j)!=skill.charAt(j)) {// 저장한 스킬들이 스킬트리 규칙을 지키지 못한다면
        			continue out;
        		}
        	}
        	answer++;
        }
        return answer;
    }
}
