
import java.util.Stack;


public class Pila {

    Stack<Character> pila;

    public Pila(){
        pila = new Stack<Character>();
    }

    public boolean estaVacia(){
        return pila.isEmpty();
    }

    public void push(Character c){
        pila.push(c);
    }

    public Character pop() throws Exception{
        if (estaVacia())
            throw new Exception("codigo no balanceado");
        return pila.pop();
    }

    public boolean balanceado(String codigo) throws Exception{
        Pila p1 = new Pila();

        for (int i = 0; i < codigo.length(); i++){
            char ac = codigo.charAt(i);

            if (ac == '(' || ac == '{' || ac == '['){
                p1.push(ac);
            }else {
                if (ac == ')' || ac == '}' || ac == ']'){
                    if (p1.estaVacia()) return false;

                    Character ap = p1.pop();

                    if (((ac == ')') && (ap != '(')) ||
                            ((ac == ']') && (ap != '[')) ||
                            ((ac == '}') && (ap != '{'))) {
                        return false;
                    }
                }
            }
        }

        return p1.estaVacia();

    }

}
