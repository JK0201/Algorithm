def solution(num_list):
    r1 = 0
    r2 = 0
    
    for n in num_list:
        if r1 == 0:
            r1 += n
            
        else:
            r1 *= n
        r2 += n
    r2 = r2 ** 2
    
    if r1 < r2 :
        return 1
    else:
        return 0