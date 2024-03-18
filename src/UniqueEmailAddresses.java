import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    /*
    929.

    requirement:
    Every valid email consists of a local name and a domain name,
    separated by the '@' sign. Besides lowercase letters, the email may contain one or more '.' or '+'.

    For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
    If you add periods '.' between some characters in the local name part of an email address,
    mail sent there will be forwarded to the same address without dots in the local name.
    Note that this rule does not apply to domain names.

    For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
    If you add a plus '+' in the local name, everything after the first plus sign will be ignored.
    This allows certain emails to be filtered. Note that this rule does not apply to domain names.

    For example, "m.y+name@email.com" will be forwarded to "my@email.com".
    It is possible to use both of these rules at the same time.

    Given an array of strings emails where we send one email to each emails[i],
    return the number of different addresses that actually receive mails.

    test case:
    m.y+name@email.com --> my@email.com

    solution:

    */

    public int differentiateEmailAddress(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            set.add(formatEmail(email));
        }
        return set.size();
    }

    private String formatEmail(String email) {
        StringBuilder sb = new StringBuilder();
        boolean skippedInLocal = false;
        boolean isDomain = false;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                isDomain = true;
            }
            if (isDomain) {
                sb.append(email.charAt(i));
                continue;
            }

            if (email.charAt(i) == '.') {
                continue;
            }
            if (email.charAt(i) == '+') {
                skippedInLocal = true;
            }
            if (skippedInLocal) {
                continue;
            }
            sb.append(email.charAt(i));
        }
        return sb.toString();
    }

    private String formatEmailUsingBuiltinFunction(String email) {
        String local = email.split("@")[0];
        String domain = email.split("@")[1];
        String usedLocal = local.split("\\+")[0];
        String formatUsedLocal = usedLocal.replace(".", "");
        return formatUsedLocal + "@" + domain;
    }
}
