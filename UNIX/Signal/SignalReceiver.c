
#include <stdio.h>
#include <unistd.h>
#include <signal.h>
#include <stdlib.h>

static void myHandler(int sigNo) {
    printf("Signaled with signal number: %d\n", sigNo);
    exit(0);
}

int main() {
    void (*pfRet)(int);
    pfRet = signal(SIGINT, myHandler);
    pfRet = signal(SIGABRT, myHandler);
    pfRet = signal(SIGFPE, myHandler);

    printf("Entering into infinite loop...\n");
    while(1) {
    }

    return 0;
}
