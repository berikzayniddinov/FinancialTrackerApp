// Interpreter that evaluates and parses expressions
class Interpreter {
    public static int evaluate(String expression) {
        String[] tokens = expression.split(" ");
        Expression result = new NumberExpression(Integer.parseInt(tokens[0]));

        for (int i = 1; i < tokens.length; i += 2) {
            char operator = tokens[i].charAt(0);
            Expression right = new NumberExpression(Integer.parseInt(tokens[i + 1]));
            result = new OperationExpression(result, right, operator);
        }
        return result.interpret();
    }
}