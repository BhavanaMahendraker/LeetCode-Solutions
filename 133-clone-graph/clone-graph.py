"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        return self.dfs(node, {})
    
    def dfs(self, node, oldToNewMap) -> Optional['Node']:
        if node == None:
            return None
        
        if node in oldToNewMap:
            return oldToNewMap[node]
        
        clone = Node(node.val)
        oldToNewMap[node] = clone
        for neigh in node.neighbors:
            clone.neighbors.append(self.dfs(neigh, oldToNewMap))
        
        return clone