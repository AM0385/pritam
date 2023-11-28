
// Program to take input using stdin(fd: 0) and output using stdout(fd: 1)

#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>

int main() {

	int stdin_fd = 0;
	int stdout_fd = 1;
	char buffer[255];
	int nbytes = 255;
	int n;

	do {
		printf("\nInput (using file descriptor: 0): \n");
		n = read(stdin_fd, buffer, nbytes);
		printf("\nOutput (using file descriptor: 1): \n");
		write(stdout_fd, buffer, n);
	}
	while(n > 0);

	return 0;
}
