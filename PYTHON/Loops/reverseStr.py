# reverse a string without using built-in functions

name = input("Enter Your Name: ")
reverse = ""
for i in range(len(name)-1,-1,-1):
    reverse = reverse + name[i]
print(f"The reverse of {name} is: {reverse}")