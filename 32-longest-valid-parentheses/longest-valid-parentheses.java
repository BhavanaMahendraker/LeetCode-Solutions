class Solution {
    public int longestValidParentheses(String s) {
        int open = 0, close = 0, res1 = 0;
        for(int i=0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                open++;
            } else{
                close++;
            }

            if(close > open){
                open = 0;
                close = 0;
            } else if(open == close){
                res1 = Math.max(res1, 2 * open);
            }
        }

        open = 0;
        close = 0;
        int res2 = 0;
        for(int i=s.length()-1; i>=0 ; i--){
            char ch = s.charAt(i);
            if(ch == '('){
                open++;
            } else{
                close++;
            }

            if(open > close){
                open = 0;
                close = 0;
            } else if(open == close){
                res2 = Math.max(res2, 2 * close);
            }
        }
        return Math.max(res1, res2);
    }

}