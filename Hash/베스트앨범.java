package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class 베스트앨범 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] gen = {"classic", "pop", "classic", "classic", "pop","k-pop"};
		int [] pla = {500, 600, 150, 800, 2500, 300};
		System.out.println(Arrays.toString(solution(gen,pla)));
	}
	public static int[] solution(String[] genres, int[] plays) {
        int[] answer;
        Album [] album = new Album[plays.length];
        List<Integer > result = new ArrayList<Integer>();
        TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
        for(int i=0;i<plays.length;i++) {
        	album[i] = new Album(genres[i],plays[i],i);
        	if(tm.containsKey(genres[i])) {
        		int ti = tm.get(genres[i]);
        		tm.put(genres[i], plays[i]+ti);
        	}
        	else {
        		tm.put(genres[i], plays[i]);
        	}
        }
        List<String> mlist = new ArrayList<String>(tm.keySet());
        Collections.sort(mlist, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return tm.get(o1).compareTo(tm.get(o2));
			}
		});
        Arrays.sort(album, new Comparator<Album>() {
			@Override
			public int compare(Album o1, Album o2) {
				if(o1.str.equals(o2.str)) {
					if(o1.play==o2.play) {
						return o1.idx<o2.idx ? -1 : 1;
					}
					else {
						return o1.play>o2.play?-1:1;
					}
				}
				else {
					return o1.str.compareTo(o2.str);
				}
			}
		});
        while(!mlist.isEmpty()) {
        	String gen = mlist.get(mlist.size()-1);
        	mlist.remove(mlist.size()-1);
        	for(int i=0;i<album.length;i++) {
        		if(album[i].str.equals(gen)) {
        			result.add(album[i].idx);
        			if(i+1<album.length && album[i+1].str.equals(gen)) {
        				result.add(album[i+1].idx);
        			}
        			break;
        		}
        	}
        }
        answer = new int [result.size()];
        for(int i=0;i<result.size();i++) {
        	answer[i] = result.get(i);
        }
        return answer;
    }
	static class Album{
		String str;
		int play;
		int idx;
		public Album(String str, int play, int idx) {
			this.str = str;
			this.play = play;
			this.idx = idx;
		}
	}
}
