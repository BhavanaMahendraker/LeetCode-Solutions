class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        def backtrack(openN, closeN, comb):
            if len(comb) == n * 2:
                res.append("".join(comb))
                return
            
            if openN < n:
                comb.append('(')
                backtrack(openN + 1, closeN, comb)
                comb.pop()
            
            if closeN < openN:
                comb.append(')')
                backtrack(openN, closeN + 1, comb)
                comb.pop()
        
        backtrack(0, 0, [])
        return res