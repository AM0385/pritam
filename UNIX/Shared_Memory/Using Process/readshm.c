
// Program to implement IPC using Shared Memory Concept
//Reader's Side

#include <stdio.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <unistd.h>

int main() {
	key_t key = ftok("shmemory", 60);
	int shmid = shmget(key, sizeof(int), 0);
	int* result = (int*)shmat(shmid, (void*)0, 0);
	printf("\nData is collected from the shared memeory\n");
	printf("\nResult is: %d\n", *result);
	shmdt(result);
	shmctl(shmid, IPC_RMID, NULL);

	return 0;
}
