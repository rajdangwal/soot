package soot.dava;

import soot.*;
import java.util.*;
import soot.jimple.*;
import soot.util.*;

public class WhileTrunk extends AbstractTrunk
{
    Trunk wTrunk;
    ValueBox conditionBox;
    
    WhileTrunk(ConditionExpr e, Trunk wTrunk)
    {
        conditionBox = Jimple.v().newConditionExprBox(e);
        
        this.wTrunk = wTrunk;
	Removed = false;
	successors = new ArrayList();
	predecessors = new ArrayList();
	contents = new ArrayChain();
	contents.add( wTrunk);
	Branches = false;

	setCondition( e);
    }

    public void maskGotoStmt()
    {
	wTrunk.maskGotoStmt();
    }

    public Stmt getFirstStmt() 
    {
	return firstStmt;
    }

    public Stmt getLastStmt() 
    {
	return wTrunk.getLastStmt();
    }

    public Stmt getTarget()
    {
	return wTrunk.getTarget();
    }

    public Trunk getWhileBody()
    {
        return wTrunk;
    }
        
    public List getChildren()
    {
        List l = new ArrayList();
        
        l.add( wTrunk);
        
        return Collections.unmodifiableList(l);
    }
    
    public Object clone()
    {
        return new WhileTrunk((ConditionExpr) getCondition().clone(), 
            (Trunk) getWhileBody().clone());
    }
    
    
    protected String toString(boolean isBrief, Map stmtToName, String indentation)
    {
        String endOfLine = (indentation.equals("")) ? " " : StringTools.lineSeparator;
        StringBuffer b = new StringBuffer();
        
	if (getCondition() == null) {
	    System.err.println("Error:  \"while\" has no condition.");
	    System.exit(0);
	}


        b.append(indentation + "while (" + 
            ((isBrief) ? ((ToBriefString) getCondition()).toBriefString() : getCondition().toString()) + ")" + endOfLine);
            
        b.append(indentation + "{" + endOfLine);
        b.append(((isBrief) ? getWhileBody().toBriefString(stmtToName, indentation + "    ") : 
                           getWhileBody().toString(stmtToName, indentation + "    ")));
        b.append(indentation + "}" + endOfLine);

        return b.toString();
    }
}
