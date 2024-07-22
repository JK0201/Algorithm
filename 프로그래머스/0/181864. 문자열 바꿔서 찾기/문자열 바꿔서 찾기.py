def solution(myString, pat):
    answer = 0
    str = ""
    
    for s in myString:
        if s == "A":
            str += "B"
            
        else:
            str += "A"
    
    if pat in str:
        return 1
    
    return answer