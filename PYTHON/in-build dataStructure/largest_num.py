# find the greatest number in a list and print it's index

number = [12,34,54,64,76,87]
largest = number[0]
index = 0

for i in range(len(number)):
    if number[i] > largest:
        largest = number[i]
        index = i

print(f"The greatest number is {largest} and its index is {index}")