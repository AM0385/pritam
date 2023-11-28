
// Program to implement IPC using Thread by Shared Memory Concept
//server's Side

#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

#define SHMSZ 27

void* start() {
    char c;
    int shmid;
    key_t key;
    char* shm;
    char* s;

    key = ftok("shmemory", 66);
    shmid = shmget(key, SHMSZ, 0666 | IPC_CREAT);
    shm = (char*)shmat(shmid, (void*)0, 0);
    s = shm;
    for(c = 'a'; c <= 'z'; c++) {
        *s++ = c;
    }
    *s = '\0';
    printf("Added to the memory\n");
    while(*shm != '*') {
        sleep(1);
    }
    exit(0);
}

int main() {
    pthread_t serv;
    pthread_create(&serv, 0 , start, NULL);
    pthread_join(serv, NULL);
}
