CFLAGS=-g -std=c99 -O3 -march=native -Werror -Wall

main : prog.o Makefile
	gcc $(CFLAGS) -o OpenScreen prog.o

%.o : %.c Makefile
	gcc $(CFLAGS) -MD -c $*.c

test : Makefile OpenScreen
	OpenScreen

clean :
	rm -f *.d
	rm -f *.o
	rm -f OpenScreen

-include *.d
