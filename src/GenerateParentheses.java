import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    /*
    22.

    */

    public List<String> generateParenthesis(int n) {
        List<String> parentheses = new ArrayList<>();
        generateParenthesisHelper(new StringBuilder(), parentheses, n, 0, 0);
        return parentheses;
    }

    private void generateParenthesisHelper(StringBuilder sb, List<String> list, int n, int opens, int closes) {
        if (opens < closes) {
            return;
        }
        if (opens > n) {
            return;
        }
        if (closes == n) {
            list.add(sb.toString());
            return;
        }
        sb.append("(");
        generateParenthesisHelper(sb, list, n, opens + 1, closes);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(")");
        generateParenthesisHelper(sb, list, n, opens, closes + 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}
