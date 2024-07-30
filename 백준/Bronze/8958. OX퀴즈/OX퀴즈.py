import sys
n = int(input())

for _ in range(n):
    total = 0
    score = 0
    quiz_result = str(sys.stdin.readline().split())
    for q in quiz_result:
        if q == 'O':
            score += 1
            total += score
            
        else:
            score = 0

    print(total)