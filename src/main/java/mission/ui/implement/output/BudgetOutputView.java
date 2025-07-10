package mission.ui.implement.output;

import java.util.Map;
import mission.domain.lecture.LectureType;

public class BudgetOutputView {

    public void printBudgetResult(boolean totalOver, int totalExcess, Map<LectureType, Integer> exceeded) {
        if (!totalOver && exceeded.isEmpty()) {
            System.out.println("예산을 초과하지 않았습니다.");
            return;
        }

        System.out.println("예산을 초과했습니다.");
        if (totalOver) {
            System.out.printf(" - 총 예산 : %,d원 초과%n", totalExcess);
        } else {
            System.out.println(" - 총 예산 : OK");
        }

        for (LectureType type : LectureType.values()) {
            if (exceeded.containsKey(type)) {
                System.out.printf(" - %s : %,d원 초과%n", type.name(), exceeded.get(type));
            } else {
                System.out.printf(" - %s : OK%n", type.name());
            }
        }
    }
}
