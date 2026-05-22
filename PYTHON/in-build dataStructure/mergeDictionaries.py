dic1 = {1:100, 2:200, 3:300, 4:400, 5:500}
dic2 = {5:500, 6:600, 7:700, 8:800, 9:900}

for i in dic2:
    if i in dic1.keys():
        dic1[i] += dic2[i]
    else:
        dic1[i] = dic2[i]
print(dic1)