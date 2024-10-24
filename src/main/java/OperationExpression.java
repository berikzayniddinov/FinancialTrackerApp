// Class for operations (addition and subtraction)
class OperationExpression implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;
    private char operator;

    public OperationExpression(Expression leftExpression, Expression rightExpression, char operator) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
    }

    @Override
    public int interpret() {
        switch (operator) {
            case '+':
                return leftExpression.interpret() + rightExpression.interpret();
            case '-':
                return leftExpression.interpret() - rightExpression.interpret();
            default:
                throw new IllegalArgumentException("Unsupported operation: " + operator);
        }
    }
}