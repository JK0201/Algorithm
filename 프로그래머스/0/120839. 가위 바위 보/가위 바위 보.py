def solution(rsp):
    answer = ''
    dict = {'2':'0', '0':'5', '5':'2'}
    
    for i in rsp:
        if i in dict:
            answer += dict[i]
            
    return answer