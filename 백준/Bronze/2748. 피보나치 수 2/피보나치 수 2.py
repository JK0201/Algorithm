n = int(input())

memo = {}
def fibo(n):
    if n == 0:
        return 0
    
    if n == 1 or n == 2:
        return 1
    
    if n not in memo:
        memo[n] = fibo(n-1) + fibo(n-2)
        
    return memo[n]

print(fibo(n))