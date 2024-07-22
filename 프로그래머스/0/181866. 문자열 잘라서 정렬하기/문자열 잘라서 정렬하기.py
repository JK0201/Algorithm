def solution(myString):
    answer = []
    
    str = myString.split('x')
    
    str.sort()
    
    for s in str:
        if s != "":
            answer.append(s)
    
    return answer