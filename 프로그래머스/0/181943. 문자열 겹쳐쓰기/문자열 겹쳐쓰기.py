def solution(my_string, overwrite_string, s):
    answer = ''
    str = [l for l in my_string]
    
    for idx, l in enumerate(overwrite_string):
        str[idx + s] = l
    
    for l in str:
        answer+= l
    
    return answer