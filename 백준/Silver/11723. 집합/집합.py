import sys
n = int(sys.stdin.readline())

def add(num):
    if num not in hash_table:
        hash_table.add(num)
        
def remove(num):
    if num in hash_table:
        hash_table.discard(num)
        
def check(num):
    if num in hash_table:
        print(1)
    
    else:
        print(0)

def toggle(num):
    if num in hash_table:
        hash_table.discard(num)
        
    else:
        hash_table.add(num)

def all():
    global hash_table
    hash_table = set(i for i in range(1, 21))

def empty():
    hash_table.clear()

hash_table = set()

for _ in range(n):
    operation = sys.stdin.readline().split()
    
    if len(operation) == 2:
        o, num = operation
        if o == 'add':
            add(int(num))
            
        elif o == 'remove':
            remove(int(num))
            
        elif o == 'check':
            check(int(num))
            
        elif o == 'toggle':
            toggle(int(num))
        
    else:
        o = operation[0]
        if o == 'all':
            all()
            
        elif o == 'empty':
            empty()