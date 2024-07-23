def solution(s):
    answer = ''
    str = ''
    dict = {
        'zero' : '0',
        'one' : '1',
        'two' : '2',
        'three' : '3',
        'four' : '4',
        'five' : '5',
        'six' : '6',
        'seven' : '7',
        'eight' : '8',
        'nine' : '9'
    }
    
    for i in s:
        str += i
        if str in dict.values():
            answer += i
            str = ''
            
        elif str in dict:
            answer += dict[str]
            str = '' 
        
    return int(answer)