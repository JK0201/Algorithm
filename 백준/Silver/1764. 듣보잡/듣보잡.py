import sys
n, m = sys.stdin.readline().split()
p = {}

for _ in range(int(n)):
    name = sys.stdin.readline().strip()
    p[name] = 1
 
for _ in range(int(m)):
    name = sys.stdin.readline().strip()
    if name not in p:
        p[name] = 1
        
    else:
        p[name] += 1

res = []
cnt = 0
for key, val in p.items():
    if val > 1:
        cnt += 1
        res.append(key)
        
print(cnt)
res.sort()
for r in res:
    print(r)