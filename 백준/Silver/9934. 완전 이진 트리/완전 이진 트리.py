import sys
from collections import deque

k = int(input())
k = 2**k - 1
arr = list(map(int, sys.stdin.readline().split()))

class Node:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right
        
class BinaryTree:
    def __init__(self):
        self.root = None
        self.idx = 0
    
    def add_node(self, k):
        if k == 0:
            return
        
        self.root = Node()
        q = deque([self.root])
        i = 1
        
        while i < k:
            cur_node = q.popleft()
            
            cur_node.left = Node()
            q.append(cur_node.left)
            i += 1
            
            cur_node.right = Node()
            q.append(cur_node.right)
            i += 1
        
    def add_value(self, cur_node):
        if cur_node == None:
            return
        
        left = self.add_value(cur_node.left)
        
        if left == None:
            cur_node.val = arr[self.idx]
            self.idx += 1

        self.add_value(cur_node.right)
    
    def print_level_order(self, cur_node):
        visited = []
        if cur_node == None:
            return
        
        q = deque()
        q.append((cur_node, 0))
        
        while q:
            cur_node, cur_depth = q.popleft()
            
            if len(visited) <= cur_depth:
                visited.append([])
            
            visited[cur_depth].append(cur_node.val)

            if cur_node.left:
                q.append((cur_node.left, cur_depth + 1))
            
            if cur_node.right:
                q.append((cur_node.right, cur_depth + 1))
        
        for i in range(len(visited)):
            for j in range(len(visited[i])):
                print(visited[i][j], end=' ')
            print()
            
bt = BinaryTree()
bt.add_node(k)
bt.add_value(bt.root)
bt.print_level_order(bt.root)