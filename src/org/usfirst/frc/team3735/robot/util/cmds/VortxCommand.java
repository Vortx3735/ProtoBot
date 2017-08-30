package org.usfirst.frc.team3735.robot.util.cmds;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

//import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.command.CommandGroup;
//import edu.wpi.first.wpilibj.command.Subsystem;

/*
 * A class that allows users to make triggers, that one can add to a command, that
 * modify when a command should halt. This cycles through all of the added triggers,
 * and halts the command when one of their "get" methods returns true.
 * This requires the subclass to call super.initialize() and super.isFinished() in
 * the corresponding subclass methods.
 */
public class VortxCommand extends Command{

	ArrayList<ComTrigger> triggers = new ArrayList<ComTrigger>();
	ArrayList<ComAssist> assists = new ArrayList<ComAssist>();
	
	@Override
	protected void initialize() {
		for(ComTrigger t : triggers){
			t.initialize();
		}
		for(ComAssist c : assists){
			c.initialize();
		}
	}
	
	@Override
	protected void execute(){
		for(ComAssist c : assists){
			c.execute();
		}
	}



	@Override
	protected boolean isFinished() {
		for(ComTrigger t : triggers){
			if(t.get()){
				return true;
			}
		}
		return false;
	}
	
	public VortxCommand addTrigger(ComTrigger t){
		triggers.add(t);
		for(Subsystem s : t.requirements){
			requires(s);
		}
		return this;
	}
	
	public VortxCommand addAssist(ComAssist c){
		assists.add(c);
		for(Subsystem s : c.requirements){
			requires(s);
		}
		return this;
	}
	
}
