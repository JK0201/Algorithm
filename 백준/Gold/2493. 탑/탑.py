import sys
n = int(sys.stdin.readline().strip())
towers = list(map(int, sys.stdin.readline().split()))
tower = []
res = [0] * n

for i in range(n-1, -1, -1):
    while tower and tower[-1][0] < towers[i]:
        idx = tower.pop()[1]
        res[idx] = i + 1
    tower.append((towers[i], i))

for r in res:
    print(r, end=' ')