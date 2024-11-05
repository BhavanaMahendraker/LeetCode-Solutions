class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(new StringBuilder(), 0, 0, n, res);
        return res;
    }
    
    private void helper(StringBuilder sb, int open, int close, int n, List<String> res){
        if(sb.length() == n * 2){
            res.add(new String(sb));
            return;
        }
        
        if(open < n){
            sb.append("(");
            helper(sb, open + 1, close, n, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if(close < open){
            sb.append(")");
            helper(sb, open, close + 1, n, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}


