import java.util.*;

public final class RuntimeEnv {
    public final Map<String, ClassDef> classes = new HashMap<>();
    public final Map<String, InterfaceDef> interfaces = new HashMap<>();
    public final Deque<Frame> stack = new ArrayDeque<>();

    // execution context for encapsulation + self
    public final Deque<ClassDef> classCtx = new ArrayDeque<>();
    public final Deque<ObjectInstance> selfCtx = new ArrayDeque<>();

    public RuntimeEnv() {
        stack.push(new Frame()); // global frame
    }

    public Frame frame() {
        return stack.peek();
    }

    public void pushFrame(Frame f) {
        stack.push(f);
    }

    public void popFrame() {
        stack.pop();
    }

    public void declareVar(String name, Value init) {
        frame().vars.put(name, init);
        frame().varTypes.put(name, null);
    }

    public void declareVar(String name, String typeName, Value init) {
        frame().vars.put(name, init);
        frame().varTypes.put(name, typeName);
    }

    /** Get declared type name for a variable (first frame that has it). */
    public String getVarType(String name) {
        for (Frame f : stack) {
            if (f.varTypes.containsKey(name)) return f.varTypes.get(name);
        }
        return null;
    }

    public Value getVar(String name) {
        for (Frame f : stack) {
            if (f.vars.containsKey(name)) return f.vars.get(name);
        }
        throw new RuntimeException("Undefined variable: " + name);
    }

    public boolean isDeclaredSomewhere(String name) {
        for (Frame f : stack) {
            if (f.vars.containsKey(name)) return true;
        }
        return false;
    }

    public void setVar(String name, Value v) {
        for (Frame f : stack) {
            if (f.vars.containsKey(name)) {
                String declaredType = f.varTypes.get(name);
                if (declaredType != null && interfaces.containsKey(declaredType)) {
                    if (v.kind != Value.Kind.OBJ)
                        throw new RuntimeException("Variable " + name + " has interface type " + declaredType + "; expected object");
                    InterfaceDef iface = interfaces.get(declaredType);
                    if (!v.objVal.klass.implementsInterface(iface))
                        throw new RuntimeException("Class " + v.objVal.klass.name + " does not implement interface " + declaredType);
                }
                f.vars.put(name, v);
                return;
            }
        }
        throw new RuntimeException("Assignment to undeclared variable: " + name);
    }

    /** Resolve superclass references after all types are loaded. */
    public void resolveSuperclasses() {
        for (ClassDef cd : classes.values()) {
            if (cd.superclassName != null) {
                ClassDef superDef = classes.get(cd.superclassName);
                if (superDef == null)
                    throw new RuntimeException("Unknown superclass: " + cd.superclassName);
                cd.superclass = superDef;
            }
        }
    }

    public boolean inClassContext(ClassDef cd) {
        return !classCtx.isEmpty() && classCtx.peek() == cd;
    }

    public ObjectInstance currentSelf() {
        if (selfCtx.isEmpty()) throw new RuntimeException("No 'self' in current context");
        return selfCtx.peek();
    }
}
