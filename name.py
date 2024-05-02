class ExpressionParser:
    precedence = {'/': 1, '*': 1, '+': 2, '-': 2}

    @staticmethod
    def precedence_of(token):
        return ExpressionParser.precedence.get(token, -1)

    @staticmethod
    def main():
        expr = input("\nEnter an expression for calculating Address codes: ")
        operators = [(token, i) for i, token in enumerate(expr) if token in ExpressionParser.precedence]

        print("\nOperators:\nOperators\tLocation number\n")
        for op, loc in operators:
            print(f"{op}\t\t{loc}")

        operators.sort(key=lambda x: ExpressionParser.precedence_of(x[0]))

        print("\nOperators sorted in their precedence:\nOperators\tLocation number\n")
        for op, loc in operators:
            print(f"{op}\t\t{loc}")

        print()
        processed = [False] * len(expr)
        for i, (op, loc) in enumerate(operators):
            j = loc
            op1, op2 = '', ''

            if processed[j - 1]:
                prev_op, prev_loc = operators[i - 1]
                if ExpressionParser.precedence_of(prev_op) == ExpressionParser.precedence_of(op):
                    op1 = f"t{i}"
                else:
                    for x, (x_op, x_loc) in enumerate(operators):
                        if j - 2 == x_loc:
                            op1 = f"t{x + 1}"
                            break
            else:
                op1 = expr[j - 1]

            if processed[j + 1]:
                for x, (x_op, x_loc) in enumerate(operators):
                    if j + 2 == x_loc:
                        op2 = f"t{x + 1}"
                        break
            else:
                op2 = expr[j + 1]

            print(f"t{i + 1} = {op1}{op}{op2}")
            processed[j - 1:j + 2] = [True] * 3

if __name__ == "__main__":
    ExpressionParser.main()
