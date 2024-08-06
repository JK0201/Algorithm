from collections import deque

def solution(maps):
    if maps[0][0] == 0 or maps[-1][-1] == 0:
        return -1
    
    shortest_dist = -1
    row, col = len(maps), len(maps[0])
    visited = [[False] * col for _ in range(row)]
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    
    q = deque()
    q.append((0, 0, 1))
    visited[0][0] = True
    
    while q:
        cur_r, cur_c, cur_dist = q.popleft()
        
        if cur_r == row - 1 and cur_c == col - 1:
            shortest_dist = cur_dist
            break
            
        for dr, dc in directions:
            next_r = cur_r + dr
            next_c = cur_c + dc
            
            if 0 <= next_r < row and 0 <= next_c < col:
                if maps[next_r][next_c] == 1 and not visited[next_r][next_c]:
                    visited[next_r][next_c] = True
                    q.append((next_r, next_c, cur_dist + 1))
                    
    return shortest_dist