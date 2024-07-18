def solution(my_string, is_suffix):
    str = my_string[-len(is_suffix):]
    
    if str != is_suffix:
        return 0
    
    return 1