import sys

n, m = map(int, input().split())
a, b = [], []

for i in range(n):
    li = list(map(int, sys.stdin.readline().split()))
    a.append(li)
    
for i in range(n):
    li = list(map(int, sys.stdin.readline().split()))
    b.append(li)
    
for i in range(n):
    for j in range(m):
        print(a[i][j] + b[i][j], end=' ')
    print()