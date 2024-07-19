def solution(participant, completion):
    answer = ''
    dict = {}
    
    for p in participant:
        if p in dict:
            dict[p] += 1
        else:
            dict[p] = 1
    
    for c in completion:
        if c in dict:
            dict[c] -= 1
            
    for name, num in dict.items():
        if num == 1 :
            answer = name
    
    return answer