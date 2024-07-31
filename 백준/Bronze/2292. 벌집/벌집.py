n = int(input())

row = 1
cnt = 1

while n > row:
    row += 6 * cnt
    cnt += 1
    
print(cnt)