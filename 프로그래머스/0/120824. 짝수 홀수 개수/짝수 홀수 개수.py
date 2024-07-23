def solution(num_list):
    odd = even = 0
    
    for n in num_list:
        if n % 2 == 0:
            even += 1
            
        else:
            odd += 1
    return [even, odd]