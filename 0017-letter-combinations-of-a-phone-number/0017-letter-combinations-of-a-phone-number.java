class Solution {

    public void solve(List<String> res, String digits, 
                      HashMap<String, String> map, 
                      StringBuilder sb, int i){
        
        if(i >= digits.length()){
            res.add(new String(sb));
            return;
        }
        
        String str = map.get(String.valueOf(digits.charAt(i)));
        
        for(int j=0; j<str.length(); j++){
            sb.append(str.charAt(j));
            solve(res, digits, map, sb, i+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0)
            return res;
        
        HashMap map = new HashMap<String, String>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        
        
        solve(res, digits, map, new StringBuilder(), 0);
        return res;
    }
}