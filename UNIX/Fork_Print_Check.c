#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

int global = 100;

int main() {

    int status = 0;
    int local = 10;
    pid_t pid;
    pid = fork();
    if(pid < 0) {
        printf("\nFork Failed!");
        exit(0);
    }
    else if(pid == 0) {
        local++;
        global++;
    }
    else if(pid > 0) {
        sleep(2);
    }
    printf("\nGlobal: %d\t Local: %d", global, local);

    return 0;
}