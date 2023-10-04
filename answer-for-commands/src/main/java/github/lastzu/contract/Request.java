package github.lastzu.contract;

/**
 * Request - user action for response
 *
 * @param command - current action
 * @param text
 */
public record Request (
        String id,
        String command,
        String text
) {}
