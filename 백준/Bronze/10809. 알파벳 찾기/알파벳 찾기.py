s = input()

alpha = {chr(a): -1 for a in range(ord('a'), ord('z')+1)}

for i in range(len(s)):
    if s[i] in alpha and alpha[s[i]] == -1:
        alpha[s[i]] = i
        
for i in alpha.values():
    print(i, end=' ')
