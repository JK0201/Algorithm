def solution(participant, completion):
    p_dict = {}
    
    for p in participant:
        if p not in p_dict:
            p_dict[p] = 1
            
        else:
            p_dict[p] += 1
            
    for c in completion:
        if c in p_dict:
            p_dict[c] -= 1
    
    for k, v in p_dict.items():
        if v == 1:
            return k