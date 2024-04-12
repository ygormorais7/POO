def arithmetic_arranger(problems, show_answers=False):
    for string in problems:
        try:
            num1, num2 = string.split(' + ')
            num3 = int(num1) + int(num2)
            op = '+'
        except:
            num1, num2 = string.split(' - ')
            num3 = int(num1) - int(num2)
            op = '-'
        num3 = str(num3)
        
        espaco = 2 + max(len(num1),len(num2))
        barra = espaco*'-'
        
        num1 = " "*(espaco-len(num1)) + num1
        num2 = " "*(espaco-len(num2)) + num2
        num3 = " "*(espaco-len(num3)) + num3

        print(f'\n{num1}\n{op}{num2}\n{barra}\n{num3}')


        #print(num1,num2,num3,barra)
    return num1

'''print(f'\n{arithmetic_arranger(["32 + 698", "3801 - 2", "45 + 43", "123 + 49"])}')'''

arithmetic_arranger(["32 + 698", "3801 - 2", "45 + 43", "123 + 49"])