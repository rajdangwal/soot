package soot.cil;

/**
 * Class representing a trap in CIL disassembly
 * 
 * @author Tobias Kussmaul
 * @author Steven Arzt
 *
 */
class Cil_Trap {
	private String tryStartLabel; 
	private String tryEndLablel;
	private String catchType;
	private String handlerStartLabel;
	private String handlerEndLabel;
	
	public Cil_Trap(String tryStartLabel, String tryEndLablel,
			String catchType, String handlerStartLabel,
			String handlerEndLabel) {
		this.tryStartLabel = tryStartLabel;
		this.tryEndLablel = tryEndLablel;
		this.catchType = catchType;
		this.handlerStartLabel = handlerStartLabel;
		this.handlerEndLabel = handlerEndLabel;
	}
	
	public String getTryStartLabel() {
		return tryStartLabel;
	}
	
	public String getTryEndLablel() {
		return tryEndLablel;
	}
	
	public String getCatchType() {
		return catchType;
	}
	
	public String getHandlerStartLabel() {
		return handlerStartLabel;
	}

	public String getHandlerEndLabel() {
		return handlerEndLabel;
	}
	
	@Override
	public String toString() {
		return "From " + tryStartLabel + " to " + tryEndLablel +  " with " + catchType;
	}

}
