#iterative method
print("Iterative:")
p= [[1,2,3],[8,7,5]]
d= [[5,5,5,6],[3,7,7,8],[6,6,4,1]]
def imethod(p,d):
    answer = [[0,0,0,0],[0,0,0,0]]
    for i in range(len(p)):
        for j in range(len(d[i])):
            for x in range(len(p)):
                answer[i][j] += p[i][x] * d[x][j] #matrix multiplication
    return answer
print(imethod(p,d)) #printing the resultant matrix

#stressen's method

def result(y,x):
        resultt = [[0 for row in range(y)] for col in range(x)]
        return resultt

def split(resultt): #splitting into quarters
    x = resultt
    y = resultt
    z = resultt
    w = resultt

    while(len(x)>len(resultt)/2):
        x=x[:int(len(x)/2)]
        y=y[:int(len(y)/2)]
        z=z[int(len(z)/2):]
        w=w[int(len(d)/2):]
    while(len(x[0])>len(resultt[0])/2):
            for o in range(int(len(x[0])/2)):
                x[o] =x[o][:int(len(x[o])/2)]
                y[o] =y[o][int(len(y[o])/2):] 
                z[o] =z[o][:int(len(z[o])/2)]
                w[o] =w[o][int(len(w[o])/2):]
    return x,y,z,w

def adding(f,s): #adding the two matrices
    empty = []
    for i in range(len(f)):
        empty1 = []
        for k in range(len(f[0])):
            empty1.append(f[i][k] + s[i][k])
        empty.append(empty1)
    return empty

def subtracting(f,s): #substracting the two matrices
    empty = []
    for i in range(len(f)):
        empty1 = []
        for k in range(len(f[0])):
            empty1.append(f[i][k] - s[i][k])
        empty.append(empty1)
    return empty

def strassens(f,s,b): #applying the algorithm
    #base case for recursion
    if b ==1:
        y = [[0]]
        y[0][0] = f[0][0]*s[0][0]
        return y
    else:
        f11,f12,f21,f22 = split(f)
        s11,s12,s21,s22 = split(s)
    #calculating p1-p7
        p1 = strassens(adding(f11,f22), adding(s11,s22), b/2)
        p2 = strassens(adding(f21,f22),s11, b/2)
        p3 = strassens(f11, subtracting(s12,s22), b/2)
        p4 = strassens(f22, subtracting(s21,s11), b/2)
        p5 = strassens(adding(f11,f12), s22, b/2)
        p6 = strassens(subtracting(f21,f11), adding(s11,s12), b/2)
        p7 = strassens(subtracting(f12,f22), adding(s21,s22), b/2)
    #calculating the resultant matrices
        c11 = adding(subtracting(adding(p1, p4), p5), p7)
        c12 = adding(p3, p5)
        c21 = adding(p2, p4)
        c22 = adding(subtracting(adding(p1, p3), p2), p6)
    #the formulas used for the p's and c's calculation are mentioned in the document

        answer = result(len(c11)*2,len(c11)*2)

        for i in range(len(c11)):
            for j in range(len(c11)):
                answer[i][j]                   = c11[i][j]
                answer[i][j+len(c11)]          = c12[i][j]
                answer[i+len(c11)][j]          = c21[i][j]
                answer[i+len(c11)][j+len(c11)] = c22[i][j]

        return answer

f = [[4,3],[2,5]]
s = [[10,5],[2,5]]
print("Strassens:")
print(strassens(f,s,2))
