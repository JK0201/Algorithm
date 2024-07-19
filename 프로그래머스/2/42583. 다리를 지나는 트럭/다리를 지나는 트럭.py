from collections import deque

def solution(bridge_length, weight, truck_weights):
    bridge = deque()
    truck = deque(truck_weights)
    weight_list = deque()
    time = 0
    passed = 0
    cur_weight = 0
    
    while passed < len(truck_weights):
        if bridge and time - bridge[0] == bridge_length:
            cur_weight -= weight_list.popleft()
            bridge.popleft()
            passed += 1
        
        if truck and len(bridge) < bridge_length and cur_weight + truck[0] <= weight:
            cur_weight += truck[0]
            bridge.append(time)
            weight_list.append(truck.popleft()) 
            
        time += 1
        
    return time