#!/bin/bash

runtrace() {
	x11trace -s -n -D :9 -d :1
}

trace2() {
	"$@" > x11trace.1.log
	"$@" > x11trace.2.log
}

loop() {
	while :; do 
		trace2
		echo "repeat ?"
		read
	done
}

traceloop() {
	loop trace2
}

vncserv() {
	Xvnc -SecurityTypes NONE :1
}

vncclient() {
	vncviewer :5901
}

"$@"
