def solution(n):
    answer = []

    
    for i in range(n):
        case = []
        for j in range(n):
            if i == j:
                case.append(1)
            else:
                case.append(0)
        answer.append(case)
    return answer