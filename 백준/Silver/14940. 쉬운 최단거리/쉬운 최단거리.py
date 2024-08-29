import sys
from collections import deque
data = list(map(str, sys.stdin.read().splitlines()))
row, col = list(map(int, data[0].split()))

grid = []
for i in range(1, len(data)):
    r = list(map(int, data[i].split()))
    grid.append(r)

visited = [[-1] * col for _ in range(row)]
directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def bfs(r, c):
    visited[r][c] = 0

    q = deque()
    q.append((r, c, 0))

    while q:
        cur_r, cur_c, dist = q.popleft()

        for dr, dc in directions:
            next_r = dr + cur_r
            next_c = dc + cur_c

            if 0 <= next_r < row and 0 <= next_c < col:
                if grid[next_r][next_c] == 1 and visited[next_r][next_c] == -1:
                    visited[next_r][next_c] = dist + 1
                    q.append((next_r, next_c, dist + 1))   

for r in range(row):
    for c in range(col):
        if grid[r][c] == 2 and visited[r][c] == -1:
            bfs(r, c)

for r in range(row):
    for c in range(col):
        if grid[r][c] == 0:
            print(0, end=' ')
        else:
            print(visited[r][c], end=' ')
    print()