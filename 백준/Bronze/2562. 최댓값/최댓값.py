import sys
nums = list(map(int, sys.stdin.read().split()))

max_num = max(nums)
print(max_num)
    
for i in range(len(nums)):
    if nums[i] == max_num:
        print(i + 1)