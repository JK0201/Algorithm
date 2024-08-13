import sys
n = int(sys.stdin.readline().strip())

memo = {}
def dfs(n):
    if n == 0 or n == 1:
        return 1
    
    if n == 2:
        return 2

    if n not in memo:
        memo[n] = dfs(n-1) + dfs(n-2) + dfs(n-3)

    return memo[n]

for _ in range(n):
    num = int(sys.stdin.readline().strip())
    print(dfs(num))