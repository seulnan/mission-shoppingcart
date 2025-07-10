package mission.ui.implement.input;

import api.Console;
import java.util.*;
import java.util.stream.Collectors;
import mission.common.validate.Validator;
import mission.ui.exception.InputError;
import mission.ui.exception.InvalidInputException;
import mission.ui.validate.InputValidator;


public class LectureInputView {

    public List<Integer> inputLectureIds() {
        System.out.println("구입할 강의 목록을 입력해주세요.");
        try {
            String input = Validator.notNull(Console.readLine(), InputError.NULL_INPUT.getMessage()).trim();
            List<Integer> ids = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            InputValidator.validateNotEmpty(ids);
            InputValidator.validateNoDuplicate(ids);
            return ids;
        } catch (NumberFormatException e) {
            throw new InvalidInputException(InputError.INVALID_LECTURE_ID);
        }
    }
}
