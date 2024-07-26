import sys
from collections import deque

t = int(sys.stdin.readline().strip())
nums = [i for i in range(1, 1023 + 1)]


class Node:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

class BinaryTree:
    def __init__(self):
        self.root = None
        
    def add_node(self, nums):
        self.root = Node(nums[0])
        q = deque([self.root])
        i = 1
        
        while q:
            cur_node = q.popleft()
            
            if i < len(nums):
                cur_node.left = Node(nums[i])
                q.append(cur_node.left)
            i += 1
            
            if i < len(nums):
                cur_node.right = Node(nums[i])
                q.append(cur_node.right)
            i += 1
            
    def case_postorder(self, cur_node, p, q):
        if cur_node == None:
            return None
        
        left = self.case_postorder(cur_node.left, p, q)
        right = self.case_postorder(cur_node.right, p, q)
        
        if cur_node.val == p or cur_node.val == q:
            return cur_node.val
        
        if left and right:
            return cur_node.val
        
        return left or right
    
bt = BinaryTree()
bt.add_node(nums)

for _ in range(t):
    i, j = map(int, sys.stdin.readline().split())
    print(bt.case_postorder(bt.root, i, j) * 10)