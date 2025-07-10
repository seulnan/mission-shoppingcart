package mission.ui.implement.input;

import api.Console;
import mission.common.validate.Validator;
import mission.domain.cart.budget.implement.TotalBudget;
import mission.ui.exception.InputError;
import mission.ui.exception.InvalidInputException;

public class TotalBudgetInputView {

    public TotalBudget input() {
        System.out.println("총 예산을 입력해 주세요.");
        try {
            String input = Validator.notNull(Console.readLine(), InputError.NULL_INPUT.getMessage()).trim();
            return new TotalBudget(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new InvalidInputException(InputError.INVALID_BUDGET);
        }
    }
}
