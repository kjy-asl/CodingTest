def solution(n):
    binary=[]
    num=n
    while(num!=0):
        binary.append(num%2)
        num=num//2
    origin = binary.count(1)

    while(1):
        n+=1
        num=n
        binary=[]
        while(num!=0):
            binary.append(num%2)
            num=num//2
        comp = binary.count(1)
        if origin==comp:
            return n