import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
target = list(map(int, sys.stdin.readline().split()))

q = deque(i for i in range(1, n+1))

cnt = 0
for t in target:
    idx = q.index(t)
    
    if idx < len(q) - idx:
       cnt += idx
       q.rotate(-idx)

    else:
        cnt += len(q) - idx
        q.rotate(len(q) - idx)
        
    q.popleft()
    
print(cnt)