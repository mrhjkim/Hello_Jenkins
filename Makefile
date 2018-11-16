
default: cppcheck.xml hello_exec
.PHONY: default clean

cppcheck.xml: hello.cpp
	cppcheck --xml --xml-version=2 --enable=all --inconclusive --language=c++ *.cpp >$@

hello_exec: hello.cpp
	g++ hello.cpp -o hello_exec
