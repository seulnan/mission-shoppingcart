package mission.domain.cart.budget.implement;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import mission.domain.lecture.LectureType;

public class CategoryBudget {
    private final Map<LectureType, Integer> budgetByType;

    public CategoryBudget(Map<LectureType, Integer> budgetByType) {
        this.budgetByType = new EnumMap<>(budgetByType);
    }

    public Map<LectureType, Integer> getExceeded(Map<LectureType, Integer> totalByType) {
        return totalByType.entrySet().stream()
                .filter(entry -> isOver(entry.getKey(), entry.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> excessAmount(entry.getKey(), entry.getValue())
                ));
    }

    private boolean isOver(LectureType type, int total) {
        return budgetByType.containsKey(type) && total > budgetByType.get(type);
    }

    private int excessAmount(LectureType type, int total) {
        return total - budgetByType.get(type);
    }
}
