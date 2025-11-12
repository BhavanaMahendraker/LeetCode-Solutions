class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        self.res = []
        nums.sort()
        self.dfs(nums, [], 0)
        return self.res

    def dfs(self, nums, comb, i):
        if i == len(nums):
            self.res.append(comb.copy())
            return
        
        comb.append(nums[i])
        self.dfs(nums, comb, i+1)
        comb.pop()

        while i+1 < len(nums) and nums[i] == nums[i+1]:
            i += 1
        self.dfs(nums, comb, i+1)