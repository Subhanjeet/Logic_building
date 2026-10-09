# print positive and negative numbers using list

numbers = [1, -1, 2, -2, 3, -3]
print("Positive numbers:")
for i in numbers:
    if i>=0:
        print(i)
print("Negative numbers:")
for i in numbers:
    if i<0:
        print(i)