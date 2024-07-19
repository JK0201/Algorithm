def solution(prices):
    answer = [i for i in range(len(prices) -1 , -1 , -1)]
    stack = []
    time = 0

    for cur_sec, price in enumerate(prices):
        while stack and price < stack[-1][1]:
            prev_sec = stack.pop()[0]
            answer[prev_sec] = cur_sec - prev_sec
        stack.append((cur_sec, price))
    
    return answer