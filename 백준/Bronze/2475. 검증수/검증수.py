import sys
nums = list(map(int, sys.stdin.readline().split()))
answer = 0

for n in nums:
    answer += n**2
    
print(answer % 10)