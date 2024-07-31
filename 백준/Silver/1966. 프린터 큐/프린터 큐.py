import sys
from collections import deque
case = int(sys.stdin.readline())

for _ in range(case):
    q = deque()
    n, m = list(map(int, sys.stdin.readline().split()))
    doc = list(map(int, sys.stdin.readline().split()))
    for i, d in enumerate(doc):
        q.append((d, i))
    
    cnt = 0
    while q:
        priority = max(q)[0]
        d = q.popleft()
        
        if d[0] != priority:
            q.append(d)
            
        else:
            cnt += 1
            if d[1] == m:
                break
        
    print(cnt)