def solution(rank, attendance):
    answer = 0
    std = []
    
    for i in range(len(attendance)):
        if attendance[i]:
            std.append([rank[i], i])
            
    std.sort()
    answer = 10000 * std[0][1] + 100 * std[1][1] + std[2][1]
    
    return answer