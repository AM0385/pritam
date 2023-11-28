
// Program to check print statement for fork system call

#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {

	int status = 0;
	pid_t pid;
	pid = fork();

	if(pid < 0) {
		printf("Fork Failed!");
		exit(0);
	}
	else if(pid > 0) {
		wait(&status);
		if(WIFEXITED(status)) {
			int code = WEXITSTATUS(status);
			printf("\nNormal Termination\n");
			printf("\nStatus Code: %d\n", code);
		}
		if(WIFSIGNALED(status)) {
			int code = WTERMSIG(status);
			printf("\nAbnormal Termination\n");
			printf("\nStatus Code: %d\n", code);
		}
	}
	else if(pid == 0) {
		abort();
		exit(0);
	}

	return 0;
}

