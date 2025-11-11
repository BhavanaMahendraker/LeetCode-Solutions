class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        def dfs(i, comb):
            if i == len(nums):
                res.append(list(comb))
                return
            dfs(i+1, comb)
            comb.append(nums[i])
            dfs(i+1, comb)
            comb.pop(-1)
        dfs(0, [])
        return res
