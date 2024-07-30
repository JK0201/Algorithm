n = int(input())
nums = list(map(int, input().split()))
min_num = nums[0]
max_num = nums[0]

for n in nums:
    if n < min_num:
        min_num = n
    
    elif n > max_num:
        max_num = n
        
print(min_num, max_num)