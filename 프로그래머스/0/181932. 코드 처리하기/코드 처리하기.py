def solution(code):
    answer = ''
    mode = False
    i = 0
    
    while i < len(code):
        if code[i] == "1":
            mode = not mode
            
        else :
            if not mode and i % 2 == 0:
                answer += code[i]
                
            elif mode and i % 2 != 0:
                answer += code[i]
        i += 1
    
    if not answer:
        return "EMPTY"
    
    return answer