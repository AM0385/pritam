
// Program to implement Exec() System Call

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {


    pid_t pid;
    pid = fork();
    
    if(pid < 0) {
        printf("\nFork Failed!");
        exit(0);
    }
    else if(pid > 0) {
        printf("\nParent Process (PID: %d)", getpid());
        wait(NULL);
    }
    else if(pid == 0) {
        const char *programPath = "/home/sheepy/Documents/Unix_Linux_Internal/Exec Files/test1"; 
        execl(programPath, programPath, "test1", NULL);
        exit(0);
    }

    return 0;
}
