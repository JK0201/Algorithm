from collections import deque

n = int(input())
q = deque(i for i in range(1, n+1))

i = 0
while len(q) != 1:
    if i % 2 == 0:
        q.popleft()
        
    else:
        num = q.popleft()
        q.append(num)
        
    i += 1
    
print(q[0])