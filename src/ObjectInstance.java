import java.util.HashMap;
import java.util.Map;

public final class ObjectInstance {
    public final ClassDef klass;
    public final Map<String, Value> fields = new HashMap<>();

    public ObjectInstance(ClassDef k) {
        this.klass = k;
        // initialize all fields from this class and superclasses
        for (String f : k.getAllFieldNames()) {
            fields.put(f, Value.ofInt(0));
        }
    }
}
