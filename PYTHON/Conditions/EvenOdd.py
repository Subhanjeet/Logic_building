num = int(input("Enter a number:"))
if(num %2 == 0):
    print(f"{num} is an even number")
elif(num %2 != 0):
    print(f"{num} is odd number")
else: 
    print("Invalid input. Please enter a valid number")