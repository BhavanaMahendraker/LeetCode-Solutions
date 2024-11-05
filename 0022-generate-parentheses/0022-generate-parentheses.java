class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), 0, 0, n);
        return res;
    }
    
    private void helper(List<String> res, StringBuilder comb, int open, int close, int n){
        if(comb.length() == n * 2){
            res.add(new String(comb));
            return;
        }
        
        if(open < n){
            comb.append("(");
            helper(res, comb, open + 1, close, n);
            comb.deleteCharAt(comb.length() - 1);
        }
        
        if(close < open){
            comb.append(")");
            helper(res, comb, open, close + 1, n);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
}


