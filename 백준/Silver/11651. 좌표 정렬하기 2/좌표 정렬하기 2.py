import sys
n = int(sys.stdin.readline().strip())
coord = []

for _ in range(n):
    x, y = list(map(int, sys.stdin.readline().split()))
    coord.append((x, y))
    
coord.sort(key = lambda x: (x[1], x[0]))

for c in coord:
    x, y = c
    print(x, y)