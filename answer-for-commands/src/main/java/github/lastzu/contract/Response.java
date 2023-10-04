package github.lastzu.contract;

import java.util.List;

/**
 * Response - returned object from any Answer
 *
 * @param commands - list of valid actions for next request
 * @param text
 */
public record Response(
        String id,
        List<String> commands,
        String text
) {}
