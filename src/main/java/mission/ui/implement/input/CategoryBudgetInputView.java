package mission.ui.implement.input;

public class CategoryBudgetInputView {

    public CategoryBudget input() {
        System.out.println("유형별 예산을 입력해 주세요.");
        try {
            String input = Validator.notNull(Console.readLine(), InputError.NULL_INPUT.getMessage()).trim();
            String[] tokens = input.split(",");

            Map<LectureType, Integer> budgetMap = new HashMap<>();
            for (String token : tokens) {
                String[] parts = token.split("-");
                LectureType type = LectureType.from(parts[0].trim());
                int budget = Integer.parseInt(parts[1].trim());
                budgetMap.put(type, budget);
            }
            return new CategoryBudget(budgetMap);
        } catch (Exception e) {
            throw new InvalidInputException(InputError.INVALID_BUDGET);
        }
    }
}
