def solution(a, b):
    answer = 0
    a = str(a)
    b = str(b)
    
    if int(a + b) > int(b + a):
        answer = a + b
    
    elif int(a + b) < int(b + a):
        answer = b + a
        
    elif int(a + b) == int(b + a):
        answer = a + b
    
    return int(answer)