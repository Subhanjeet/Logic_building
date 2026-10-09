import random

num =(int(input("Enter a number between 1 and 100: ")))

guess = random.randint(1,100)

count = 0

while guess != num:
    count += 1
    if guess < num:
        print(f"{guess} is too low. Try again.")
    else:
        print(f"{guess} is too high. Try again.")
    guess = random.randint(1,100)

print(f"Congratulations! {guess} is the correct number.")
print(f"It took you {count} guesses.")