import sys

data = list(map(str, sys.stdin.read().splitlines()))
vertexs = int(data[0])
edges = int(data[1])
graph = [[] for _ in range(vertexs)]
visited = [False] * vertexs
cnt = 0

for n in range(2, len(data)):
    a, b = map(int, data[n].split())
    graph[a-1].append(b-1)
    graph[b-1].append(a-1)
    
def dfs(cur_v):
    global cnt
    visited[cur_v] = True
        
    for v in graph[cur_v]:
        if not visited[v]:
            cnt += 1
            dfs(v)

dfs(0)
print(cnt)