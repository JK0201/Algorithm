def solution(my_string):
    answer = []
    
    str = my_string.strip()
    str = str.split(" ")
    
    for s in str:
        if s != "":
            answer.append(s)

    return answer