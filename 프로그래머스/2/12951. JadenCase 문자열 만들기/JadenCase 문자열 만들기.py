def solution(s):
    answer = ''
    str_list = s.split(' ')
    
    for i, word in enumerate(str_list):
        for j in range(len(word)):
            if j == 0:
                answer += word[j].upper()
            
            else:
                answer += word[j].lower()
        
        if i < len(str_list) - 1:       
            answer += ' '
        
    return answer