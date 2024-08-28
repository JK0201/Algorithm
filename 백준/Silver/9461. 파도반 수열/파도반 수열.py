import sys
t = int(sys.stdin.readline().strip())

memo = {}
def dfs(n):
    if n == 0:
        return 0

    if n == 1 or n == 2:
        return 1
    
    if n not in memo:
        memo[n] = dfs(n-2) + dfs(n-3)

    return memo[n]

for _ in range(t):
    n = int(sys.stdin.readline().strip())
    print(dfs(n))