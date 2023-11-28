
// Program to implement IPC using Shared Memory Concept
//Writer's Side

#include <stdio.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <unistd.h>

int main() {
	key_t key = ftok("shmemory", 60);
	int shmid = shmget(key, sizeof(int), 0666|IPC_CREAT);
	int* shared_mem = (int*)shmat(shmid, (void*)0, 0);
	int num1, num2;
	printf("\nEnter the first number: ");
	scanf("%d", &num1);
	printf("\nEnter the second number: ");
	scanf("%d", &num2);
	*shared_mem = num1 + num2;
	printf("\nSum of %d and %d is stored in the attached shared memory: ", num1, num2);
	shmdt(shared_mem);

	return 0;
}
