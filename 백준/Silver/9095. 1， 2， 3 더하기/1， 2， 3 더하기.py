import sys
n = int(sys.stdin.readline().strip())

memo = {0:1, 1:1, 2:2}
def dp(n):
    for i in range(3, n+1):
        memo[i] = memo[i-1] + memo[i-2] + memo[i-3]
        
    return memo[n]

for _ in range(n):
    num = int(sys.stdin.readline().strip())
    print(dp(num))