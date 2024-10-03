import sys

height = list(map(int, sys.stdin.read().split()))

def combination(height, k):
    res = []
    
    def backtrack(start, curr):
        if len(curr) == k and sum(curr) == 100:
            res.append(curr[:])
            return
        
        for i in range(start, len(height)):
            curr.append(height[i])
            backtrack(i + 1, curr)
            curr.pop()
    
    backtrack(0, [])
    return res[0]

res = combination(height, 7)
res.sort()

for h in res:
    print(h)