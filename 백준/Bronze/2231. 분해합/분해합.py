num = int(input())
min_num = num

for i in range(1, num+1):
    digits = sum(list(map(int, str(i))))
    
    if i + digits == num:
        min_num = min(min_num, i)
        
print(min_num if min_num != num else 0)