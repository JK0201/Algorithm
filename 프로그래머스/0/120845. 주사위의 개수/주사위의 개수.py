def solution(box, n):
    w, l, h = box[0] // n, box[1] // n, box[2] // n
    return w * l * h