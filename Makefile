
default: cppcheck.xml hello_exec
.PHONY: default clean

cppcheck.xml: hello.c
	cppcheck --xml --xml-version=2 --enable=all --inconclusive --language=c *.c 2>$@

hello_exec: hello.c
	gcc -Wall hello.c -o hello_exec
install:
	cp hello_exec ${UASYS_HOME}
