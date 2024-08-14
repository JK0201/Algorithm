import sys
from collections import deque
n, m = map(int, sys.stdin.readline().split())
target = list(map(int, sys.stdin.readline().split()))

q = deque(i for i in range(1, n+1))

cnt = 0
for t in target:
    if q.index(t) <= len(q) - q.index(t):
        while True:
            num = q.popleft()
            if num != t:
                cnt += 1
                q.append(num)
                
            else:
                break
            
    elif q.index(t) > len(q) - q.index(t):
        while True:
            num = q.pop()
            if num != t:
                cnt += 1
                q.appendleft(num)
                
            else:
                cnt += 1
                break
        
print(cnt)