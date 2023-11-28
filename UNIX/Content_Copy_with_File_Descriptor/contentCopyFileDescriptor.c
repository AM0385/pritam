
// Program to copy the contents of one file and paste to another file using file descriptor

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <stdbool.h>
#include <string.h>

int main() {

	int fd1, fd2;
	char buffer[255];
	int bufferSize = sizeof(buffer);
	int nBytesRead;
	int option;

	int stdin_fd = 0;
	int stdout_fd = 1;
	int read_fd1 = open("testFile1.txt", O_RDONLY);
	int write_fd1 = open("testFile1.txt", O_WRONLY);
	int read_fd2 = open("testFile2.txt", O_RDONLY);
	int write_fd2 = open("testFile2.txt", O_WRONLY);

	bool running = true;
	while(running) {
		memset(buffer, '\0', bufferSize);
		printf("\n");
		printf("\n===================================");
		printf("\n1. Read File 1");
		printf("\n2. Write File 1");
		printf("\n3. Read File 2");
		printf("\n4. Write File 2");
		printf("\n5. Copy from File 1 to File 2");
		printf("\n6. Copy from File 2 to File 1");
		printf("\n7. Clear Screen");
		printf("\n0. Exit");
		printf("\n===================================");
		printf("\nChoose any one option: ");

		scanf("%d", &option);

		switch(option) {
			case 0:
				running = false;
				break;

			case 1:
				while((nBytesRead = read(read_fd1, buffer, bufferSize)) > 0) {
					printf("\n");
					write(stdout_fd, buffer, nBytesRead);
					printf("\n");
				}
				break;

			case 2:
				nBytesRead = read(stdin_fd, buffer, bufferSize);
				write(write_fd1, buffer, nBytesRead);
				break;

			case 7:
				system("clear");
				break;
				
			default:
				printf("\nPlease enter a valid option!");
				break;
		}
	}

	return 0;
}
