def solution(sides):
    sides.sort()
    a = sides.pop()
    
    if a < sum(sides):
        return 1
    return 2