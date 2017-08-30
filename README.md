# ProtoBot
Easy to use command based robot for prototype testing

-Attach commands to controller buttons in the robotInit() method in Robot.java

-Give names to buttons controlling sets of motors, and modify the speed on the Smartdashboard

-Invert motors easily with signed port numbers

		Example: con.a.toggleWhenPressed(new MotorsOn(new int[]{3, -9}, 1, "Scaler"));
		Example: con.b.toggleWhenPressed(new SolenoidsOn(new int[] {1,2}));
