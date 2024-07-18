def solution(citations):
    i = 0
    citations.sort(reverse=True)
    
    while i < len(citations) and citations[i] >= i + 1:
        i += 1
    
    return i