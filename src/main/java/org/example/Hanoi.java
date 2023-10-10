package org.example;

import java.util.Stack;

public class Hanoi {
    // Se declara un arreglo de stacks (Torres de Hanói)
    public static Stack<Integer>[] stacks = new Stack[3];

    public static void printAll() {
        for (Stack<Integer> stack: stacks) {
            System.out.println(stack);
        }
        System.out.println("-----------------------");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        // Se declaran las torres
        stacks[0] = new Stack<>();
        stacks[1] = new Stack<>();
        stacks[2] = new Stack<>();

        // Se le dan los valores a la pila inicial [1 - 7]
        stacks[0].push(1);
        stacks[0].push(2);
        stacks[0].push(3);
        stacks[0].push(4);
        stacks[0].push(5);
        stacks[0].push(6);
        stacks[0].push(7);

        // Se imprimen las torres
        System.out.printf("%s\n%s\n%s\n-------------------------------\n", stacks[0], stacks[1], stacks[2]);
        hanoi(stacks[0].size(), stacks[0], stacks[1], stacks[2]);
    }

    /**
     * Resuelve el juego de las Torres de Hanói.
     * @param n Número de discos de la torre.
     * @param stackOne Primera torre (donde están los discos).
     * @param stackTwo Segunda torre (donde se desea que estén los discos).
     * @param stackThree Tercera torre (auxiliar).
     */
    public static void hanoi(int n, Stack<Integer> stackOne, Stack<Integer> stackTwo, Stack<Integer> stackThree) {
        // Si solo hay un elemento
        if (n == 1) {
            // Se mueve de la primera torre a la segunda
            stackTwo.push(stackOne.pop());
            printAll();
        // Si no
        } else {
            // Se mueven todos los discos (menos el base) hacia la torre auxiliar
            hanoi(n - 1, stackOne, stackThree, stackTwo);
            // Se mueve la base a la torre deseada (2da torre)
            stackTwo.push(stackOne.pop());
            printAll();
            // Por último, se mueven los discos de la torre auxiliar a la torre deseada (2da torre)
            hanoi(n - 1, stackThree, stackTwo, stackOne);
        }
    }
}