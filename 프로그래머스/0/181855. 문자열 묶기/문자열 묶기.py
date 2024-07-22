def solution(strArr):
    dict = {}
    
    for s in strArr:
        if len(s) not in dict:
            dict[len(s)] = 1
            
        else:
            dict[len(s)] += 1
    
    return max(dict.values())