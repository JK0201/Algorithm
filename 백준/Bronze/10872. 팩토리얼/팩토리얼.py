num = int(input())
answer = 1

for i in range(num, 0, -1):
    answer *= i
    
print(answer)