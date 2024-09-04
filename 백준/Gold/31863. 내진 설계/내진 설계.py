import sys
from collections import deque

data = sys.stdin.read().splitlines()
row ,col = list(map(int, data[0].split()))
grid = [[data[r][c] for c in range(0, col)]  for r in range(1, row+1)]
destroyedBuilding = [[False for _ in range(col)] for _ in range(row)];
visited = [[False for _ in range(col)] for _ in range(row)]
numberOfBuilding = 0
destroyed = 0

def bfs(r, c):
    global destroyed    
    visited[r][c] == True
    q = deque([(r, c, True)])
    
    while q:
        cur_r, cur_c, main = q.popleft()
        
        if main:
            directions = [(-1, 0), (1, 0), (0, -1), (0, 1), (-2, 0), (2, 0), (0, -2), (0, 2)]
        
        else:
            directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
            
        for dr, dc in directions:
            next_r = dr + cur_r
            next_c = dc + cur_c
            
            if 0 <= next_r < row and 0 <= next_c < col:
                
                if abs(dr) == 2 or abs(dc) == 2:
                    mid_r = cur_r + dr//2
                    mid_c = cur_c + dc//2
                    
                    if grid[mid_r][mid_c] == '|':
                        continue
                
                if grid[next_r][next_c] == '*' and not visited[next_r][next_c]:
                    destroyed += 1
                    visited[next_r][next_c] = True
                    destroyedBuilding[next_r][next_c] = True
                    q.append((next_r, next_c, False))
                
                elif grid[next_r][next_c] == '#':
                    if not visited[next_r][next_c]:
                        visited[next_r][next_c] = True
                        
                    elif visited[next_r][next_c] and not destroyedBuilding[next_r][next_c]:
                        destroyed += 1
                        destroyedBuilding[next_r][next_c] = True
                        q.append((next_r, next_c, False))

for r in range(row):
    for c in range(col): 
        if grid[r][c] == '*' or grid[r][c] == '#':
            numberOfBuilding += 1
            
        elif grid[r][c] == '@':
            bfs(r, c)
            
print(destroyed, numberOfBuilding - destroyed)