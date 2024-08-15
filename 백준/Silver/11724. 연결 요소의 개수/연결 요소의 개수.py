from collections import deque

import sys
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

def bfs(v):
    visited[v] = True
    q = deque()
    q.append(v)

    while q:
        cur_v = q.popleft()
        for v in graph[cur_v]:
            if not visited[v]:
                visited[v] = True
                q.append(v)

for i in range(len(graph)):
    if not visited[i]:
        bfs(i)
        cnt += 1

print(cnt)