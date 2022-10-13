package com.company;

import java.util.Scanner;

public class Main {

    public static int first = 0;
    public static int last = 0;

    public static void main(String[] args) {
        int size = inputInt("Enter the max length of the Queue: ");
	    int queue[] = new int[size];
        menu(queue, size);
    }

    public static void enqueue(int queue[], int size){
        if (!isFull(queue,size)){
            queue[last % size] = inputInt("enter new item");
            last++;
        }
        else {
            System.out.println("overflow error");
        }
    }

    public static void dequeue(int queue[], int size){
        if (!isEmpty(queue,size)){
            System.out.println(queue[first % size]);
            queue[first % size] = -1;
            first++;
        }
        else {
            System.out.println("underflow error");
        }
    }

    public static int inputInt(String prompt){
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        int out = -1;
        while (!valid){
            try{
                System.out.println(prompt);
                out = input.nextInt();
                if (out > 0){
                    valid = true;
                }
            }
            catch (Exception e){
                System.out.println("Error "+e);
            }
        }
        return out;
    }

    public static boolean isFull(int queue[], int size){
        int count = 0;
        boolean out = false;
        for (int i = 0; i < size; i++){
            if (queue[i] > 0){
                count++;
            }
        }
        if (count == size){
            out = true;
        }
        return out;
    }

    public static boolean isEmpty(int queue[], int size){
        int count = 0;
        boolean out = false;
        for (int i = 0; i < size; i++){
            if (queue[i] > 0){
                count++;
            }
        }
        if (count == 0){
            out = true;
        }
        return out;
    }

    public static void menu(int queue[],int size){
        boolean end = false;
        while (!end){
            System.out.println("    --Menu--" +
                    "\n 1) enqueue" +
                    "\n 2) dequeue");
            int option = inputInt("Enter option number");
            if (option == 1){
                enqueue(queue,size);
            }
            else if (option == 2){
                dequeue(queue,size);
            }
            else{
                end = true;
            }
        }
    }
}