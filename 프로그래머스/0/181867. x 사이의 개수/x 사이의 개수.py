def solution(myString):
    answer = []
    
    str = myString.split('x')
    
    for s in str:
        answer.append(len(s))
    
    return answer