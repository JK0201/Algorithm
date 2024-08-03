def solution(s):
    stack = []

    for word in s:
        if not stack or stack[-1] != word:
            stack.append(word)
            
        else:
            while stack and stack[-1] == word:
                stack.pop()
                
    return 1 if not stack else 0