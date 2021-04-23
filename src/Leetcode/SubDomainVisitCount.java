package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Leetcode : 811. Subdomain Visit Count
Input: 
["9001 discuss.leetcode.com"]
Output: 
["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]

Input: 
["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
Output: 
["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]*/
public class SubDomainVisitCount {

	public static void main(String[] args) {
		String[] subDomain = {"9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"};
		List<String> visitList = subdomainVisits(subDomain);
		visitList.forEach(op->System.out.println(op));


	}
	public static List<String> subdomainVisits(String[] cpdomains) {
		Map<String, Integer> counts = new HashMap();
		for (String domain: cpdomains) {
			String[] cpinfo = domain.split("\\s+");
			String[] frags = cpinfo[1].split("\\.");
			int count = Integer.valueOf(cpinfo[0]);
			String cur = "";
			for (int i = frags.length - 1; i >= 0; --i) {
				cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
				counts.put(cur, counts.getOrDefault(cur, 0) + count);
			}
		}

		List<String> ans = new ArrayList();
		for (String dom: counts.keySet())
			ans.add("" + counts.get(dom) + " " + dom);
		return ans;
	}

	public static List<String> subdomainVisitsList(String[] cpdomains) {

		Map<String,Integer> map = new HashMap<>();

		for (int i=0;i<cpdomains.length;i++){
			boolean firstTime = true;
			String orgString = cpdomains[i];
			String[] spaceSplitArray = orgString.split(" ");
			int count = Integer.parseInt(spaceSplitArray[0]);

			String[] dotSplitArray = spaceSplitArray[1].split("\\.");
			String myString = "";

			for (int j= (dotSplitArray.length)-1 ;j>=0 ;j--){

				if (firstTime){
					myString = dotSplitArray[j]+myString;
					firstTime=false;
				}else {
					myString = dotSplitArray[j]+"."+myString;
				}

				if (map.containsKey(myString)){ 
					int temp = map.get(myString);
					map.put(myString,temp+count);                                        
				}else {
					map.put(myString,count);                                    
				}                                            
			}                                                                                    
		}


		List<String> answer = new ArrayList<>();

		for (Map.Entry<String,Integer> he : map.entrySet()){

			String temp = he.getValue().toString() +" "+ he.getKey();
			answer.add(temp);
		}
		return answer;
	}
}