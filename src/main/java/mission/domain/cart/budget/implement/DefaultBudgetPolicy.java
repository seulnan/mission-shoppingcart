package mission.domain.cart.budget.implement;

import java.util.Map;
import mission.domain.cart.Cart;
import mission.domain.cart.budget.BudgetPolicy;
import mission.domain.lecture.LectureType;
import mission.ui.implement.output.BudgetOutputView;

public class DefaultBudgetPolicy implements BudgetPolicy {
    private final TotalBudget totalBudget;
    private final CategoryBudget categoryBudget;
    private final BudgetOutputView outputView;

    public DefaultBudgetPolicy(
            TotalBudget totalBudget,
            CategoryBudget categoryBudget,
            BudgetOutputView outputView
    ) {
        this.totalBudget = totalBudget;
        this.categoryBudget = categoryBudget;
        this.outputView = outputView;
    }

    @Override
    public void validate(Cart cart) {
        int totalPrice = cart.calculateTotalPrice();
        boolean isTotalOver = totalBudget.isOver(totalPrice);
        int totalExcess = totalBudget.excessAmount(totalPrice);

        Map<LectureType, Integer> categoryTotals = cart.calculateTotalPriceByCategory();
        Map<LectureType, Integer> exceeded = categoryBudget.getExceeded(categoryTotals);

        outputView.printBudgetResult(isTotalOver, totalExcess, exceeded);
    }
}
