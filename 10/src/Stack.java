import java.lang.reflect.Array;
import java.util.Arrays;

public class Stack<T> {
    private int m_currSize;
    private final int m_max;
    private final T[] stack;

    public Stack(int max, Class<T[]> classT) {
        this.stack = classT.cast(Array.newInstance(classT.getComponentType(), max));
        m_currSize = -1;
        m_max = max;
    }

    public boolean isEmpty() {
        return m_currSize == -1;
    }

    public boolean isFull() {
        return m_currSize == m_max - 1;
    }

    public void push(T x) throws StackOverflowException {
        if (isFull()) {
            throw new StackOverflowException("BLAD DANYCH WEJSCIOWYCH! Koniec algorytmu, a stos nie jest pusty    " + x);
        } else {
            m_currSize++;
            stack[m_currSize] = x;
        }
    }

    public T pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException("BLAD DANYCH WEJSCIOWYCH! Na stosie jest za malo elementow zeby wykonac operacje!");
        } else {
            return stack[m_currSize--];
        }
    }

    static boolean isOperand(char x) {
        return (x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z');
    }

    @Override
    public String toString() {
        return Arrays.toString(stack);
    }

    public static void main(String[] args) {
//        String str = args[0]; też działa dla liter i operatorow
        String str = "ab+-";
        Stack<String> stack = new Stack<>(12, String[].class);
        try {
            for (int i = 0; i < str.length(); i++) {
                if (isOperand(str.charAt(i))) {
                    stack.push(str.charAt(i) + "");
                } else {
                    String val1 = stack.pop();
                    String val2 = stack.pop();
                    stack.push("(" + val2 + str.charAt(i) + val1 + ")");
                }
            }
            System.out.println("Wynik: " + stack.pop());
        } catch (StackOverflowException | StackUnderflowException e) {
            System.err.println(e);
        }
    }
}


