
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>

int main(int argc, char* argv[]) {
    int pid = atoi(argv[1]);
    int sigNo = atoi(argv[2]);
    kill(pid, sigNo);

    return 0;
}
