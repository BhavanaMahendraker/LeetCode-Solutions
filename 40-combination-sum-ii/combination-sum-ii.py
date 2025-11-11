class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        res = []

        def dfs(start, comb, total):

            if total == target:
                res.append(tuple(comb))
                return
            
            # if start > len(candidates) or total > target:
            #     return
            
            for i in range(start, len(candidates)):
                if i > start and candidates[i] == candidates[i-1]:
                    continue
                if total + candidates[i] > target:
                    break
                comb.append(candidates[i])
                dfs(i+1, comb, total + candidates[i])
                comb.pop()
        dfs(0, [], 0)
        return res