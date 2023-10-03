package github.lastzu.contract;

import java.util.List;

public record Response(
        List<String> commands,
        String text
) {}
