import sys
from collections import deque

data = list(map(str, sys.stdin.read().splitlines()))
vertexs = int(data[0])
edges = int(data[1])
graph = [[] for _ in range(vertexs)]
visited = [False] * vertexs

for n in range(2, len(data)):
    a, b = map(int, data[n].split())
    graph[a-1].append(b-1)
    graph[b-1].append(a-1)
    
def bfs(n):
    cnt = 0
    visited[n] = True
    q = deque([n])
    
    while q:
        cur_v = q.popleft()
        
        for v in graph[cur_v]:
            if not visited[v]:
                cnt += 1
                visited[v] = True
                q.append(v) 

    return cnt

print(bfs(0))