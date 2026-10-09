# wap to create a mean of a list elements

numbers = [12,34,54,64,76,87]
total = 0
for i in numbers:
    total += i
mean = total / len(numbers)
print("Mean:", mean)