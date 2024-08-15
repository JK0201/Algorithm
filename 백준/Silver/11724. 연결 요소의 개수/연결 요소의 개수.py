import sys
sys.setrecursionlimit(10**6)
n, m = map(int, sys.stdin.readline().split())
data = []
for _ in range(m):
    node, edge = map(int, sys.stdin.readline().split())
    data.append([node, edge])

cnt = 0
graph = [[] for _ in range(n)]
visited = [False] * n

for d in data:
    graph[d[0]-1].append(d[1]-1)
    graph[d[1]-1].append(d[0]-1)

def dfs(cur_v):
    visited[cur_v] = True

    for v in graph[cur_v]:
        if not visited[v]:
            dfs(v)

for i in range(len(graph)):
    if not visited[i]:
        dfs(i)
        cnt += 1

print(cnt)