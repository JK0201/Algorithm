while True:
    num = input()
    if num == '0':
        break
    
    reversed_num = num[::-1]
    if num == reversed_num:
        print('yes')
    
    else:
        print('no')