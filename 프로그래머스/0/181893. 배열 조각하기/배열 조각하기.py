def solution(arr, query):
    for i, query in enumerate(query):
        if i % 2 == 0:
            arr = arr[:query+1]
        else:
            arr = arr[query:]
    return arr