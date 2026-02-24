import java.util.*;

public final class ClassDef {
    public enum Vis { PUBLIC, PRIVATE, PROTECTED }

    public final String name;

    /** Superclass name from grammar; resolved to superclass after all types parsed. */
    public String superclassName = null;
    public ClassDef superclass = null;

    /** Interface names this class implements. */
    public final List<String> implementsList = new ArrayList<>();

    // fields: fieldName -> visibility (this class only)
    public final Map<String, Vis> fields = new LinkedHashMap<>();

    // method declarations: methodName -> visibility (this class only)
    public final Map<String, Vis> methodVis = new HashMap<>();

    // method implementations: methodName -> MethodInfo (this class only)
    public final Map<String, MethodInfo> methods = new HashMap<>();

    // convenience
    public MethodInfo constructor = null;
    public MethodInfo destructor = null;

    public ClassDef(String name) {
        this.name = name;
    }

    /** True if this class is the same as other or a subclass of other. */
    public boolean isSubclassOf(ClassDef other) {
        if (this == other) return true;
        if (superclass == null) return false;
        return superclass.isSubclassOf(other);
    }

    /** Find method in this class or superclass chain. */
    public MethodInfo getMethod(String methodName) {
        MethodInfo mi = methods.get(methodName);
        if (mi != null) return mi;
        if (superclass != null) return superclass.getMethod(methodName);
        return null;
    }

    /** Find constructor in this class or superclass chain (for instantiation). */
    public MethodInfo getConstructor() {
        if (constructor != null) return constructor;
        if (superclass != null) return superclass.getConstructor();
        return null;
    }

    /** Find class that declares this field (this or superclass). */
    public ClassDef getFieldDefiningClass(String fieldName) {
        if (fields.containsKey(fieldName)) return this;
        if (superclass != null) return superclass.getFieldDefiningClass(fieldName);
        return null;
    }

    /** Get visibility of field (from defining class). */
    public Vis getFieldVisibility(String fieldName) {
        ClassDef def = getFieldDefiningClass(fieldName);
        return def != null ? def.fields.get(fieldName) : null;
    }

    /** Find class that declares this method. */
    public ClassDef getMethodDefiningClass(String methodName) {
        if (methods.containsKey(methodName)) return this;
        if (superclass != null) return superclass.getMethodDefiningClass(methodName);
        return null;
    }

    public Vis getMethodVisibility(String methodName) {
        ClassDef def = getMethodDefiningClass(methodName);
        return def != null ? def.methodVis.get(methodName) : null;
    }

    /** True if this class implements all methods of the interface. */
    public boolean implementsInterface(InterfaceDef iface) {
        for (String m : iface.methodNames) {
            if (getMethod(m) == null) return false;
        }
        return true;
    }

    /** All field names from this class and superclasses (order: root first). */
    public List<String> getAllFieldNames() {
        List<String> out = new ArrayList<>();
        if (superclass != null) out.addAll(superclass.getAllFieldNames());
        out.addAll(fields.keySet());
        return out;
    }

    public static final class MethodInfo {
        public final String className;
        public final String methodName;
        public final boolean isFunction; // procedure vs function
        public final List<String> paramNames;
        public final delphiParser.BlockContext body; // AST for the block

        public MethodInfo(String className, String methodName, boolean isFunction,
                          List<String> paramNames, delphiParser.BlockContext body) {
            this.className = className;
            this.methodName = methodName;
            this.isFunction = isFunction;
            this.paramNames = paramNames;
            this.body = body;
        }
    }
}
