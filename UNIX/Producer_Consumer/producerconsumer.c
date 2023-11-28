
// Program to implement Producer-Consumer problem using multi-threading

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdbool.h>
#include <sys/types.h>
#include <pthread.h>

#define SIZE 10
int BUFFER[SIZE];
int COUNTER = 0;

void *producerThread() {
	int in = 0;
	int item;
	while(true) {
		while(COUNTER == SIZE);
		printf("Enter the item to insert: ");
		scanf("%d", &item);
		BUFFER[in] = item;
		in = (in + 1) % SIZE;
		COUNTER = COUNTER + 1;
		printf("Produced: %d", item);
		sleep(2);
	}
}

void *consumerThread() {
	int out = 0;
	int item = 0;
	while(true) {
		while(COUNTER == 0);
		item = BUFFER[out];
		out = (out + 1) % SIZE;
		COUNTER = COUNTER - 1;
		printf("\tConsumed: %d", item);
		printf("\n");
	}
}

int main() {
	pthread_t producer, consumer;
	pthread_create(&producer, NULL, producerThread, NULL);
	pthread_create(&consumer, NULL, consumerThread, NULL);
	pthread_join(producer, NULL);
	pthread_join(consumer, NULL);

	return 0;
}
