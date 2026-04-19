class Solution {
    public int maxScore(String s) {
        int countOnes = 0, countZeroes = 0;
        int res = 0;

        for(char ch: s.toCharArray()){
            if(ch == '1'){
                countOnes++;
            }
        }

        // notice we are skipping last element since we need a split
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i) == '0'){
                countZeroes++;
            } else{
                countOnes--;
            }
            res = Math.max(res, countZeroes + countOnes);
        }

        return res;
    }
}