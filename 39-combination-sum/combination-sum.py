class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        def dfs(start, target, comb):
            if target == 0:
                res.append(comb[:])
            if target < 0:
                return
            
            for i in range(start, len(candidates)):
                comb.append(candidates[i])
                dfs(i, target - candidates[i], comb)
                comb.pop(-1)

        dfs(0, target, [])
        return res