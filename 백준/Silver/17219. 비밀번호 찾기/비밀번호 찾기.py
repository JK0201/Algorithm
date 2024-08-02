import sys
n, m = map(int, sys.stdin.readline().split())

data = {}

for _ in range(n):
    site, pwd = map(str, sys.stdin.readline().split())
    data[site] = pwd
    
for _ in range(m):
    site = sys.stdin.readline().strip()
    if site in data:
        print(data[site])