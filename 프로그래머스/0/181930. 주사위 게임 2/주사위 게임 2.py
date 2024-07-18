def solution(a, b, c):
    answer = 1
    count = 1
    dict = {}
    
    for i in [a, b, c]:
        if i in dict:
            count += 1
        dict[i] = True
    
    for n in range(1, count + 1):
        answer *= (a**n + b**n + c**n)
            
    return answer