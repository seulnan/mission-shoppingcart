package mission.domain.cart.budget;

import java.util.List;
import mission.domain.lecture.Lecture;
import java.util.Map;

//public interface BudgetPolicy {
//    boolean isTotalOver(int totalPrice);
//    Map<String, Integer> getOverCategoryBudgets(List<Lecture> lectures);
//}

import mission.domain.cart.Cart;

public interface BudgetPolicy {
    void validate(Cart cart);
}
