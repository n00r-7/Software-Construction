

# -*- coding: utf-8 -*-
import MySQLdb 

db = MySQLdb.connect('localhost' , 'root' , '', 'res_reser')
cur = db.cursor()
cur.execute("INSERT INTO l_details(user_name,pass) Values('nn','ab1')")
cur.execute("INSERT INTO l_details(user_name,pass) Values('mb','mb1')")
cur.execute("INSERT INTO l_details(user_name,pass) Values('kj','kj1')")
db.commit
#cur.execute("Select *from l_details")
#data=cur.fetchall()
#print(data)

username = str(raw_input("Ener Username"))
password = str(raw_input('Enter password '))

cur.execute("SELECT pass FROM l_details WHERE user_name='"+username+"'")
result = cur.fetchone()
print(result)
if result!=None and result == password:
        print("PROCEED")
else:
        print("GO AWAY")


tablesavailable = 16
extralarge = 1
e = int(extralarge)
largetable = 3
lt = int(largetable)
mediumtable = 8 
mt = int(mediumtable)
smalltable=4
st = int(smalltable)
reserved = {'One Extra Large Table from' : 0 , 'One Large Table from': 0, 'One Medium Table': 0, 'One Small Table': 0}
customer = str(raw_input('Enter your name'))
cur.execute("INSERT INTO res_details(Name) Values('"+customer+"')")
db.commit
cur.execute("Select *from res_details")
data=cur.fetchall()
print(data)
time = raw_input('Enter the time of reservation')
cur.execute("INSERT INTO res_details(Start_t) Values('"+time+"')")
db.commit
etime = int(time[0:2]) + 1
if etime > 22:
	print("WE ARE CLOSED")
else:
	npeople =raw_input('Enter the number of people')
	nn =int(npeople)
   cur.execute("INSERT INTO res_details(n_people) Values('"+nn+"')")
   db.commit
	occupiedtime= (time,etime)
	if nn <13 and nn > 6 and e!=0:
		end = raw_input('Enter your end time ')
		e = int(end)
		if e > 22:
			print("You cant stay beyond restaurants closing time")
			tablesavailable = tablesavailable + 1
		else:	
			timereserved = (time,e)
            cur.execute("INSERT INTO res_details(table_type) Values('large')")
            db.commit
			reserved['One Extra Large Table from'] = timereserved
			e = e-1
			print("reserved['One Extra Large Table from']" , reserved['One Extra Large Table from'])	
	elif nn <7 and nn >4 and lt!=0:
		reserved['One Large Table from'] = occupiedtime	
		print("reserved['One Large Table from']" , reserved['One Large Table from'])
		lt = lt-1		
		print(lt)
	elif nn <5 and nn >2 and mt!=0:
		reserved['One Medium Table'] = occupiedtime	
		print("reserved['One Medium Table']" , reserved['One Medium Table'])	
		mt = mt-1
		print(mt)
	elif nn < 3 and st!=0:
		reserved['One Small Table'] = occupiedtime
		print("reserved['One Small Table']" , reserved['One Small Table'])
		st = st-1
		print(st)

	tablesavailable = tablesavailable-1
	print("Table Avalable: ", tablesavailable)
    cur.execute("Select *from res_details")
    data=cur.fetchall()
    print(data)




