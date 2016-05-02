from struct import *
ofile=open('sz002456.day','rb')
buf=ofile.read()
ofile.close()

ifile=open('sz002456.txt','w')
num=len(buf)
no=num/32
b=0 
e=32
line=''

for i in range(int(no)):
    a=unpack('IIIIIfII',buf[b:e])
    line=str(a[0])+' '+str(a[1]/100.0)+' '+str(a[2]/100.0)+' '+str(a[3]/100.0)+' '+str(a[4]/100.0)+' '+str(a[5]/10.0)+' '+str(a[6])+' '+str(a[7])+' '+'\n'
    print(line)
    ifile.write(line)
    b=b+32
    e=e+32

ifile.close()

