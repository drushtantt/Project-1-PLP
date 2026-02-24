import java.util.*;

/**
 * Represents an interface type: name + required method names (no constructors/destructors).
 */
public final class InterfaceDef {
    public final String name;
    public final Set<String> methodNames = new HashSet<>();

    public InterfaceDef(String name) {
        this.name = name;
    }
}
