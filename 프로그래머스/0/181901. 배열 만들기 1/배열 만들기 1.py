def solution(n, k):
    answer = []
    
    for n in range(1, n + 1):
        if n % k == 0:
            answer.append(n)
    
    return answer