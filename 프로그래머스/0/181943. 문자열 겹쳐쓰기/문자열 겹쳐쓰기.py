def solution(my_string, overwrite_string, s):
    answer = ''
    
    for l in range(len(my_string)):
        if l >= s and l-s < len(overwrite_string):
            answer += overwrite_string[l-s]
        else:
            answer += my_string[l]
        
    return answer