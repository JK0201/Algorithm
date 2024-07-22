def solution(s):
    answer = ''
    neg = 1
    for i in s:
        if i == '-':
            neg = -1
        else:
            answer += i
        
    return int(answer) * neg