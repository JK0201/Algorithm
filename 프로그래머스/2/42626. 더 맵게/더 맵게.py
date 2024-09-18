import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    cnt = 0
    
    while scoville[0] < K:
        if len(scoville) <= 1:
            return -1
        
        s1 = heapq.heappop(scoville)
        s2 = heapq.heappop(scoville)
        
        new_scoville = s1 + (s2 * 2)
        heapq.heappush(scoville, new_scoville)
        cnt += 1
        
    return cnt