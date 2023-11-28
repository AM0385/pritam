
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>

int main(int argc, char *argv[]) {
	struct stat buf;
	for(int x = 0; x < argc; x++) {
		printf("%s", argv[x]);
		lstat(argv[x], &buf);
	}
	if(S_ISREG(buf.st_mode)) {
		printf("\nFile is regular");
	}
	if(S_ISDIR(buf.st_mode)) {
		printf("\nFile is a Directory");
	}

	return 0;
}
