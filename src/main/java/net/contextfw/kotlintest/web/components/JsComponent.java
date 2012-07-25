package net.contextfw.kotlintest.web.components;

import java.util.ArrayList;
import java.util.List;

import net.contextfw.web.application.component.Component;
import net.contextfw.web.application.component.Script;
import net.contextfw.web.application.component.ScriptElement;
import net.contextfw.web.application.lifecycle.AfterBuild;

public abstract class JsComponent extends Component {
    
    @ScriptElement(onCreate=false)
    private final List<Script> scripts = new ArrayList<Script>();

    /*
     * Performs a single update containing only some javascript call
     */
    protected void jsUpdate(Script update) {
        scripts.add(update);
        partialRefresh("jsUpdate", "scripts");
    }
    
    /*
     * Adds script to be invoked during next update
     */
    protected void addScript(Script script) {
       scripts.add(script);
    }
    
    /*
     * Clears scripts after update so that they are not called again
     * during next updates.
     */
    @AfterBuild
    public void clearJsUpdate() {
        scripts.clear();
    }

    /*
     * Called automatically whenever component is initialized. If more
     * arguments are needed, then this method must be overriden.
     */
    @ScriptElement(onUpdate=false)
    public Script jsInit() {
        return new JsInit(this);
    }
}