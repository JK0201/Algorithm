def solution(age):
    answer = ''
    dict = {str(n):chr(s) for n, s in enumerate(range(ord('a'), ord('j')+1))}
    
    for a in str(age):
        answer += dict[a]

    return answer