package github.lastzu.contract;

/**
 * Request - user action for response
 *
 * @param command - current action
 * @param text
 */
public record Request (
        String command,
        String text
) {}
