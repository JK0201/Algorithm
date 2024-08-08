def solution(n, computers):
    number_of_networks = 0
    visited = [False] * n
    
    def dfs(cur_i):
        visited[cur_i] = True
        network = computers[cur_i]
        
        for i in range(len(network)):
            if network[i] == 1 and not visited[i]:
                dfs(i)
    
    for i in range(n):
        if not visited[i]:
            dfs(i)
            number_of_networks += 1
            
    return number_of_networks