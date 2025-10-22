import java.util.*;

public class YodaCalc {
    private static HashMap<String, Integer> operatorMap = new HashMap<String, Integer>() {
        {
            put("+", 1);
            put("-", 1);
            put("*", 2);
            put("/", 2);
            put("(", 0);
            put(")", 3);
        }
    };

    private static ArrayList<String> digitList = new ArrayList<String>() {
        {
            add("0");
            add("1");
            add("2");
            add("3");
            add("4");
            add("5");
            add("6");
            add("7");
            add("8");
            add("9");
        }
    };

    /**
     * This method takes in the input string,
     * evaluates the math expression, and
     * returns the result as a decimal value.
     * 
     * @param input the input math string,
     *              supporting: +, -, *, /, (, )
     * @return the evaluated result
     */
    public static double calc(String input) {
        input = removeSpaces(input);
        Stack<String> postfix = getPostfix(input);
        double result = evaluate(postfix);

        return result;
    }

    public static String removeSpaces(String input) {
        return input.replace(" ", "");
    }

    public static Stack<String> getPostfix(String input) {
        Stack<String> operatorStack = new Stack<String>();
        Stack<String> operandStack = new Stack<String>();
        Stack<String> postfix = new Stack<String>();
        String curr;

        while (input.length() > 0) {
            curr = String.valueOf(input.charAt(0));
            input = input.substring(1);
            if (digitList.contains(curr)) {
                if (input.length() > 0) {
                    while (input.length() > 0 && digitList.contains(String.valueOf(input.charAt(0)))) {
                        curr = curr + input.charAt(0);
                        input = input.substring(1);
                    }
                }
                operandStack.push(curr);
            } else if (operatorMap.keySet().contains(curr)) {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(curr);
                } else if (curr.equals("(")) {
                    operatorStack.push(curr);
                } else if (curr.equals(")") && !(operatorStack.peek().equals("("))) {
                    while ((!operatorStack.peek().equals("("))) {
                        operandStack.push(operatorStack.pop());
                    }
                    operatorStack.pop();
                } else if (curr.equals(")") && operatorStack.peek().equals("(")) {
                    operatorStack.pop();
                } else if (operatorMap.get(curr) > operatorMap.get(operatorStack.peek())) {
                    operatorStack.push(curr);
                } else {
                    while (!operatorStack.isEmpty() && operatorMap.get(curr) <= operatorMap.get(operatorStack.peek())) {
                        operandStack.push(operatorStack.pop());
                    }
                    operatorStack.push(curr);
                }
            } else {
                System.out.println("Invalid character: " + curr);
                break;
            }
        }
        while (!operatorStack.isEmpty()) {
            operandStack.push(operatorStack.pop());
        }
        while (!operandStack.isEmpty()) {
            postfix.push(operandStack.pop());
        }
        return postfix;
    }

    public static double evaluate(Stack<String> postfix) {
        Stack<Double> operandStack = new Stack<Double>();
        String curr;
        double operand1;
        double operand2;
        double result;

        while (!postfix.isEmpty()) {
            curr = postfix.pop();
            if (Character.isDigit(curr.charAt(0))) {
                operandStack.push(Double.parseDouble(String.valueOf(curr)));
            } else if (operatorMap.keySet().contains(curr) && !(curr.equals("(") || curr.equals(")"))) {
                operand2 = operandStack.pop();
                operand1 = operandStack.pop();
                result = operate(operand1, operand2, curr);
                operandStack.push(result);
            } else {
                System.out.println("Invalid character: " + curr);
            }
        }
        return operandStack.pop();
    }

    public static double operate(double operand1, double operand2, String operator) {
        double result = 0;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 == 0) {
                    System.out.println("Cannot divide by 0");
                    break;
                }
                result = operand1 / operand2;
                break;
            default:
                System.out.println("Invalid operator: " + operator);
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "256+312-9456 + 11 - 77887";
        Double result = calc(input);
        System.out.println(result);
    }
}
