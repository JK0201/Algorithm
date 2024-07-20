def solution(picture, k):
    answer = []
    
    for pic in picture:
        resize = ''
        for p in pic:
            resize += p * k
        
        for i in range(k):
            answer.append(resize)
            
    return answer