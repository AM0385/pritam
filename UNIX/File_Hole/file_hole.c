
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

char buff1[] = "abcdefghi\n";
char buff2[] = "ABCDEFGHI\n";

int main() {
	int fd = creat("file1.hole", O_WRONLY);
	int currpos = write(fd, buff1, 10);
	//creating hole
	while((lseek(fd, 50, SEEK_CUR)) < 1000) {
		write(fd, buff2, 10);
	}
	close(fd);
	exit(0);
	return 0;
}
