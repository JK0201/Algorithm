import sys

n = int(input())
nums = list(map(int, sys.stdin.read().split()))
nums.sort()

for n in nums:
    print(n)