from collections import deque

def solution(n, computers):
    number_of_networks = 0
    visited = [False] * n
    
    def bfs(i):
        visited[i] = True
        q = deque()
        q.append(i)
        
        while q:
            cur_i = q.popleft()
            network = computers[cur_i]
            
            for i in range(len(network)):
                if network[i] == 1 and not visited[i]:
                    visited[i] = True
                    q.append(i)
    
    for i in range(n):
        if not visited[i]:
            bfs(i)
            number_of_networks += 1
            
    return number_of_networks