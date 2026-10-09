# find the second largest number in a list

l = [12,34,54,64,76,87]

largest = l[0]
second_largest = l[0]
for i in l:
    if i > largest:
        second_largest = largest
        largest = i
    elif i > second_largest and i != largest:
        second_largest = i
        
print("second largest is ",second_largest)
    
    