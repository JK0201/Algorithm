def solution(n):
    init = bin(n)[2:].count('1')
    target = n + 1

    while True:
        if init == bin(target)[2:].count('1'):
            return target
        
        target += 1