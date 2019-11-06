#sender site-------------------------------------

sdata = raw_input("\nEnter Data: ")

c = sdata.count("1")
sdata = sdata + str(c%2)

print("\nParity Bit Appended: "+sdata)

#recieving site------------------------------------

rdata = raw_input("\nEnter "+str(len(sdata)-1)+" Bits: ")
rdata = rdata + str(c%2)

c = rdata.count("1")

if(c%2 == 0):
	print("\nNo Error Found, code recieved correctly!\n")
else:
	print("\nError Found, code recieved incorrectly!\n")