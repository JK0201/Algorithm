import sys
from collections import deque
data = list(map(str, sys.stdin.read().splitlines()))
row, col = list(map(int, data[0].split()))

grid = []
for i in range(1, row + 1):
    r = []
    for num in data[i]:
        r.append(int(num))
    grid.append(r)

visited = [[False] * col for _ in range(row)]
directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def bfs(r, c):
    visited[r][c] = True
    q = deque()
    q.append((r, c, 1))

    while q:
        cur_r, cur_c, dist = q.popleft()
        
        if cur_r == row - 1 and cur_c == col - 1:
            print(dist)
            break

        for dr, dc in directions:
            next_r = dr + cur_r
            next_c = dc + cur_c

            if 0 <= next_r < row and 0 <= next_c < col:
                if grid[next_r][next_c] == 1 and not visited[next_r][next_c]:
                    visited[next_r][next_c] = True
                    q.append((next_r, next_c, dist + 1))

bfs(0, 0)